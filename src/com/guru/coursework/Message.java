package com.guru.coursework;

public class Message {
	
	//vars for the message 
	String to;
	String from;
	String Message;
	String time;
	
	public Message()
	{
		//this is the empty constructor
	}
	
	//constructor with arguments 
	public Message(String toy, String Fromy, String Messagey, String Timey)
	{
		this.to = toy;
		this.from = Fromy;
		this.Message = Messagey;
		this.time = Timey;
	}
	
	//write the setters and getter for the arguments
	//getters
	public String getTO()
	{
		return this.to;
	}
	
	public String getFrom()
	{
		return this.from;
	}
	public String getTime()
	{
		return this.time;
	}
	public String getMessaage()
	{
		return this.Message;
	}
	
	//this are the setters 
	public void setTo(String to)
	{
		this.to = to;
		
	}
	
	public void setFrom(String from)
	{
		this.from = from;
	}
	
	public void setMsg (String msg)
	{
		this.Message = msg;
	}
	
	public void setTime(String t)
	{
		this.time = t;
	}
}

