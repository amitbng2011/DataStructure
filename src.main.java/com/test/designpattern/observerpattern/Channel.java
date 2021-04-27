package com.test.designpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

	private String name;
	private List<Subscribers> subs = new ArrayList<>();
	
	@Override
	public void addSubs(Subscribers s) {
		subs.add(s);
	}
	
	@Override
	public void revove(Observer s) {
		subs.remove(s);
	}
	
	@Override
	public void notifySubscribers() {
		
		subs.stream().forEach(Subscribers::update);
		
	}
	
	@Override
	public void uploadVideo(String name) {
		this.name = name;
		notifySubscribers();
	}
}
