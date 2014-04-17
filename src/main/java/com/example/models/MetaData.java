package com.example.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MetaData {
	private String Name;
	private String DisplayName;
	private String Version;
	private String Email;
	private String SupportEmail;
	private String TermsOfUseUrl;
	private String PrivacyUrl;
	private String Institution;
	private String InstitutionUrl;
	private String InstitutionImageUrl;
	private String MimeType;
	private boolean SupportsLanguageSyntax;
	private String Title;
	private String Description;
	private String Question;
	private String Url;
	private String VideoUrl;
	private boolean DisableErrorTable;
	
	public MetaData(){
		
	}
	
	public void init(){
		this.Name = "echo";
		this.DisplayName = "Echo";
		this.Version = "1.0";
		this.Email = "rise4fun-feedback@microsoft.com";
		this.SupportEmail = "rise4fun-feedback@microsoft.com";
		this.TermsOfUseUrl = "http://rise4fun.com/termsofuse";
		this.PrivacyUrl = "http://rise4fun.com/privacy";
		this.Institution = "Microsoft Research";
		this.InstitutionUrl = "http://rise4fun.com";
		this.InstitutionImageUrl = "http://rise4fun.com/images/logo_msr_small.png";
		this.MimeType = "text/x-echo";
		this.SupportsLanguageSyntax = true;
		this.Title = "Echoes the text";
		this.Description = "An example of remote tool that simplies returns the original text.";
		this.Question = "Where are you, echo?";
		this.Url = "http://rise4fun.com";
		this.VideoUrl = "http://rise4fun.com/video";
		this.DisableErrorTable = false;		
	}
		
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSupportEmail() {
		return SupportEmail;
	}
	public void setSupportEmail(String supportEmail) {
		SupportEmail = supportEmail;
	}
	public String getTermsOfUseUrl() {
		return TermsOfUseUrl;
	}
	public void setTermsOfUseUrl(String termsOfUseUrl) {
		TermsOfUseUrl = termsOfUseUrl;
	}
	public String getPrivacyUrl() {
		return PrivacyUrl;
	}
	public void setPrivacyUrl(String privacyUrl) {
		PrivacyUrl = privacyUrl;
	}
	public String getInstitution() {
		return Institution;
	}
	public void setInstitution(String institution) {
		Institution = institution;
	}
	public String getInstitutionUrl() {
		return InstitutionUrl;
	}
	public void setInstitutionUrl(String institutionUrl) {
		InstitutionUrl = institutionUrl;
	}
	public String getInstitutionImageUrl() {
		return InstitutionImageUrl;
	}
	public void setInstitutionImageUrl(String institutionImageUrl) {
		InstitutionImageUrl = institutionImageUrl;
	}
	public String getMimeType() {
		return MimeType;
	}
	public void setMimeType(String mimeType) {
		MimeType = mimeType;
	}
	public boolean isSupportsLanguageSyntax() {
		return SupportsLanguageSyntax;
	}
	public void setSupportsLanguageSyntax(boolean supportsLanguageSyntax) {
		SupportsLanguageSyntax = supportsLanguageSyntax;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public boolean isDisableErrorTable() {
		return DisableErrorTable;
	}
	public void setDisableErrorTable(boolean disableErrorTable) {
		DisableErrorTable = disableErrorTable;
	}
	
}
