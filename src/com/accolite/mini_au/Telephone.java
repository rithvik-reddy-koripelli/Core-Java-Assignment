package com.accolite.mini_au;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Telephone {
	Stack<Call> call_history;
	String number;
	
	public Telephone()
	{
		call_history = new Stack<Call>();
		number = "";
	}

	public void dial()
	{
		System.out.println("Enter a number to Dial");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try {
				boolean check = true;
				String num = br.readLine();
				for(int i =0;i<num.length();i++)
				{
					if(num.charAt(i)-'0' <0 || num.charAt(i)-'0'>9 )
					{
						System.out.println("Enter a Valid Number: Only Integers allowed");
						check = false;
						break;
					}
				}
				if(check)
				{
					this.number = num;
					System.out.println("The Number is Dialed");
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured");
				break;
			}
		}
		
		
		
	}
	
	public void call()
	{
		if(!number.equals("")) {
			Call c = new Call(number);
			
			System.out.println("Calling "+this.number);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press any key to end call");
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			c.callEnd();
			this.call_history.push(c);
		}
		else
			System.out.println("No Number dialed to call");
	}
	
	public void displayCallHistory()
	{
		System.out.println("Call History");
		for(int i =call_history.size()-1;i>=0;i--)
		{
			System.out.println(call_history.get(i));
		}
	}
	
	
	
}
