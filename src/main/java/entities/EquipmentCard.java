package entities;

import metadata.Mana;

/**
 * Subclass of Card which represents an equipment card
 * @author Jan Bogdziewicz
 */
public class EquipmentCard extends Card implements Cloneable {
	/**
	 * Cost of using card's equip ability
	 */
	private int equipCost;
	
	/**
	 * Default equipment card constructor
	 */
	public EquipmentCard() {
		super();
		this.type = "Equipment";
		this.equipCost = Integer.MAX_VALUE;
	}
	
	/**
	 * Full equipment card constructor
	 */
	public EquipmentCard(String name, Mana cost, String set, 
						String subtype, String[] colorIdentity, 
						Rarity rarity, int equipCost) {
		super(name, cost, set, subtype, colorIdentity, rarity);
		this.type = "Equipment";
		this.equipCost = equipCost;
	}
	
	/**
	 * Prints basic information about the card and also equipment-specific information
	 */
	@Override 
	public void print() {
		super.print();
		System.out.println("Equip cost: " + this.equipCost);
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
	public int getEquipCost() {
		return equipCost;
	}

	public void setEquipCost(int equipCost) {
		this.equipCost = equipCost;
	}
}
