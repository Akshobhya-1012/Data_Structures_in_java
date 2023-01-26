package com.stack;

import java.util.Scanner;

public class RevString {

	public static void main(String[] args) {
		StackChar mystack=new StackChar();
		System.out.println("Enter the string ");
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		char [] reverse=new char[s.length()];	
		//System.out.println("#######");
		for(int i=0;i<s.length();i++)
		{
			mystack.push(s.charAt(i));
		}
		System.out.println("Reversed String is ");
		while(!mystack.isEmpty())
		{
			for(int i=0;i<s.length();i++)
				try {
					reverse[i]=mystack.pop();
				} catch (OperatorException e) {
					e.printStackTrace();
				}
			
		}
		
			String rev=new String(reverse);
			System.out.println(rev);
	}

}
