package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{
	private MonsterDisplay popup;
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		//System.out.println(sample);
		
		popup.displayText(sample.toString());
		
		MarshmallowMonster realMonster = new MarshmallowMonster("George", 2, 10, 8, true);
//		System.out.println(realMonster);
		
		popup.displayText(realMonster.toString());
		
//		System.out.println("Brandon is hungry, so he is going to eat an eye");
		
		popup.displayText("Brandon is hungry, so he is going to eat an eye");
		
		realMonster.setEyeCount(1);
//		System.out.println(realMonster);
		
		popup.displayText(realMonster.toString());
		
		interactWithTheMonster(realMonster);
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)

	{
//		System.out.println(currentMonster.getName() + " wants know what to eat next");
		
		popup.displayText(currentMonster.getName() + " wants to know what to eat next");
		
//		System.out.println(currentMonster.getName() + " suggests arms, he has " + currentMonster.getArmCount());
		
		popup.displayText(currentMonster.getName() + "suggests arms, he has " + currentMonster.getArmCount());
		
//		System.out.println("How many do you want to eat??");
		
		int specialAnswer;
		String unconverted = popup.getResponse("How many do you want to eat?");
		
		specialAnswer = Integer.parseInt(unconverted);
		
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
		
		System.out.println(currentMonster.getName() + " would like to know if you want to eat more.");
		String answer = myScanner.next();
		
		if(answer.equals("yes"))
		{
			System.out.println("Okay what would you like to eat next?");
			System.out.println("I have " + currentMonster.getArmCount() + " arms or " + currentMonster.getEyeCount() + " eyes or " +currentMonster.getTentacleAmount() + " tentacles.");
			System.out.println("Would you like to eat my arms, eyes, or tentcales??");
			String eatNextAnswer = myScanner.next();
			
			//Arms
			
			if(eatNextAnswer.equals("arms"))
			{
				System.out.println("Okay I have " + currentMonster.getArmCount() + " arms.");
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
			
			//Eyes
			
			else if(eatNextAnswer.equals("eyes"))
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
			
			//Tentacles
			
			else if(eatNextAnswer.equals("tentacles"))
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
		
		popup.displayText("Hey look at me!!");
		String answerMe = popup.getResponse("How many meals are you eating today?");
		System.out.println(answerMe);
		popup.displayText(answerMe);
		
		popup.displayText("I am so bored.");
		String answerThis = popup.getResponse("How are you doing?");
	}

	//Helper Methods
	
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only integer values are valid: " + sample + " is not.");
		}
		
		return valid;
	}
}
		
	
