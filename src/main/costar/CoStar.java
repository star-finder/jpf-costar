package costar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jacoco.core.instr.Instrumenter;
import org.jacoco.core.internal.InputStreams;
import org.jacoco.core.runtime.IExecutionDataAccessorGenerator;
import org.jacoco.core.runtime.URLStreamHandlerRuntime;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import costar.config.CoStarConfig;
import costar.instrumenter.ClassInstrumenterVisitor;
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

		if(verbose) {
			logger.info(config);
			logger.info(cc);
		}

		// prepare config
		Config jpfConf = cc.generateJPFConfig(config);
		
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

		if(verbose) {
			logger.info(jpfConf);
		}
		
		// run jpf ...
		JPF jpf = new JPF(jpfConf);
		jpf.getReporter().getPublishers().clear();
		jpf.run();

		Solver.terminate();
		
		revert();
		logger.info("CoStar.run() -- end");
		
		long endTime = System.currentTimeMillis();
		logger.info("Time = " + ((endTime - startTime) / 1000));
	}

	public static void revert() {
		final String source = "/Users/HongLongPham/Workspace/JPF_HOME/jpf-star/build/examples/avl/tmp/AvlTree.class";
		final String dest = "/Users/HongLongPham/Workspace/JPF_HOME/jpf-star/build/examples/avl";
		
		try {
			(new File(dest + "/AvlTree.class")).delete();
			FileUtils.copyFile(new File(source), new File(dest));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void instrument(Config conf) {
		final IExecutionDataAccessorGenerator runtime = new URLStreamHandlerRuntime();
		final Instrumenter instr = new Instrumenter(runtime);
		final String source = "/Users/HongLongPham/Workspace/JPF_HOME/jpf-star/build/examples/avl/AvlTree.class";
		final String name = "AvlTree.class";
		
		final String dest = "/Users/HongLongPham/Workspace/JPF_HOME/jpf-star/build/examples/avl/tmp";
		
		try {
			FileUtils.copyFile(new File(source), new File(dest));
			
			InputStream original = new FileInputStream(source);
			
//			byte[] instrumented = instr.instrument(original, name);
//			original.close();
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
			ClassReader cr = new ClassReader(InputStreams.readFully(original));		
			ClassVisitor cv = new ClassInstrumenterVisitor(cw, cr.getClassName());
			
			cr.accept(cv, 0);
			byte[] instrumented = cw.toByteArray();
			
			Files.write(Paths.get(source), instrumented);
			System.out.println("Count = " + ((ClassInstrumenterVisitor) cv).getCount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialize(Config jpfConf) {
		String data = jpfConf.getProperty("costar.data");
		if (data != null)
			Initializer.initDataNode(data);
		
		String pred = jpfConf.getProperty("costar.predicate");
		if(pred == null) {
			pred = jpfConf.getProperty("costar.predicate.file");
			if(pred != null)
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
