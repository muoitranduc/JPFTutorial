import java.io.FileNotFoundException;
import java.io.PrintWriter;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.Config;

public class MainApp {
	private static String targetClass = "DiningPhil";
	private static String classPath = ".\\bin";
	private static String sourcePath = ".\\src";
	private static String inputString;  
	private static String options = "error,trace";
	private String outputString;
	
	public static void intoString(){
		inputString = " public class className {" +
				"public static void main(String[] args){" +
				"System.out.println(123);"+
				"  }" +
				"}";
	}
	public static void printToFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(sourcePath + "\\" + targetClass+".java");
		writer.println(inputString);
		writer.close();
	}
	public static void main(String[] args) throws FileNotFoundException{
		intoString();
		//printToFile();
		
		Config config = JPF.createConfig(args);
		config.setProperty("target", targetClass);
		config.setProperty("report.console.property_violation", options);
		config.setProperty("classpath", classPath);
		config.setProperty("sourcepath", sourcePath);
		JPF jpf = new JPF(config);
		jpf.run();
	}

}
