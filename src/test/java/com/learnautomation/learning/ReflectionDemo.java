package com.learnautomation.learning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		
		MyTest obj = new MyTest();
		Class cls =obj.getClass();
		System.out.println(cls.getName());
		Constructor cons=cls.getConstructor();
		System.out.println(cons.getName());
		
		Method[] mt =cls.getMethods();
				for(Method m:mt) {
					System.out.println(m.getName());
				}
	}

}
