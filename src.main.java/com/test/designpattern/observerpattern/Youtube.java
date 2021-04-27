package com.test.designpattern.observerpattern;

public class Youtube {

	public static void main(String[] args) {
		
		Subject c = new Channel();
		Subscribers s1 = new Subscribers("amit");
		Subscribers s2 = new Subscribers("vijay");
		Subscribers s3 = new Subscribers("arun");
		Subscribers s4 = new Subscribers("anand");
		c.addSubs(s1);
		c.addSubs(s2);
		c.addSubs(s3);
		c.addSubs(s4);
		
		
		s1.subscribeChannel(c);
		s2.subscribeChannel(c);
		s3.subscribeChannel(c);
		s4.subscribeChannel(c);
		
		c.uploadVideo("new movie");
		
	}
}
