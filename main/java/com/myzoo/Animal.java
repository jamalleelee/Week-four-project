package com.myzoo;

public class Animal {

	private int animalID = 0;
	private String animalSpecies = null;
	private String animalName = null;
	private String animalColor = null;
	private String animalFood = null;
	private String animalEnclosure = null;
	private double animalWeight = 0.0;

	public Animal() {
		super();
	}

	public int getAnimalID() {
		return animalID;
	}

	public void setAnimalID(int animalID) {
		this.animalID = animalID;
	}

	public String getAnimalSpecies() {
		return animalSpecies;
	}

	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalColor() {
		return animalColor;
	}

	public void setAnimalColor(String animalColor) {
		this.animalColor = animalColor;
	}

	public String getAnimalFood() {
		return animalFood;
	}

	public void setAnimalFood(String animalFood) {
		this.animalFood = animalFood;
	}

	public String getAnimalEnclosure() {
		return animalEnclosure;
	}

	public void setAnimalEnclosure(String animalEnclosure) {
		this.animalEnclosure = animalEnclosure;
	}

	public double getAnimalWeight() {
		return animalWeight;
	}

	public void setAnimalWeight(double animalWeight) {
		this.animalWeight = animalWeight;
	}

	@Override
	public String toString() {
		return "A " + animalSpecies + " named " + animalName + ". It is " + animalColor + " and eats " + animalFood
				+ ". It lives in a " + animalEnclosure + " type enclosure, and weighs " + animalWeight
				+ "pounds! This animals ID is: " + animalID + "\n";
	}

}
