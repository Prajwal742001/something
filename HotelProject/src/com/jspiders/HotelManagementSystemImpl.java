package com.jspiders;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelManagementSystemImpl  implements HotelManagementSystem{
	Scanner sc=new Scanner(System.in);
	Map<Integer,Food> db=new LinkedHashMap<Integer,Food>();
	int totalcost=0;

	@Override
	public void addFood() {
		db.put(1, new Food(1,"Chicken Briyani",250,5));
		db.put(2, new Food(2,"Mushroom Briyani",230,7));
		db.put(3, new Food(3,"Mutton Briyani",290,5));
		db.put(4, new Food(4,"Fish Briyani",400,9));
		db.put(5, new Food(5,"Prown Briyani",600,2));
		System.out.println("Food Menu Created");


	}

	@Override
	public void dispalyfood() {

		System.out.println("FOOD LIST \n----------------------------");

		Set<Integer> keys= db.keySet();//12345
		for(int key:keys)
		{
			System.out.println("Enter"+key+"-->"+db.get(key));
		}

	}

	@Override
	public void orderFood() {
		System.out.println("Enter the food id to be orderd");
		int id=sc.nextInt();
		if(db.containsKey(id))
		{
			System.out.println("Enter the Quantity to be Orderd");
			int quantity=sc.nextInt();
			Food food=db.get(id);
			System.out.println("Ordering "+food.getName());
			if(quantity<=food.getQuantity())
			{

				food.setQuantity(food.getQuantity()- quantity);
				int currentCost =food.getCost()*quantity;
				totalcost=totalcost + currentCost;
				System.out.println("Ordered "+quantity+" "+food.getName()+" at the cost of RS."+currentCost);

			}
			else
			{
				try {
					throw new InvalidQuanyityException("not enough Quantity");
				}
				catch(Exception e)

				{
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new InvalidChoiceException("Invalid Choice");

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}



	}

	@Override
	public void checkOut() {
		if(totalcost!=0) {
			System.out.println("Total Bill: RS."+totalcost);
		}
		else {
			System.out.println("no Food items Added");
		}

	}

}
