import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.Config;

public class RunJPF {
	private String code;
	private String fileName;
	private String report;
	public List<ModifiedConfig> userConfig = new ArrayList<ModifiedConfig>();
	
	public String getReport() {
		return report;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setUserConfig(List<ModifiedConfig> userConfig) {
		this.userConfig = userConfig;
	}

	public RunJPF(String code, String fileName, List<ModifiedConfig> userConfig){
		this.code = code;
		this.fileName = fileName;
		this.report = "";
		this.userConfig = userConfig;
		createFile(".\\src\\report.out");
		createFile(".\\src\\"+this.fileName+".java");
		writeTargetFile(".\\src\\"+this.fileName+".java", this.code);
		Config JPFconfig = new Config(new InputStreamReader(RunJPF.class.getResourceAsStream("jpf-config")));
		JPFconfig.setProperty("target", this.fileName);
		for (int i = 0; i < userConfig.size(); i++){
			JPFconfig.setProperty(userConfig.get(i).oldConfig, userConfig.get(i).newConfig);
		}
		JPF jpf = new JPF(JPFconfig);
		jpf.run();
		readReportFile(".\\src\\report.out");
	}
	
	public void createFile(String fileName){
		File tempFile = new File(fileName);
		try {
			tempFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeTargetFile(String fileName, String code){
		File tempFile = new File(fileName);
		PrintWriter writer;
		try {
			writer = new PrintWriter(tempFile);
			writer.println(code);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void readReportFile( String file ) {
	    BufferedReader reader = null;
		try {
			reader = new BufferedReader( new FileReader (file));
		} catch (FileNotFoundException e1) {
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
			e.printStackTrace();
		}
	    this.report =  stringBuilder.toString();
	}
}
