package com.example.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TQARequest {

	private String question;

	public TQARequest() {

	}

	public TQARequest(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return new StringBuffer(" question: ").append(this.question).toString();
	}
}