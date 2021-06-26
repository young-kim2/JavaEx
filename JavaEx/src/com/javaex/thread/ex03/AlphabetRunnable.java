package com.javaex.thread.ex03;

public class AlphabetRunnable implements Runnable {

	@Override
	public void run() {
		//main thread:A~Z출력
		for(char ch='A'; ch<='Z'; ch++) {
			//현재 Thread를 구하려면 Thread.currentThread()
			System.out.println(Thread.currentThread().getName()+":"+ch);
			//잠시 대기
			try {
				Thread.sleep(300);
				//0.3초 대기
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
