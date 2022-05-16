package entities;

import metadata.Mana;

/**
 * Abstract class that represents a MTG Card.
 * @author Jan Bogdziewicz
 */
public abstract class Card implements Comparable<Card>, Cloneable {
	
	
	/**
	 * An Enum that defines a card's rarity
	 * @author student
	 *
	 */
	public enum Rarity {
		COMMON,
		UNCOMMON,
		RARE,
		MYTHIC_RARE
	}
	
	/**
	 * Name of the card
	 */
	protected String name;
	
	
	/**
	 * Mana cost of the card
	 */
	protected Mana cost;
	
	/**
	 * Set from which the card comes
	 */
	protected String set;
	
	/**
	 * Type of the card
	 */
	protected String type;
	
	/**
	 * Subtype of the card. Some cards don't have subtypes, then this value is NULL
	 */
	protected String subtype;
	
	/**
	 * Card's color identity.
	 */
	protected String[] colorIdentity;
	
	/**
	 * Card's rarity
	 */
	protected Rarity rarity;
	
	/**
	 * Default card constructor
	 */
	public Card() {
		this.name = "";
		this.cost = new Mana();
		this.set = "";
		this.type = null;
		this.subtype = null;
		this.colorIdentity = new String[5];
	}
	
	/**
	 * Full card constructor
	 */
	public Card(String name, Mana cost, String set, String subtype, String[] colorIdentity, Rarity rarity) {
		this.name = name;
		this.cost = cost;
		this.set = set;
		this.type = null;
		this.subtype = subtype;
		this.colorIdentity = colorIdentity;
		this.rarity = rarity;
	}
	
	/**
	 * This function prints basic information that every card has.
	 */
	public void print() {
		System.out.println("Name: " + this.name);
		System.out.println("CMC: " + this.cost.getConvertedManaCost());
		System.out.println("Set: " + this.set);
		if(this.type != null) 
			System.out.println("Type: " + this.type);
		if(this.subtype != null) 
			System.out.println("Subtype: " + this.subtype);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
    public int compareTo(Card card) {
        return ((Integer)this.cost.getConvertedManaCost()).compareTo((Integer)card.cost.getConvertedManaCost());
    }
	
	public Object clone() throws CloneNotSupportedException {
        Card clonedCard = (Card)super.clone(); 
        clonedCard.colorIdentity = (String[])this.colorIdentity.clone();
        clonedCard.cost = (Mana)this.cost.clone();
        
        return clonedCard;
    }
	
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mana getCost() {
		return cost;
	}

	public void setCost(Mana cost) {
		this.cost = cost;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String[] getColorIdentity() {
		return colorIdentity;
	}

	public void setColorIdentity(String[] colorIdentity) {
		this.colorIdentity = colorIdentity;
	}
}
