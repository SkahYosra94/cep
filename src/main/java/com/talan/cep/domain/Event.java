package com.talan.cep.domain;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable{	
	private int id;
	private String eventName ;
	private String eventProb ;
	private String eventAction;
	private String eventDate;
	
	
	public Event() {
		super();
	}
	public Event(int id, String eventName, String eventProb, String eventDate) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventProb = eventProb;
		this.eventDate = eventDate;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventProb() {
		return eventProb;
	}
	public void setEventProb(String eventProb) {
		this.eventProb = eventProb;
	}
	
	public String getEventAction() {
		return eventAction;
	}
	public void setEventAction(String eventAction) {
		this.eventAction = eventAction;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", eventProb=" + eventProb + ", eventAction="
				+ eventAction + ", eventDate=" + eventDate + "]";
	}
	
	
	

}
