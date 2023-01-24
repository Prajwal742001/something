package com.jspiders;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		HotelManagementSystem hs=new HotelManagementSystemImpl();
		int input=1;
		System.out.println("Welcome to PRAJWAL HOTEL\n--------------------------");
		hs.addFood();
		
		while(input ==1)
		{
			System.out.println("1.Order Food\n2.CheckOut\n Enter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				hs.dispalyfood();
				hs.orderFood();
				break;
			case 2:
				
				hs.checkOut();
				System.out.println("Thank You");
				System.exit(0);
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
					
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				
			}
			System.out.println("Enter 1 to Continue ,are Any other numbers to check out");
			input=sc.nextInt();
		} 
			hs.checkOut();
			System.out.println("THANK YOU");
	}
		
		
		
		
		

	}

}
