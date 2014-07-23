package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tutorial {
	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="Source")
	private String source;
	@XmlElement(name="Samples")
	private List<Sample> samples;

	public Tutorial() {

	}

	public void init() {
		this.name = "guide";
		this.source = "# This is the markdown syntax test.\r\n\r\nA paragraph...\r\n\r\n    first\r\n\r\nThe tutorial also supports TeX maths through mathjax: \r\n\\[\\begin{aligned} \\dot{x} & = \\sigma(y-x) \\\\ \\dot{y} & = \\rho x - y - xz \\\\ \\dot{z} & = -\\beta z + xy \\end{aligned} \\]\r\n";
		this.samples = new ArrayList<Sample>();
		this.samples.add(new Sample("first", "hello you"));
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

	public List<Sample> getSamples() {
		return samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}	
}
