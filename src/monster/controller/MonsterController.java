package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController
{
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		
		MarshmallowMonster realMonster = new MarshmallowMonster("George", 2, 10, 8, true);
		System.out.println(realMonster);
		
		System.out.println("Brandon is hungry, so he is going to eat an eye");
		realMonster.setEyeCount(1);
		System.out.println(realMonster);
		
		interactWithTheMonster(realMonster);
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + " wants know what to eat next");
		System.out.println(currentMonster.getName() + " suggests arms, he has " + currentMonster.getArmCount());
		System.out.println("How many do you want to eat??");
		
		Scanner myScanner; //Declares the Scanner
		myScanner = new Scanner(System.in); //Instantiates the Scanner
		int consumed = myScanner.nextInt();
		
		if(consumed < 0)
		{
			System.out.println("You cannont eat a negative amount silly human!");
		}
		else if(consumed == 0)
		{
			System.out.println("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
			System.out.println("That's immpossible!! I only have " + currentMonster.getArmCount() + " arms!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Thank you so much! I only have " + currentMonster.getArmCount() + " arms now.");
		}
		
		System.out.println(currentMonster.getName() + " would like to know if you want to eat more");
		String answer = myScanner.nextLine();
		
		if(answer.equals("Yes"))
		{
			System.out.println("Okay what would you like to eat next?");
			System.out.println("I have " + currentMonster.getArmCount() + " arms or " + currentMonster.getEyeCount() + " eyes or ");
			System.out.println(currentMonster.getTentacleAmount() + " tentacles.");
			System.out.println("Would you like to eat my arms, eyes, or tentcales??");
			String eatNextAnswer = myScanner.nextLine();
			
			if(eatNextAnswer.equals("Arms")) //Arms
			{
				System.out.println("Okay I have " + currentMonster.getArmCount() + "arms.");
				System.out.println("How many would you like to eat?");
				int armsConsumed = myScanner.nextInt();
				
				if(armsConsumed < 0) //If they put in a negative number
				{
					System.out.println("You cannont eat a negative amount silly human!");
				}
				else if(armsConsumed == 0) //If they put in 0
				{
					System.out.println("Not that hungry are you?");
				}
				else if(armsConsumed > currentMonster.getArmCount()) //If they put in a number greater than the amount of arms
				{
					System.out.println("That's immpossible!! I only have " + currentMonster.getArmCount() + " arms!!");
				}
				else
				{
					currentMonster.setArmCount(currentMonster.getArmCount() - armsConsumed);
					System.out.println("Thank you so much. I only have " + currentMonster.getArmCount() + " arms now.");
				}
			}
			else if(eatNextAnswer.equals("eyes")) //Eyes
			{
				System.out.println("Okay, I have " + currentMonster.getEyeCount() + " eyes.");
				System.out.println("How many would you like to eat?");
				int eyesConsumed = myScanner.nextInt();
				
				if(eyesConsumed < 0) //If they put in a negative number
				{
					System.out.println("You cannot eat a negative amount silly human!!");
				}
				else if(eyesConsumed == 0) //If they put in a 0
				{
					System.out.println("Not that hungry are you?");
				}
				else if(eyesConsumed > currentMonster.getEyeCount()) //If they put in a number greater than the amount of eyes
				{	
					System.out.println("That's impossible!! I only have " + currentMonster.getEyeCount() + " eyes!!");
				}
				else
				{
					currentMonster.setEyeCount(currentMonster.getEyeCount() - eyesConsumed);
					System.out.println("Thank you so much! I now have " + currentMonster.getEyeCount() + " eyes.");
				}
			}
			else if(eatNextAnswer.equals("tentacles")) //Tentacles
			{
				System.out.println("Okay, I have " + currentMonster.getTentacleAmount() + "tentacles.");
				System.out.println("How many would you like to eat?");
				int tentaclesConsumed = myScanner.nextInt();
				
				if(tentaclesConsumed < 0) //If they put in a negative number
				{
					System.out.println("You can't eat a negative amount silly human!!");
				}
				else if(tentaclesConsumed == 0) //If they put in 0
				{
					System.out.println("Not very hungry are you?");
				}
				else if(tentaclesConsumed > currentMonster.getTentacleAmount()) //If they put in a number greater than the number of tentacles
				{
					System.out.println("That's impossible!! I only have " + currentMonster.getTentacleAmount() + "tentacles!!");
				}
				else
				{
					currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentaclesConsumed);
					System.out.println("Thank you so much! Now I have " + currentMonster.getTentacleAmount() + "tentacles.");
				}
			}
		}
		else if(answer.equals("maybe"))
		{
			System.out.println("Okay, let me know if you would.");
		}
		else if(answer.equals("no"))
		{
			System.out.println("Okay, I guess your not hungry.");
			
		}
		
	}
	
}
		
	
