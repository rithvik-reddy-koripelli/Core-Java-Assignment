package com.accolite.mini_au;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Person implements Human {
	String name;
	String number;
	Telephone t;
	
	public Person(String Name,String Number)
	{
		this.name = Name;
		this.number = Number;
		this.t= new Telephone();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	
	public String getNumber()
	{
		return this.number;
	}
	
	public void dialNumber()
	{
		this.t.dial();
	}
	
	public void callNumber()
	{
		this.t.call();
	}
	
	public void getCallHistory()
	{
		this.t.displayCallHistory();
	}
	public static void main(String [] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = -1;
		Person p = new Person("Rahul","9876543210");
		while(true)
		{
			System.out.println("Enter any number from the following list");
			System.out.println("1.Dial a Number");
			System.out.println("2.Call the Number");
			System.out.println("3.Display Call history");
			System.out.println("4.Quit");
			try {
				input = Integer.parseInt(br.readLine());
			}
			catch(IOException e)
			{
				System.out.println("Error in reading the input");
//				e.printStackTrace();
			}
			catch(Exception e)
			{
				System.out.println("Error in reading the input");
			}
			switch(input)
			{
			case 1: p.dialNumber();
					break;
			case 2: p.callNumber();
					break;
			case 3: p.getCallHistory();
					break;
			case 4:System.exit(0);
					break;
			default:
				System.out.println("Enter a valid Input");
				break;
			}


		}
	}
}
