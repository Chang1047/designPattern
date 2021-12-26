package com.atguigu.facade;
//爆米花机
public class Popcorn {
	//构造器私有化
	private Popcorn(){

	}
	//使用单例模式创建对象
	private static Popcorn instance = new Popcorn();

	//获取实例
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
