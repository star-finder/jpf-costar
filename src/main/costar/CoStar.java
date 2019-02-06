package costar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jacoco.core.internal.InputStreams;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import costar.config.CoStarConfig;
import costar.instrumenter.ClassInstrumenter;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.JPFShell;
import gov.nasa.jpf.util.FileUtils;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.util.LogManager;
import starlib.precondition.Initializer;
import starlib.solver.Solver;

public class CoStar implements JPFShell {

	private Config config;

	private CoStarConfig cc;

	private JPFLogger logger;

	private boolean verbose = false;

	public static final String CONFIG_KEY_COSTAR_EXPLORER = "costar.costar_explorer_instance";

	public CoStar(Config config) {
		LogManager.init(config);
		this.config = config;
		this.cc = new CoStarConfig(config);
		this.logger = JPF.getLogger("costar");
	}

	public void start(String[] strings) {
		run();
	}

	public void run() {
		long startTime = System.currentTimeMillis();

		logger.info("CoStar.run() -- begin");

		if (verbose) {
			logger.info(config);
			logger.info(cc);
		}

		// prepare config
		Config jpfConf = cc.generateJPFConfig(config);

		boolean isInstrument = Boolean.parseBoolean(jpfConf.getProperty("costar.instrument", "false"));
		if (isInstrument)
			instrument(jpfConf);

		// Configure JPF
		jpfConf.remove("shell");
		jpfConf.setProperty("jvm.insn_factory.class", CoStarInstructionFactory.class.getName());

		String listener = CoStarListener.class.getName();
		if (jpfConf.hasValue("listener"))
			listener += ";" + jpfConf.getString("listener");
		jpfConf.setProperty("listener", listener);
		jpfConf.setProperty("perturb.class", CoStarPerturbator.class.getName());
		jpfConf.setProperty(CONFIG_KEY_COSTAR_EXPLORER, CoStarExplorer.class.getName());

		initialize(jpfConf);

		if (verbose) {
			logger.info(jpfConf);
		}

		// run jpf ...
		JPF jpf = new JPF(jpfConf);
		jpf.getReporter().getPublishers().clear();
		jpf.run();

		Solver.terminate();

		if (isInstrument)
			revert(jpfConf);
		logger.info("CoStar.run() -- end");

		long endTime = System.currentTimeMillis();
		logger.info("Call = " + Solver.getCount());
		logger.info("Time = " + ((endTime - startTime)));
	}

	public static void revert(Config conf) {
		final String source = conf.getProperty("costar.dest");
		final String dest = conf.getProperty("costar.source");
		final String[] clazzes = conf.getProperty("costar.class").split(";");

		for (String clazz : clazzes) {
			try {
				new File(dest + clazz).delete();
				FileUtils.copyFile(new File(source + clazz), new File(dest));
				
				new File(source + clazz).delete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		new File(dest + "BitMap.class").delete();
		new File(source).delete();
	}

	public static void instrument(Config conf) {
		final String source = conf.getProperty("costar.source");
		final String dest = conf.getProperty("costar.dest");
		final String[] clazzes = conf.getProperty("costar.class").split(";");
		
		new File(dest).mkdirs();
		
		int length = clazzes.length;
		
		String pack = conf.getProperty("star.test_package");
		String className = clazzes[length - 1];
		className = pack + "/" + "BitMap";

		for (int i = 0; i < length; i++) {
			String clazz = clazzes[i];
			
			try {
				FileUtils.copyFile(new File(source + clazz), new File(dest));
	
				InputStream stream = new FileInputStream(source + clazz);
				byte[] original = InputStreams.readFully(stream);
	
				ClassNode cn = new ClassNode();
				ClassReader cr = new ClassReader(original);
				cr.accept(cn, 0);
				
				ClassInstrumenter ci = new ClassInstrumenter();
				ci.transform(cn, className, false);
				
				ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			    cn.accept(cw);
			    byte[] instrumented = cw.toByteArray();
	
				Files.write(Paths.get(source + clazz), instrumented);
				int count = ci.getCount();
//				System.out.println("Count = " + count);
	
				conf.setProperty("costar.bitmap_size", count + "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ClassNode cn = new ClassNode();
		
		ClassInstrumenter ci = new ClassInstrumenter();
		ci.transform(cn, className, true);
		
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
	    cn.accept(cw);
	    byte[] instrumented = cw.toByteArray();

		try {
			Files.write(Paths.get(source + "BitMap.class"), instrumented);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialize(Config jpfConf) {
		String data = jpfConf.getProperty("costar.data");
		if (data != null)
			Initializer.initDataNode(data);

		String pred = jpfConf.getProperty("costar.predicate");
		if (pred == null) {
			pred = jpfConf.getProperty("costar.predicate.file");
			if (pred != null)
				try {
					Initializer.initPredicateFromFile(pred);
				} catch (IOException e) {
					e.printStackTrace();
				}
		} else {
			Initializer.initPredicate(pred);
		}

		String pre = jpfConf.getProperty("costar.precondition");
		if (pre != null)
			Initializer.initPrecondition(pre);
	}

	public static CoStarExplorer getCoStarExplorer(Config config) {
		CoStarExplorer explorer = config.getEssentialInstance(CONFIG_KEY_COSTAR_EXPLORER, CoStarExplorer.class);
		if (!explorer.isConfigured()) {
			explorer.configure(new CoStarConfig(config));
		}

		return explorer;
	}

}
