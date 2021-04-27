package com.test.designpattern.observerpattern;

public interface Subject {

	void addSubs(Subscribers s);

	void revove(Observer s);

	void notifySubscribers();

	void uploadVideo(String name);

}