package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MetaData {
	@XmlElement(name = "Name")
	private String name;
	@XmlElement(name = "DisplayName")
	private String displayName;
	@XmlElement(name = "Version")
	private String version;
	@XmlElement(name = "Email")
	private String email;
	@XmlElement(name = "SupportEmail")
	private String supportEmail;
	@XmlElement(name = "TermsOfUseUrl")
	private String termsOfUseUrl;
	@XmlElement(name = "PrivacyUrl")
	private String privacyUrl;
	@XmlElement(name = "Institution")
	private String institution;
	@XmlElement(name = "InstitutionUrl")
	private String institutionUrl;
	@XmlElement(name = "InstitutionImageUrl")
	private String institutionImageUrl;
	@XmlElement(name = "MimeType")
	private String mimeType;
	@XmlElement(name = "SupportsLanguageSyntax")
	private boolean supportsLanguageSyntax;
	@XmlElement(name = "Title")
	private String title;
	@XmlElement(name = "Description")
	private String description;
	@XmlElement(name = "Question")
	private String question;
	@XmlElement(name = "Url")
	private String url;
	@XmlElement(name = "VideoUrl")
	private String videoUrl;
	@XmlElement(name = "DisableErrorTable")
	private boolean disableErrorTable;
	@XmlElement(name = "Samples")
	private List<Sample> samples;
	@XmlElement(name = "Tutorials")
	private List<Tutorial> tutorials;

	public MetaData() {

	}

	public void init() {
		this.name = "echo";
		this.displayName = "Echo";
		this.version = "1.0";
		this.email = "rise4fun-feedback@microsoft.com";
		this.supportEmail = "rise4fun-feedback@microsoft.com";
		this.termsOfUseUrl = "http://rise4fun.com/termsofuse";
		this.privacyUrl = "http://rise4fun.com/privacy";
		this.institution = "Microsoft Research";
		this.institutionUrl = "http://rise4fun.com";
		this.institutionImageUrl = "http://rise4fun.com/images/logo_msr_small.png";
		this.mimeType = "text/x-echo";
		this.supportsLanguageSyntax = false;
		this.title = "Echoes the text";
		this.description = "An example of remote tool that simplies returns the original text.";
		this.question = "Where are you, echo?";
		this.url = "http://rise4fun.com";
		this.videoUrl = "http://rise4fun.com/video";
		this.disableErrorTable = false;

		this.samples = new ArrayList<Sample>();
		this.samples.add(new Sample("hello", "hello world"));
		this.samples.add(new Sample("bye", "see you"));

		this.tutorials = new ArrayList<Tutorial>();
		Tutorial newTutorial = new Tutorial();
		newTutorial.init();
		this.tutorials.add(newTutorial);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}

	public String getTermsOfUseUrl() {
		return termsOfUseUrl;
	}

	public void setTermsOfUseUrl(String termsOfUseUrl) {
		this.termsOfUseUrl = termsOfUseUrl;
	}

	public String getPrivacyUrl() {
		return privacyUrl;
	}

	public void setPrivacyUrl(String privacyUrl) {
		this.privacyUrl = privacyUrl;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getInstitutionUrl() {
		return institutionUrl;
	}

	public void setInstitutionUrl(String institutionUrl) {
		this.institutionUrl = institutionUrl;
	}

	public String getInstitutionImageUrl() {
		return institutionImageUrl;
	}

	public void setInstitutionImageUrl(String institutionImageUrl) {
		this.institutionImageUrl = institutionImageUrl;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public boolean isSupportsLanguageSyntax() {
		return supportsLanguageSyntax;
	}

	public void setSupportsLanguageSyntax(boolean supportsLanguageSyntax) {
		this.supportsLanguageSyntax = supportsLanguageSyntax;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public boolean isDisableErrorTable() {
		return disableErrorTable;
	}

	public void setDisableErrorTable(boolean disableErrorTable) {
		this.disableErrorTable = disableErrorTable;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

}