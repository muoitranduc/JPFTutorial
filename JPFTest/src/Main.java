import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	private String inputString;
	private String outputString;
	
	public String getOutputString() {
		return outputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public void readFile( String file){
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
	    this.inputString =  stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.readFile(".\\src\\InputString.txt");
		UserCode userCode = new UserCode(main.inputString);
		RunJPF runJPF = new RunJPF(userCode.getCode(), userCode.getFileName(), userCode.userConfig);
		main.outputString = runJPF.getReport();
		System.out.println(main.outputString);
	}
}
