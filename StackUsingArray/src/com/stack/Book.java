package com.stack;

public class Book {

	private String name;
	private int ISBN;
	public Book(String name, int iSBN) {
		super();
		this.name = name;
		ISBN = iSBN;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", ISBN=" + ISBN + "]";
	}
	public Book() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public void display() {
		System.out.println("Book details are Bookid " + ISBN +" name "+name);
	}
}
