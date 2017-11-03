package costar.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import costar.CoStarPerturbator;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

public class CoStarConfig {

	private static final String CONF_PREFIX = "concolic";

	private final Map<String, ConcolicMethodConfig> concolicMethods = new HashMap<>();

	public CoStarConfig(Config conf) {
		initialize(conf);
	}

	public ConcolicMethodConfig getMethodConfig(String id) {
		ConcolicMethodConfig mc = concolicMethods.get(id);
		return mc;
	}

	public Collection<ConcolicMethodConfig> getMethodConfigs() {
		return concolicMethods.values();
	}

	public Config generateJPFConfig() {
		return generateJPFConfig(null);
	}

	public Config generateJPFConfig(Config conf) {
		Config newConf = new Config("");
		if (conf != null) {
			newConf.putAll(conf);
			newConf.setClassLoader(conf.getClassLoader());
		} else {
			newConf.initClassLoader(JPF.class.getClassLoader());
		}

		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (ConcolicMethodConfig mc : concolicMethods.values()) {
			generatePerturbConfig(mc, newConf);
			if (first)
				first = false;
			else
				sb.append(',');
			sb.append(mc.getId());
		}

		newConf.setProperty("perturb.params", sb.toString());

		return newConf;
	}

	private static void generatePerturbConfig(ConcolicMethodConfig mc, Config conf) {
		String perturbPrefix = "perturb." + mc.getId() + ".";
		String perturbMethod = mc.toJPFPerturbString();

		conf.setProperty(perturbPrefix + "method", perturbMethod);
		conf.setProperty(perturbPrefix + "class", CoStarPerturbator.class.getName());

		String loc = mc.getLocation();
		if (loc != null)
			conf.setProperty(perturbPrefix + "location", loc);
	}

	public void registerConcolicMethod(ConcolicMethodConfig mc) {
		concolicMethods.put(mc.getId(), mc);
	}

	public void clearConcolicMethods() {
		concolicMethods.clear();
	}

	private void initialize(Config conf) {
		// parse symbolic method info
		if (conf.hasValue(CONF_PREFIX + ".method")) {
			String id = conf.getString(CONF_PREFIX + ".method");
			ConcolicMethodConfig mc = ConcolicMethodConfig.read(id, CONF_PREFIX + ".method." + id, conf);
			registerConcolicMethod(mc);
		}
	}

}
