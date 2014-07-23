package com.example.jpf;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

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

public class MainApp {
	private String targetClass;
	private String classPath;
	private String sourcePath;
	private String inputString;
	private String options;
	private String outputString;
	private String targetFile;
	private String reportFile;
	private String configFile;

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

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public MainApp() {
		// default constructor
		setTargetClass("Target");
		setClassPath("bin");
		setSourcePath("file");
		setOptions("error,trace");
		setTargetFile(this.sourcePath + "/" + this.targetClass + ".java");
		setReportFile(this.sourcePath + "/report");
		setConfigFile(this.sourcePath + "/jpf-config");

		File binFolder = new File("bin");
		if (!binFolder.exists()) {
			binFolder.mkdir();
		}

	}

	public void printToFile() {
		File tempFile = new File(this.targetFile);
		if (!tempFile.exists()) {
			try {
				tempFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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

	public void readFile(String file) {
		this.outputString += "ReadFile " + file;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			this.outputString += "\n" + e1.getMessage();
			return ;
		}
		
		this.outputString += "Successfully init reader";
		
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			reader.close();
			this.outputString = stringBuilder.toString();
		} catch (IOException e) {
			e.printStackTrace();
			this.outputString += "\n" + e.getMessage();
		}

	}

	/*
	 * public void setOutputString(String path, Charset encoding) throws
	 * IOException{ byte[] encoded = Files.readAllBytes(Paths.get(path));
	 * this.outputString = new String(encoded, encoding); }
	 */

	public void createFile(String fileName) {
		File tempFile = new File(fileName);
		try {
			// System.out.println(tempFile.createNewFile() + fileName);
			tempFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.outputString += "\n" + e.getMessage();
		}
	}

	public int compileTargetFile(String filePath) {
		String command = "javac -d bin/ " + filePath;
		Process pro;
		try {
			pro = Runtime.getRuntime().exec(command);
			pro.waitFor();
			if (pro.exitValue() != 0) {
				this.outputString += "\nCompile error: ";
				String line = null;
				BufferedReader in = new BufferedReader(new InputStreamReader(
						pro.getErrorStream()));
				while ((line = in.readLine()) != null) {
					this.outputString += line;
				}
				this.outputString += "\n";
			}
			return pro.exitValue();
		} catch (Exception e) {
			this.outputString += "\nCompile error: ";
			if (e != null) {
				this.outputString += e.getLocalizedMessage();
			}
			return -1;
		}
	}

	public void deleteFile(String fileName) {
		File tempFile = new File(fileName);
		tempFile.deleteOnExit();
	}

	public String run(String programInString) {
		outputString += "Start\n";
		createFile(reportFile);
		setInputString(programInString);
		printToFile();

		if (compileTargetFile(this.targetFile) != 0) {
			return outputString;
		}

		outputString += "Finish print to File\n";

		// Config config = JPF.createConfig(args);
		// Config config = new Config(new InputStreamReader(
		// MainApp.class.getResourceAsStream(this.configFile)));
		Config config = null;
		try {
			config = new Config(new FileReader(this.configFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.outputString += "\n" + e.getMessage();
		}

		outputString += "Start config\n";

		if (config != null) {
			config.setProperty("target", targetClass);
			config.setProperty("report.console.start", "");
			config.setProperty("report.console.finished", "");
			config.setProperty("report.console.property_violation", options);
			config.setProperty("report.console.file", reportFile);
			config.setProperty("classpath", classPath);
			config.setProperty("sourcepath", sourcePath);

			outputString += "Finish config\n";

			JPF jpf = new JPF(config);

			outputString += "Start new jpf\n";

			jpf.run();

			outputString += "Finish run\n";
			readFile(reportFile);
		}
		outputString += "Finish all\n";
		return outputString;

	}

	// ========================================================================================

	public static void main(String[] args) throws IOException {
		MainApp mainApp = new MainApp();

		String inString = "public class Target {"
				+ "static class Fork {}"
				+ "static class Philosopher extends Thread {"
				+ "Fork left, right;"
				+ "public Philosopher(Fork left, Fork right) {"
				+ "this.left = left;"
				+ "this.right = right;}"
				+ "public void run() {"
				+ "synchronized (left) {"
				+ "synchronized (right) {}}}}"
				+ "static int nPhilosophers = 6;"
				+ "public static void main(String[] args) {"
				+ "if (args.length > 0){"
				+ "nPhilosophers = Integer.parseInt(args[0]);}"
				+ "Fork[] forks = new Fork[nPhilosophers];"
				+ "for (int i = 0; i < nPhilosophers; i++) {"
				+ "forks[i] = new Fork();}"
				+ "for (int i = 0; i < nPhilosophers; i++) {"
				+ "Philosopher p = new Philosopher(forks[i], forks[(i + 1) % nPhilosophers]);"
				+ "p.start();}}}";

		// mainApp.deleteFile(mainApp.reportFile);
		System.out.println(mainApp.run(inString));
	}

}
