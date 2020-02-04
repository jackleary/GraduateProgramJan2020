package com.mastek.training.hrapp;

public class SMSAnnouncement extends Announcement {
	
	// each derived class of the case abstract class must override all abstract methods
	// from the base/parent class
	@Override
	public void sendAnnouncement() {
		// TODO Auto-generated method stub
		System.out.println("Sending SMS to: "+getForGroup()+" By "+getFrom()+
				" with Title: "+getSubject()+" and Text: "+getContentText());
	}

}
