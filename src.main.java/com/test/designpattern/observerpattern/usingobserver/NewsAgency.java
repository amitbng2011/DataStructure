package com.test.designpattern.observerpattern.usingobserver;

import java.util.Observable;
import java.util.Observer;

public class NewsAgency extends Observable{

	public void setNews(String news) {
		setChanged();
		notifyObservers(news);
	}
}

class Channel implements Observer{

	@Override
	public void update(Observable o, Object news) {

		System.out.println("Hey, "+ news+" has come up ");
	}
}

class Test {

	public static void main(String[] args) {
		NewsAgency observable = new NewsAgency();
		Channel observer = new Channel();

		observable.addObserver(observer);
		observable.setNews("breaking news");
	}
}
