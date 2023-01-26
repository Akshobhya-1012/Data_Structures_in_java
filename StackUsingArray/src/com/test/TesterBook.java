package com.test;

import java.util.Scanner;

import com.stack.Book;
import com.stack.OperatorException;
import com.stack.Stack;

public class TesterBook {

	public static <T> void main(String[] args) {

		Stack<Book> b = new Stack<>();
		Scanner sc = new Scanner(System.in);

		boolean exit = false;
		while (!exit) {
			System.out.println("1.Push 2. Pop 3.Peek 10.exit");
			System.out.println("Enter the choice");

			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter the Book name and ISBN number");
				b.push(new Book(sc.next(), sc.nextInt()));
				System.out.println( " pushed onto stack");
				break;

			case 2:

				try {
					System.out.println(b.pop() + " poped from stack");
				} catch (OperatorException e) {

					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println(b.peek() + " is the latest book");
				} catch (OperatorException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				break;

			case 10:
				exit = true;
				System.out.println("TY");
				break;

			}// switch
		} // while

	}// main

}// class
