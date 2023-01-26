package com.test;

import java.util.Scanner;

import com.stack.OperatorException;
import com.stack.StackOperator;

public class TesterStack {

	public static void main(String[] args) 
	{
		StackOperator s=new StackOperator();
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		
		while(!exit)
		{
			System.out.println("1.Push 2. Pop 3.Peek 4.isEmpty 5.isFull 10.exit");
			System.out.println("Enter the choice");
			
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Enter the element to push");
				int c=sc.nextInt();
				System.out.println(c);
				s.push(c);
				System.out.println(c+" pushed onto stack");
				break;
				
			case 2:
				
				try {
					System.out.println(s.pop()+" poped from stack");
				} catch (OperatorException e) {
					
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				try {
					System.out.println(s.peek()+" is the top element");
				} catch (OperatorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				if(s.isEmpty())
					System.out.println("Stack is empty");
				else
					System.out.println("Stack is not empty");
				break;
				
			case 5:
				if(s.isFull())
					System.out.println("Stack is full");
				else
					System.out.println("Stack is not full");
				break;
			case 10:
				exit=true;
				System.out.println("TY");
				break;
				
				
			}//switch
		}

	}//main

}//class
