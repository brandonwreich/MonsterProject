package monster.controller;

//Need to import in order for things to work
import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;

public class MonsterController
{
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	public void start()
	{
//		boolean finished = true;
//		int count = 0;
//		while(count < 100)
//		{
//			popup.displayText("I am so neat! " + count);
//			count += 1;
//		}
		
//		for (int loop = 0; loop < 15; loop += 1)
//		{
//			popup.displayText("I am looping " + (loop + 1) + " time(s) out of 15");
//		}
		
		MarshmallowMonster sample = new MarshmallowMonster();
//		System.out.println(sample);
		popup.displayText(sample.toString());
		
		MarshmallowMonster realMonster = new MarshmallowMonster("George", 2, 10, 8, true);
//		System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		
//		System.out.println("Brandon is hungry, so he is going to eat an eye");
		popup.displayText("Brandon is hungry, so he is going to eat an eye");
		
		realMonster.setEyeCount(1);
//		System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();
		
//		interactWithTheMonster(realMonster);
		
	
	}
	
	private void testList()
	{
		for(int index = 0; index < monsterList.size(); index++) 
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String newName = popup.getResponse("What should my new name be?");
			currentMonster.setName(newName);
			popup.displayText(currentMonster.getName());
		}
		
		for(MarshmallowMonster current : monsterList)
		{
			popup.displayText(current.getName());
			String newName = popup.getResponse("What should my new name be?");
			current.setName(newName);
			popup.displayText(current.getName());
		}
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)

	{
		popup.displayText(currentMonster.getName() + " wants to know what to eat next");
		
		popup.displayText(currentMonster.getName() + "suggests arms, he has " + currentMonster.getArmCount());
		
		int specialAnswer = 0;
		String unconverted = popup.getResponse("How many do you want to eat?");
		
		if(isValidInteger(unconverted))
		{
			specialAnswer = Integer.parseInt(unconverted);
		}
		
		while(!isValidInteger(unconverted))
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many arms???");
		}
		
		Scanner myScanner; //Declares the Scanner
		myScanner = new Scanner(System.in); //Instantiates the Scanner
	
		int consumed = 0;
		consumed = specialAnswer;
		
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
		
		//Eat More?
		
		String answer = popup.getResponse(currentMonster.getName() + " would like to know if you want to eat more.");
		
		if(answer.equals("yes"))
		{

			popup.displayText("Okay what would you like to eat next?");
			popup.displayText("I have " + currentMonster.getArmCount() + " arms or " + currentMonster.getEyeCount() + " eyes or " + currentMonster.getTentacleAmount() + " tentacles.");

			String eatNextAnswer = popup.getResponse("Would you like to eat my arms, eyes, or tentcales??");
			
			//Arms
			
			if(eatNextAnswer.equals("arms"))
			{
				popup.displayText("Okay I have " + currentMonster.getArmCount() + " arms.");
				System.out.println("How many would you like to eat?");
				int armsConsumed = myScanner.nextInt();
				
				while(armsConsumed < 0)
				{
//					System.out.println("You can't eat a negative amount silly human!");
					popup.displayText("You can't eat a negative amount silly human!");
//					System.out.println("How many do you want to eat?");
//					armsConsumed = myScanner.nextInt();
					popup.getResponse("How many do you want to eat?");
				}
				
				while(armsConsumed > currentMonster.getArmCount()) //If they put in a number greater than the amount of arms
				{
//					System.out.println("That's impossible!! I only have " + currentMonster.getArmCount() + " arms!!");
					popup.displayText("That's impossible!! I only have " + currentMonster.getArmCount() + " arms!!");
//					System.out.println("How many do you want to eat?");
					popup.getResponse("How many do you want to eat??");
				}
				
				if(armsConsumed == 0) //If they put in 0
				{
					System.out.println("Not that hungry are you?");
				}
				else
				{
					currentMonster.setArmCount(currentMonster.getArmCount() - armsConsumed);
					System.out.println("Thank you so much. I only have " + currentMonster.getArmCount() + " arms now.");
				}
//				else if(armsConsumed < 0) //If they put in a negative number
//				{
//				System.out.println("You cannot eat a negative amount silly human!");
//				popup.displayText("You can't eat a negative amount silly human!");
//				}
//				
//				else if(armsConsumed > currentMonster.getArmCount())
//				{
///				System.out.println("That's impossible!! I only have " + currentMonster.getArmCount() + " arms.");
//					popup.displayText("That's impossible!! I only have " + currentMonster.getArmCount() + " arms.");
//				}

			}
			
			//Eyes
			
			else if(eatNextAnswer.equals("eyes"))
			{
				System.out.println("Okay, I have " + currentMonster.getEyeCount() + " eyes.");
				System.out.println("How many would you like to eat?");
				int eyesConsumed = myScanner.nextInt();
				
				while(eyesConsumed < 0)
				{
					System.out.println("You can't eat a negative amount silly human!!");
					System.out.println("How many do you want to eat?");
					eyesConsumed = myScanner.nextInt();
				}
				while(eyesConsumed > currentMonster.getEyeCount())
				{
					System.out.println("That's impossible!! I only have "+ currentMonster.getEyeCount() + " eyes");
					System.out.println("How many do you want to eat?");
				}
				
				 if(eyesConsumed == 0) //If they put in a 0
				{
					System.out.println("Not that hungry are you?");
				}
				 
				else
				{
					currentMonster.setEyeCount(currentMonster.getEyeCount() - eyesConsumed);
					System.out.println("Thank you so much! I now have " + currentMonster.getEyeCount() + " eyes.");
				}
				
//				if(eyesConsumed < 0) //If they put in a negative number
//				{
//					System.out.println("You cannot eat a negative amount silly human!!");
//				}
				 
//				else if(eyesConsumed > currentMonster.getEyeCount()) //If they put in a number greater than the amount of eyes
//				{	
//					System.out.println("That's impossible!! I only have " + currentMonster.getEyeCount() + " eyes!!");
//				}
				 

			}
			
			//Tentacles
			
			else if(eatNextAnswer.equals("tentacles"))
			{
				System.out.println("Okay, I have " + currentMonster.getTentacleAmount() + " tentacles.");
				System.out.println("How many would you like to eat?");
				int tentaclesConsumed = myScanner.nextInt();
				
				while(tentaclesConsumed < 0)
				{
					System.out.println("You can't eat a negative amount silly human!!");
					System.out.println("How many do you want to eat?");
					tentaclesConsumed = myScanner.nextInt();
				}
				
				while(tentaclesConsumed > currentMonster.getTentacleAmount())
				{
					System.out.println("That's impossible!! I only have " + currentMonster.getTentacleAmount() + " tentacles!");
					System.out.println("How many do you want to eat?");
					tentaclesConsumed = myScanner.nextInt();
				}
				
				if(tentaclesConsumed == 0) //If they put in 0
				{
					System.out.println("Not very hungry are you?");
				}
				
				else
				{
					currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentaclesConsumed);
					System.out.println("Thank you so much! Now I have " + currentMonster.getTentacleAmount() + " tentacles.");
				}
//				if(tentaclesConsumed < 0) //If they put in a negative number
//				{
//					System.out.println("You can't eat a negative amount silly human!!");
//				}
			
//				else if(tentaclesConsumed > currentMonster.getTentacleAmount()) //If they put in a number greater than the number of tentacles
//				{
//					System.out.println("That's impossible!! I only have " + currentMonster.getTentacleAmount() + "tentacles!!");
//				}
	
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
	}

	//Helper Methods
	//wrapper classes are Type.parseType() 
	
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
	
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
				
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only double values are valid: " + sampleDouble + " is not.");
		}
		
		return valid;
	}
	
	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
				
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only boolean values are valid: " + sampleBoolean + " is not.");
		}
		
		return valid;
	}
}
		
	
