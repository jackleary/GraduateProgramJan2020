package com.mastek.training.hrapp;

public class EmailAnnouncement extends Announcement {

	@Override
	public void sendAnnouncement() {
		// TODO Auto-generated method stub
		System.out.println("Sending Emails to: "+getForGroup()+" By "+getFrom()+
				" with Title: "+getSubject()+" and Text: "+getContentText());

	}

}
