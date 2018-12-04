
import java.util.Scanner;

public class Main {

	//Making the object array size as a constant
	public static final int SIZE = 2;

	// Making the Scanner as a constant
	public static Scanner sc = new Scanner(System.in);

	// Making an object array(object array is details) in the object class
	public static Objects[] details = new Objects[SIZE];

	public static void main(String[] args) {

		// Calling the methods
		inputData();
		printMenu();
		viewMenu();

	}

	public static void inputData() {

		// Getting competitor details using the object array called details in Object class 
		for (int i = 0; i < SIZE; i++) {

			// Making an object called competitors in Object class
			Objects competitors = new Objects();

			System.out.println("\n           =================================");
			System.out.println("           ||   ENTER PLAYER " + (i + 1) + " DETAILS    ||");
			System.out.println("           =================================\n");

			System.out.print("  Enter the competitor name      : ");
			competitors.setName(sc.next());

			System.out.print("\n  Enter the competitor ID        : ");
			competitors.setCom_number(numValidation());

			System.out.print("\n  Enter the competitor age       : ");
			competitors.setCom_age(ageValidation());

			System.out.print("\n  Enter the distance you reached : ");
			competitors.setDistance(numValidation());

			System.out.print("\n  Enter the competitor's coins   : ");
			competitors.setCoins(numValidation());

			System.out.print("\n  Enter the competitor's score   : ");
			competitors.setScore(numValidation());

			// assigning the values to the details array index
			details[i] = competitors;
		}

	}

	public static void printMenu() {

		// Print main menu
		System.out.println(
				"		                =============================================================================================\n"
						+ "				|				Select one of the given options	  	    		    |\n"
						+ "		                =============================================================================================\n"
						+ "				|  Enter 1 to view all competitor details         	    		     	            |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				|  Enter 2 to view view a selected player's details (Enter the given competitor number)     |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				|  Enter 3 to view all the winners         			                            |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				|  Enter 4 to view selected winner        	   					    |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				|  Enter 5 to view the menu         	                                                    |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				|  Enter 6 to exit the program        	   						    |\n"
						+ "				---------------------------------------------------------------------------------------------\n");

	}

	// Creating a method called 'findMaxcoins' to find the winner who got the max coins
	public static void findMaxcoins() {

		// Creating object called max_coins in Object class
		Objects max_coins = new Objects();

		// Assigning the max_coins to the 0th index in the details array
		max_coins = details[0];

		// Using enhanced for loop
		for (Objects x : details) {
			if (max_coins.getCoins() < x.getCoins())

				// Assigning the values to the max_coins from the x variable
				max_coins = x;
		}
		// Print 'MAX COINS' winner
		System.out.println("\n=================================");
		System.out.println("        MAX COINS WINNER  ");
		System.out.println("=================================");
		System.out.println("   Name          : " + max_coins.getName());
		System.out.println("   Age           : " + max_coins.getCom_age());
		System.out.println("   Competitor ID : " + max_coins.getCom_number());
		System.out.println("   Coins         : " + max_coins.getCoins());

	}

	// Creating a method called 'findMaxscore' to find the winner who got the max score
	public static void findMaxscore() {

		// Creating object called max_score in Object class
		Objects max_score = new Objects();

		// Assigning the max_score to the 0th index in the details array
		max_score = details[0];

		// Using enhanced for loop
		for (Objects y : details) {
			if (max_score.getScore() < y.getScore())

				// Assigning the values to the max_score from the y variable
				max_score = y;
		}
		// Print 'MAX SCORE' winner
		System.out.println("\n=================================");
		System.out.println("        MAX SCORE WINNER  ");
		System.out.println("=================================");
		System.out.println("   Name          : " + max_score.getName());
		System.out.println("   Age           : " + max_score.getCom_age());
		System.out.println("   Competitor ID : " + max_score.getCom_number());
		System.out.println("   Coins         : " + max_score.getScore());

	}

	// Creating a method called 'findMaxdistance' to find the winner who got the max distance
	public static void findMaxdistance() {

		// Creating object called max_distance in Object class
		Objects max_distance = new Objects();

		// Assigning the max_distance to the 0th index in the details array
		max_distance = details[0];

		// Using enhanced for loop
		for (Objects z : details) {
			if (max_distance.getDistance() < z.getDistance())

				// Assigning the values to the max_distance from the z variable
				max_distance = z;
		}
		// Print 'MAX DISTANCE' winner
		System.out.println("\n=================================");
		System.out.println("        MAX DISTANCE WINNER  ");
		System.out.println("=================================");
		System.out.println("   Name          : " + max_distance.getName());
		System.out.println("   Age           : " + max_distance.getCom_age());
		System.out.println("   Competitor ID : " + max_distance.getCom_number());
		System.out.println("   Coins         : " + max_distance.getDistance());

	}

	// Creating a method called viewMenu to help to user to choose one of the given options
	public static void viewMenu() {

		String option1 = "";
		System.out.println("Enter option : ");

		//Getting the user input
		option1 = sc.next();
		boolean com = false;
		do {
			
			switch (option1) {

			case "1":
				viewAlldetails();
				com = false;
				printMenu();
				viewMenu();
				break;

			case "2":
				viewSelectplayer();
				com = false;
				printMenu();
				viewMenu();
				break;

			case "3":
				findMaxcoins();
				findMaxscore();
				findMaxdistance();
				com = false;
				printMenu();
				viewMenu();
				break;

			case "4":
				printWinnermenu();
				viewSelectwinner();
				com = false;
				break;

			case "5":
				printMenu();
				com = false;
				break;

			case "6":
				System.exit(1);
				com = false;
				break;

			default:
				System.out.println("Invalid input!!!  ");
				System.out.println("Please enter a valid input : ");
				option1 = sc.next();
				com = true;
			}
		} while (true);

	}

	// Creating a method called 'viewAlldetails' to print the all details of competitors
	public static void viewAlldetails() {
		int i = 0;
		for (Objects w : details) {

			//Printing the details
			System.out.println("\n=================================");
			System.out.println("     DETAILS OF COMPETITOR " + (++i));
			System.out.println("=================================");

			System.out.println("  Name          : " + w.getName());
			System.out.println("  Competitor ID : " + w.getCom_number());
			System.out.println("  Age           : " + w.getCom_age());
			System.out.println("  Coins         : " + w.getCoins());
			System.out.println("  Score         : " + w.getScore());
			System.out.println("  Distance      : " + w.getDistance());

		}
	}

	// Creating a method called 'viewSelectplayer' to view the selected competitor details
	public static void viewSelectplayer() {

		System.out.println("Enter the competitor ID : ");
		
		//Getting the user input (ID of the player user want)
		int l = sc.nextInt();

		for (Objects x : details) {
			if (l == x.getCom_number()) {

				//Printing the details
				System.out.println("\n=================================");
				System.out.println("     SELECTED PLAYER DETAILS  ");
				System.out.println("=================================");

				System.out.println("  Name          : " + x.getName());
				System.out.println("  Competitor ID : " + x.getCom_number());
				System.out.println("  Age           : " + x.getCom_age());
				System.out.println("  Coins         : " + x.getCoins());
				System.out.println("  Score         : " + x.getScore());
				System.out.println("  Distance      : " + x.getDistance());

			}
		}

	}

	// Creating a method called 'viewSelectwinner' to help to user to choose one of the winners 
	public static void viewSelectwinner() {

		String option2 = "";
		System.out.println("Enter option using given menu  : ");
		option2 = sc.next();
		boolean con = false;
		do {

			switch (option2) {

			case "A":
				findMaxcoins();
				con = false;
				printWinnermenu();
				viewSelectwinner();
				break;

			case "B":
				findMaxscore();
				con = false;
				printWinnermenu();
				viewSelectwinner();
				break;

			case "C":
				findMaxdistance();
				con = false;
				printWinnermenu();
				viewSelectwinner();
				break;

			case "D":
				printMenu();
				viewMenu();
				con = false;
				break;

			default:
				System.out.println("Invalid Input !!!!!! ");

				System.out.println("Please input a valid input : ");
				option2 = sc.next();
				con = true;
			}
		} while (true);

	}

	// Print selected winner's menu
	public static void printWinnermenu() {
		System.out.println(
				"		                =============================================================================================\n"
						+ "				|		Select one of the given options to choose winners	    		    |\n"
						+ "		                =============================================================================================\n"
						+ "				| 1. Enter 'A' to view max coins Winner       	    		     	            	    |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				| 2. Enter 'B' to view max score Winner     						    |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				| 3. Enter 'C' to view max distance Winner       			                    |\n"
						+ "				---------------------------------------------------------------------------------------------\n"
						+ "				| 4. Enter 'D' to back to main menu         			                            |\n"
						+ "				---------------------------------------------------------------------------------------------");

	}

	//Creating method called 'ageValidation' to validate age
	public static int ageValidation() {

		int age = 0;

		do {
			while (!sc.hasNextInt()) {

				sc.next();

				System.out.println("	        ====================================");
				System.out.println("		*******     Invalid Input      *****");
				System.out.println("		====================================");

				System.out.print("  Please enter a valid input     : ");

			}
			age = sc.nextInt();

			if (age <= 0 || age > 150) {
				System.out.println("	        ====================================");
				System.out.println("		*******     Invalid Input      *****");
				System.out.println("		====================================");

				System.out.print("  Please enter a valid input     : ");
				age = ageValidation();
			} else {
				break;
			}
		}

		while (age < 0);

		return age;

	}

	//Creating method called 'numValidation' to validate integers
	public static int numValidation() {

		int number = 0;

		do {

			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("	        ====================================");
				System.out.println("		*******     Invalid Input      *****");
				System.out.println("		====================================");

				System.out.print("  Please enter a valid input     : ");
			}

			number = sc.nextInt();

			if (number <= 0) {
				System.out.println("	        ====================================");
				System.out.println("		*******     Invalid Input      *****");
				System.out.println("		====================================");

				System.out.print("  Please enter a valid input     : ");

			} else {
				break;
			}
		}

		while (number < 0);

		return number;

	}
}
