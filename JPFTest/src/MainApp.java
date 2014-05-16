import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/*import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;*/

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
		setReportFile(this.sourcePath + "\\report.out");
	}
	
	public void printToFile(){
		File tempFile = new File(this.targetFile);
		try {
			tempFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(tempFile);
			writer.println(this.inputString);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void readFile( String file ) {
	    BufferedReader reader = null;
		try {
			reader = new BufferedReader( new FileReader (file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
			while( ( line = reader.readLine() ) != null ) {
			    stringBuilder.append( line );
			    stringBuilder.append( ls );
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    this.outputString =  stringBuilder.toString();
	}
	/*public void setOutputString(String path, Charset encoding) throws IOException{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		this.outputString = new String(encoded, encoding);
	}*/
	
	public void createFile(String fileName){
		File tempFile = new File(fileName);
		try {
			//System.out.println(tempFile.createNewFile() + fileName);
			tempFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFile(String fileName){
		File tempFile = new File(fileName);
		tempFile.deleteOnExit();
	}
//========================================================================================
	
	public static void main(String[] args) throws IOException{
		MainApp mainApp = new MainApp();
		//mainApp.createFile(mainApp.targetFile);
		mainApp.createFile(mainApp.reportFile);
		
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
		config.setProperty("report.console.start", "");
		config.setProperty("report.console.finished", "");
		config.setProperty("report.console.property_violation", mainApp.options);
		config.setProperty("report.console.file", mainApp.reportFile);
		config.setProperty("classpath", mainApp.classPath);
		config.setProperty("sourcepath", mainApp.sourcePath);
		
		JPF jpf = new JPF(config);
		
		jpf.run();
		//mainApp.setOutputString(mainApp.reportFile, Charset.defaultCharset());
		mainApp.readFile(mainApp.reportFile);
		//mainApp.deleteFile(mainApp.targetFile);
		mainApp.deleteFile(mainApp.reportFile);
		System.out.println(mainApp.outputString);
	}

}
