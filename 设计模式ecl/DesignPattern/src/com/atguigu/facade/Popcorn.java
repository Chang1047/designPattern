package com.atguigu.facade;
//���׻���
public class Popcorn {
	//������˽�л�
	private Popcorn(){

	}
	//ʹ�õ���ģʽ��������
	private static Popcorn instance = new Popcorn();

	//��ȡʵ��
	public static Popcorn getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println(" popcorn on ");
	}
	
	public void off() {
		System.out.println(" popcorn ff ");
	}
	
	public void pop() {
		System.out.println(" popcorn is poping  ");
	}
}
