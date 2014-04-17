package com.example.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Output {
	@XmlElement(name="MimeType")
	private String mimeType;
	@XmlElement(name="Value")
	private String value;
	
	public Output(){
		
	}
	
	public Output(String mimeType, String value){
		this.mimeType = mimeType;
		this.value = value;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
	
}
