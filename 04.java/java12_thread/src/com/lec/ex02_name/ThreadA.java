package com.lec.ex02_name;

public class ThreadA extends Thread {

	// 쓰레드이름 수동부여
	public ThreadA() {
		super.setName("ThreadA");
	}
	
	@Override
	public void run() {
		for(int i=0;i<2;i++) {
			System.out.println(super.getName() + "가 출력한 내용!!!");
		}
	}
}
