package com.example.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sample {
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="Source")
	private String source;
	
	public Sample(){
		
	}
	
	public Sample(String name, String source){
		this.name = name;
		this.source = source;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
