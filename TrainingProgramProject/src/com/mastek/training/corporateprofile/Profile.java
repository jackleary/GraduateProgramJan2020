package com.mastek.training.corporateprofile;


//Create a class structure to represent corporate professional profile of a candidate to display: 
//qualification, skills, certifications and Job details to show experiences

public class Profile {
	private String name;
	private String qualifications;
	private String certifications;
	private String jobDetails;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}
	
	
}
