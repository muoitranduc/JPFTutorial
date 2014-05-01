import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.Config;

public class MainApp {
	private String targetClass;
	private String classPath;
	private String sourcePath;
	private String inputString;  
	private String options;
	private String outputString;
	private String targetFile;
	private String reportFile;
	
	public String getTargetClass() {
		return targetClass;
	}
	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}
	public String getClassPath() {
		return classPath;
	}
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
	public String getSourcePath() {
		return sourcePath;
	}
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	public String getInputString() {
		return inputString;
	}
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getOutputString() {
		return outputString;
	}
	public void setOutputString(String outputString) {
		this.outputString = outputString;
	}
	public String getTargetFile() {
		return targetFile;
	}
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}
	public String getReportFile() {
		return reportFile;
	}
	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}
	
	public MainApp(){
		// default constructor
		setTargetClass("Target");
		setClassPath(".\\bin");
		setSourcePath(".\\src");
		setOptions("error,trace");
		setTargetFile(this.sourcePath + "\\" + this.targetClass + ".java");
		setReportFile(this.sourcePath + "\\report"); 
	}
	
	public void printToFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(this.targetFile);
		writer.println(this.inputString);
		writer.close();
	}
	
	public void setOutputString(String path, Charset encoding) throws IOException{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		this.outputString = new String(encoded, encoding);
	}
	
	public void deleteFile(String fileName){
		File tempFile = new File(fileName);
		tempFile.deleteOnExit();
	}
//========================================================================================
	
	public static void main(String[] args) throws IOException{
		MainApp mainApp = new MainApp();
		String inString = " public class Target {" +
				"static class Fork {}" +
				"static class Philosopher extends Thread {" +
				"Fork left, right;" +
				"public Philosopher(Fork left, Fork right) {" +
				"this.left = left;" +
				"this.right = right;}" +
				"public void run() {" +
				"synchronized (left) {" +
				"synchronized (right) {}}}}" +
				"static int nPhilosophers = 6;" +
				"public static void main(String[] args) {" +
				"if (args.length > 0){" +
				"nPhilosophers = Integer.parseInt(args[0]);}" +
				"Fork[] forks = new Fork[nPhilosophers];" +
				"for (int i = 0; i < nPhilosophers; i++) {" +
				"forks[i] = new Fork();}" +
				"for (int i = 0; i < nPhilosophers; i++) {" +
				"Philosopher p = new Philosopher(forks[i], forks[(i + 1) % nPhilosophers]);" +
				"p.start();}}}";
		mainApp.setInputString(inString);
		mainApp.printToFile();
		
		//Config config = JPF.createConfig(args);
		Config config = new Config(new InputStreamReader(MainApp.class.getResourceAsStream("jpf-config")));
		config.setProperty("target", mainApp.targetClass);
		//config.setProperty("report.console.start", "");
		//config.setProperty("report.console.finished", "");
		config.setProperty("jpf.home", "${user.home}/workspace");
		config.setProperty("jpf-core", " ${user.home}/workspace/jpf-core");
		config.setProperty("extensions", "${jpf-core}");
		config.setProperty("report.console.property_violation", mainApp.options);
		config.setProperty("report.console.file", mainApp.reportFile);
		config.setProperty("classpath", mainApp.classPath);
		config.setProperty("sourcepath", mainApp.sourcePath);
		
		JPF jpf = new JPF(config);
		
		jpf.run();
		
		mainApp.setOutputString(mainApp.reportFile, Charset.defaultCharset());
		
		/*mainApp.deleteFile(mainApp.targetFile);
		mainApp.deleteFile(mainApp.reportFile);*/
		
		System.out.println(mainApp.outputString);
	}

}
