import java.util.ArrayList;
import java.util.List;


public class UserCode {
	private String input;
	private String configureString;
	private String code;
	private String fileName;
	private String markOpen = "/*jpf";
	private String markClose = "*/";
	private String markLine = "//jpf";
	public List<ModifiedConfig> userConfig = new ArrayList<ModifiedConfig>();
	
	public String getCode() {
		return code;
	}
	public String getFileName() {
		return fileName;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	public UserCode(){
		this.input = "";
	}
	public UserCode(String input){
		this.input = input;
		splitCode();
	}
	private void splitCode(){
		code = input;
		configureString = "\n";
		for (int i = -1; (i = input.indexOf(markOpen, i+1)) != -1;){
			int j = input.indexOf(markClose, i+1);
			configureString = configureString + input.substring(i+5, j);
			code = code.replace(input.substring(i, j+2), "");
		}
		for (int i = -1; (i = input.indexOf(markLine, i+1)) != -1;){
			int  j = input.indexOf("\n", i+1);
			configureString = configureString + input.substring(i+5, j);
			code = code.replace(input.substring(i, j+2), "");
		}
		int i = input.indexOf("class");
		int j = input.indexOf(" ", i+1);
		int k = input.indexOf(" ", j+1);
		this.fileName = input.substring(j+1, k);
		splitConfigure();
	}
	private void splitConfigure(){
		configureString = configureString + "\n";
		for (int i = -1; (i = configureString.indexOf("\n", i+1)) != -1;){
			int j = configureString.indexOf("\n", i+1);
			if (j == -1){
				break;
			}
			String configureLine = configureString.substring(i+1, j);
			int k = configureLine.indexOf("=");
			if (k != -1){
				ModifiedConfig modifiedConfig = new ModifiedConfig(configureLine.substring(0,k), configureLine.substring(k+1, configureLine.length()));
				userConfig.add(modifiedConfig);
			}
		}
	}
}
