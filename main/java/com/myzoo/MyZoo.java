package com.myzoo;

import java.util.Scanner;

public class MyZoo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int idOfAnimalToUpdate = 0;
		int animalToDelete = 0;
		String userMenuInput = null;
		String dataToUpdateTheFieldTo = null;
		boolean validMenuInput = false;
		String fieldToUpdate = null;

		System.out.println("Welcome to Jamal's Epic Zoo Animal Entry Program\n");

		do {
			System.out.println("Press 1 to see all of the animals in the zoo.\n"
					+ "Press 2 to add new animals to the zoo list.\n"
					+ "Press 3 to update information on an animal already in the zoo.\n"
					+ "Press 4 to delete an animal that has gone to heaven.\n" + "Press 5 to exit the program.");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				validMenuInput = true;
				break;
			case "2":
				DAO.writeToDB();
				validMenuInput = true;
				break;
			case "3":
				DAO.readFromDB();

				System.out.println("Please enter the ID number of the animal you would like to update:");
				idOfAnimalToUpdate = Integer.parseInt(sc.nextLine());

				System.out.println("Which field would you like to update?\n" + "1. Animal Species\n"
						+ "2. Animal Name\n" + "3. Animal Color\n" + "4. Animal Food\n" + "5. Animal Enclosure\n"
						+ "6. Animal Weight");
				fieldToUpdate = sc.nextLine();

				System.out.println("What do you want to update the field to?");
				dataToUpdateTheFieldTo = sc.nextLine();

				DAO.updateDB(idOfAnimalToUpdate, fieldToUpdate, dataToUpdateTheFieldTo);
				validMenuInput = true;
				break;
			case "4":
				DAO.readFromDB();
				System.out.println("Please enter the ID number of the animal that is in heaven");
				animalToDelete = Integer.parseInt(sc.nextLine());
				DAO.deleteFromDB(animalToDelete);
				validMenuInput = true;
				break;
			case "5":
				validMenuInput = false;

				break;

			default:
				System.out.println("Please enter vaild option.");
				validMenuInput = true;

				break;
			}
		} while (validMenuInput);
	}

}
