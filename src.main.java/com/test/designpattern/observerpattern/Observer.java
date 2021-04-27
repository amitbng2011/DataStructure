package com.test.designpattern.observerpattern;

public interface Observer {

	void subscribeChannel(Subject channel);

	void update();

}