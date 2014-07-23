package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	@XmlElement(name = "Version")
	private String version;
	@XmlElement(name = "Outputs")
	private List<Output> outputs;

	public Response() {

	}
	
	public void init(){
		this.version = "1.0";
		this.outputs = new ArrayList<Output>();
		this.outputs.add(new Output("text/x-web-markdown", "# this is the text that you entered..."));
		this.outputs.add(new Output("text/plain", "This is the source..."));
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Output> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<Output> outputs) {
		this.outputs = outputs;
	}	
}
