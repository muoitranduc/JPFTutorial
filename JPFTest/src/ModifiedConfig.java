
public class ModifiedConfig {
	public String oldConfig;
	public String newConfig;
	
	public ModifiedConfig(String oldConfig, String newConfig){
		this.newConfig = newConfig;
		this.oldConfig = oldConfig;
	}
	public ModifiedConfig(){
		this.newConfig = "";
		this.oldConfig = "";
	}
}
