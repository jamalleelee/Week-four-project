package com.myzoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	static Scanner sc = new Scanner(System.in);

	public static void connToDB() {

		try {
			System.out.println("Connecting to Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Conneced to Database.");
		} catch (SQLException e) {
			System.out.println("Failed to connect to Database.");
			e.printStackTrace();

		}

	}

	public static void readFromDB() {
		connToDB();
		ArrayList<Animal> animalsInMyZoo = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM zoo.animals_in_the_zoo;");

			while (RES_SET.next()) {

				Animal animalsInMyDB = new Animal();
				animalsInMyDB.setAnimalID(RES_SET.getInt("animal_id"));
				animalsInMyDB.setAnimalSpecies(RES_SET.getString("animal_species"));
				animalsInMyDB.setAnimalName(RES_SET.getString("animal_name"));
				animalsInMyDB.setAnimalColor(RES_SET.getString("animal_color"));
				animalsInMyDB.setAnimalFood(RES_SET.getString("animal_food"));
				animalsInMyDB.setAnimalEnclosure(RES_SET.getString("animal_enclosure"));
				animalsInMyDB.setAnimalWeight(RES_SET.getDouble("animal_weight"));

				animalsInMyZoo.add(animalsInMyDB);
			}
			for (Animal animal : animalsInMyZoo) {
				System.out.println(animal.toString());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void writeToDB() {
		Animal animalToAdd = new Animal();

		animalToAdd = aboutTheAnimal();
		connToDB();

		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);
			PREP_STMT.setString(1, animalToAdd.getAnimalSpecies());
			PREP_STMT.setString(2, animalToAdd.getAnimalName());
			PREP_STMT.setString(3, animalToAdd.getAnimalColor());
			PREP_STMT.setString(4, animalToAdd.getAnimalFood());
			PREP_STMT.setString(5, animalToAdd.getAnimalEnclosure());
			PREP_STMT.setDouble(6, animalToAdd.getAnimalWeight());
			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateDB(int idOfAnimalToUpdate, String fieldToUpdate, String dataToUpdateTheFieldTo) {
		connToDB();
		switch (fieldToUpdate) {
		case "1":
			try {

				PREP_STMT = CONN.prepareStatement(
						"UPDATE `zoo`.`animals_in_the_zoo` SET `animal_species`=? WHERE `animal_id`=?;");
				PREP_STMT.setInt(2, idOfAnimalToUpdate);
				PREP_STMT.setString(1, dataToUpdateTheFieldTo);
				PREP_STMT.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "2":

			try {
				PREP_STMT = CONN
						.prepareStatement("UPDATE `zoo`.`animals_in_the_zoo` SET `animal_name`=? WHERE `animal_id`=?;");
				PREP_STMT.setInt(2, idOfAnimalToUpdate);
				PREP_STMT.setString(1, dataToUpdateTheFieldTo);
				PREP_STMT.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "3":

			try {
				PREP_STMT = CONN.prepareStatement(
						"UPDATE `zoo`.`animals_in_the_zoo` SET `animal_color`=? WHERE `animal_id`=?;");
				PREP_STMT.setInt(2, idOfAnimalToUpdate);
				PREP_STMT.setString(1, dataToUpdateTheFieldTo);
				PREP_STMT.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "4":

			try {
				PREP_STMT = CONN
						.prepareStatement("UPDATE `zoo`.`animals_in_the_zoo` SET `animal_food`=? WHERE `animal_id`=?;");
				PREP_STMT.setInt(2, idOfAnimalToUpdate);
				PREP_STMT.setString(1, dataToUpdateTheFieldTo);
				PREP_STMT.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "5":

			try {
				PREP_STMT = CONN.prepareStatement(
						"UPDATE `zoo`.`animals_in_the_zoo` SET `animal_enclosure`=? WHERE `animal_id`=?;");
				PREP_STMT.setInt(2, idOfAnimalToUpdate);
				PREP_STMT.setString(1, dataToUpdateTheFieldTo);
				PREP_STMT.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
		case "6":

			try {
				PREP_STMT = CONN.prepareStatement(
						"UPDATE `zoo`.`animals_in_the_zoo` SET `animal_weight`=? WHERE `animal_id`=?;");
				PREP_STMT.setInt(2, idOfAnimalToUpdate);
				PREP_STMT.setDouble(1, Double.parseDouble(dataToUpdateTheFieldTo));
				PREP_STMT.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		default:
			break;
		}

	}

	public static void deleteFromDB(int animalToDelete) {
		connToDB();

		try {
			PREP_STMT = CONN.prepareStatement(deleteFromDB);
			PREP_STMT.setInt(1, animalToDelete);
			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static String insertToDB = "INSERT INTO `zoo`.`animals_in_the_zoo`"
			+ "(animal_species, animal_name, animal_color, animal_food, animal_enclosure, animal_weight)" + "VALUES"
			+ "(?, ?, ?, ?, ?, ?)";

	private static String deleteFromDB = "DELETE FROM `zoo`.`animals_in_the_zoo`" + "WHERE" + "(animal_id=?)";

	public static Animal aboutTheAnimal() {
		Animal animalToAdd = new Animal();
		// info from online form

		System.out.println("What is the SPECIES of the animal?");
		animalToAdd.setAnimalSpecies(sc.nextLine());

		System.out.println("What is the NAME of the animal?");
		animalToAdd.setAnimalName(sc.nextLine());

		System.out.println("What is the COLOR of the animal?");
		animalToAdd.setAnimalColor(sc.nextLine());

		System.out.println("What type of FOOD does the animal eat?");
		animalToAdd.setAnimalFood(sc.nextLine());

		System.out.println("What type of ENCLOSURE does the animal live in?");
		animalToAdd.setAnimalEnclosure(sc.nextLine());

		System.out.println("What is the WEIGHT of the animal?");
		animalToAdd.setAnimalWeight(Double.parseDouble(sc.nextLine()));

		return animalToAdd;

	}
} // class
