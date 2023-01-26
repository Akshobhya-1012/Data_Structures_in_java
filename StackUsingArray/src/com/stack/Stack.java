package com.stack;

public class Stack<T> {

	private int size, top;
	private T [] arr;
	public Stack()
	{
		size=10;
		top=-1;
		arr=(T[])new Object[size];
	}
	public Stack(int size) {
		super();
		this.size = size;
		top=-1;
		arr=(T[])new Object[size];
	}
	
	public boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	
	public boolean isFull()
	{
		if(top==(size-1))
			return true;
		else
			return false;
	}
	
	public void push(T c)
	{
		if(isFull())
			System.out.println("Stack is full");
		else
		{
			top=top+1;
			arr[top]=c;
		}	
	}
	
	public T pop() throws OperatorException 
	{
		if(isEmpty())
			throw new OperatorException("Stack is Empty");	
		else
		{
			T temp=arr[top];
			top=top-1;
			return temp;
			
		}
	}
		
		public T peek() throws OperatorException
		{
			if(isEmpty())
				throw new OperatorException("Stack is Empty");	
			else
			{
				return arr[top];
			}
		}
		
	
	
	
	
	
	
	
	
	
	
}//class

