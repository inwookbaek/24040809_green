package com.lec.ex02_variables;

public class VariableMain2 {

	public static void main(String[] args) {
		// 1. 변수 동시선언
		int a, b, c;
		// System.out.println("a = " + a); 에러
		
		int x=10, y=20, z=30;
		System.out.println("x = " + x);
		
		int l, m, n = 10; // n만 선언과 초기화, l, m은 선언만
		// int l = m = n = 40; // 에러
		
		// 2. 변수선언과 변수타입
		// a. 기본타입(premitive)
		// 1) 정수 : byte(1) < char(2) < shot(2) < int(4) < long(8) < float(4) < double(8)
		// 자바에서 정수의 기본타입은 int, 실수의 기본타입은 double
		
		// 가. byte : -128~127까지의 숫자만 저장이 가능
		byte b1;   
		byte b2;   
		b1 = -128;
		b2 = 127;
		System.out.println("b1 = " + b1 + ", b2 = " + b2);
		
		// b1 = -129;  에러 : 저장범위(최소)를 벗어남
		// b2 = 128;   에러 : 저장범위(최대)를 벗어남
		b1 = (byte) -129;  // 강제형변환 기본타입인 int(4)에 byte(1)로 강제형변환
		b2 = (byte) 128;   // 강제형변환 기본타입인 int(4)에 byte(1)로 강제형변환
		System.out.println("b1 = " + b1 + ", b2 = " + b2);
		
		b1 = (byte) -7986987; 
		b2 = (byte) 7986987;   
		System.out.println("b1 = " + b1 + ", b2 = " + b2);
		System.out.println();
		
		// 나. int : -21억 ~ 21억
		System.out.println("int의 최소값 = " + Integer.MIN_VALUE + 
				           ", int의 최대값 = " + Integer.MAX_VALUE);
		int i1 = -2147483648; // -21^31 
		int i2 = 2147483647; // 21^31 - 1
		System.out.println("i1 = " + i1 + ", i2 = " + i2);
		
		// i1 = -2147483649; 에러 : 저장범위(최소)를 벗어남
		// i2 = 2147483648;  에러 : 저장범위(최대)를 벗어남
		System.out.println();
		
		// 다. long
		System.out.println("long의 최소값 = " + Long.MIN_VALUE + 
		           ", long의 최대값 = " + Long.MAX_VALUE);		
		long l1; // -2^61
		long l2; // 2^61 - 1

		l1 = -2147483649L; // 정수의 기본타입인 int를 long타입으로 선언은 대문자 L or 소문자 l로 선언
		l2 = 2147483648l;
		System.out.println("l1 = " + l1 + ", l2 = " + l2);
		
//		l1 = (long) -2147483649; 에러
//		l2 = (long) 2147483648;  에러
		
		// b. 참조타입(reference)
		

	}
}
