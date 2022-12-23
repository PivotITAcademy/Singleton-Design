package com.learning.singleton;

public class SingletonExample {

	// Instance of the class
	private static SingletonExample instance;

	// Declare the constructor as Private
	private SingletonExample() {

	}

	// Public method that returns the instance
	public static SingletonExample getInstance() {
		if (instance == null) {
			instance = new SingletonExample();
		}
		return instance;
	}

	public void test1() {
		System.out.println("Method called");
	}

}
