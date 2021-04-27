package com.test.designpattern.observerpattern;

public class Subscribers implements Observer {

	private String name;
	private Subject channel = new Channel();
	
	@Override
	public void subscribeChannel(Subject channel) {
		this.channel = channel;
	}
	
	
	public Subscribers(String name) {
		super();
		this.name = name;
	}

	@Override
	public void update() {
		System.out.println("Hey "+ name+", "+"Video uploaded");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
