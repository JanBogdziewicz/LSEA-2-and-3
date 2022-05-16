package entities;

import java.util.HashMap;

import metadata.Mana;

/**
 * Subclass of Card which represents a creature card
 * @author Jan Bogdziewicz
 */
public class CreatureCard extends Card implements Cloneable {
	/**
	 * Strength of a creature
	 */
	private int strength;
	
	/**
	 * Toughness of a creature
	 */
	private int toughness;
	
	/**
	 * Default creature card constructor
	 */
	public CreatureCard() {
		super();
		this.type = "Creature";
		this.strength = 0;
		this.toughness = 0;
	}
	
	/**
	 * Full creature card constructor
	 */
	public CreatureCard(String name, Mana cost, String set, 
						String subtype, String[] colorIdentity, Rarity rarity,
						int strength, int toughness) {
		super(name, cost, set, subtype, colorIdentity, rarity);
		this.type = "Creature";
		this.strength = strength;
		this.toughness = toughness;
	}
	
	/**
	 * Prints basic information about the card and also creature-specific information
	 */
	@Override 
	public void print() {
		super.print();
		System.out.println("Strength: " + this.strength);
		System.out.println("Toughness: " + this.toughness);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		Card dcopy = (Card)super.clone();
		dcopy.cost = (Mana)this.cost.clone();
		dcopy.colorIdentity = this.colorIdentity.clone();
		return dcopy;
	}
	
	//getters and setters
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getToughness() {
		return toughness;
	}

	public void setToughness(int toughness) {
		this.toughness = toughness;
	}
}
