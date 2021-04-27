package com.test.java.thread;

/**
 * https://www.tutorialspoint.com/java/java_thread_communication.htm
 * 
 * @author amit
 *
 */
public class InterThreadChatCommunication {

	public static void main(String[] args) throws InterruptedException {

		Chat chat = new Chat();
		String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };
		String[] s2 = { "Hi", "I am good, what about you?", "Great!" };
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<s1.length; i++) {
					chat.askQuestion(s1[i]);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<s2.length; i++) {
					chat.getAnswer(s2[i]);
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
}


class Chat{
	boolean flag = false;
	public void askQuestion(String ques) {
		
		synchronized(this) {
			if(flag) {
				try {
					wait();
				}catch(InterruptedException e) {

				}
			}

			System.out.println(ques);
			flag = true;
			notify();
		}
	}

	public void getAnswer(String ans) {
		synchronized(this){
			if(!flag) {
				try {
					wait();
				}catch(InterruptedException e) {

				}
			}
			System.out.println(ans);
			flag = false;
			notify();
		}
	}
}
