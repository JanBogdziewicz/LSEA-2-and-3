package metadata;

import java.util.HashMap;

/**
 * Class that represents a mana pool
 * @author Jan Bogdziewicz
 */
public final class Mana implements Cloneable {
	/**
	 * HashMap that stores amount of mana for each color
	 */
	private HashMap<String, Integer> colors;
	
	/**
	 * Sum of all of the values of colors field
	 */
	private int convertedManaCost;
	
	/**
	 * Default Mana constructor. Use when the card doesn't have cost
	 */
	public Mana() {
		this.colors = new HashMap<String, Integer>();
		
		this.colors.put("Neutral", 0);
		this.colors.put("White", 0);
		this.colors.put("Black", 0);
		this.colors.put("Red", 0);
		this.colors.put("Green", 0);
		this.colors.put("Blue", 0);
		
		this.convertedManaCost = 0;
	}
	
	/**
	 * Full mana constructor
	 */
	public Mana(int neutral, int white, int black, int red, int green, int blue) {
		this.colors = new HashMap<String, Integer>();
		
		this.colors.put("Neutral", neutral);
		this.colors.put("White", white);
		this.colors.put("Black", black);
		this.colors.put("Red", red);
		this.colors.put("Green", green);
		this.colors.put("Blue", blue);
		
		for (int color : this.colors.values()) {
			this.convertedManaCost += color;
		}
	}
	
	/**
	 * Changes mana pool to colorless.
	 */
	public void toColorless() {
		this.colors.put("Neutral", this.convertedManaCost);
		this.colors.put("White", 0);
		this.colors.put("Black", 0);
		this.colors.put("Red", 0);
		this.colors.put("Green", 0);
		this.colors.put("Blue", 0);
	}

	/**
	 * Prints mana pool contents
	 */
	public void print() {
		System.out.println("Cost: Neutral - " + this.colors.get("Neutral") + ", " + 
						   "White - " + this.colors.get("White") + ", " + 
						   "Black - " + this.colors.get("Black") + ", " + 
						   "Red - " + this.colors.get("Red") + ", " + 
						   "Green - " + this.colors.get("Green") + ", " + 
						   "Blue - " + this.colors.get("Blue"));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		Mana manaClone = (Mana)super.clone();
		manaClone.colors = new HashMap<String, Integer>();
		
		for (String colorKey : this.colors.keySet()) {
			manaClone.colors.put(colorKey, this.colors.get(colorKey));
		}
		
		return manaClone;
	}
	
	//getters and setters
	public HashMap<String, Integer> getColors() {
		return this.colors;
	}
	
	public void setColors(HashMap<String, Integer> colors) {
		this.colors = colors;
	}
	
	public int getConvertedManaCost() {
		return this.convertedManaCost;
	}

	public void setConvertedManaCost(int convertedManaCost) {
		this.convertedManaCost = convertedManaCost;
	}
}
