package entities;

import java.util.ArrayList;
import java.util.HashMap;

import metadata.Mana;

import java.util.Collections;

/**
 * Class that represents a deck of cards constructed by the player/user
 * @author Jan Bogdziewicz
 */
public class Deck implements Comparable<Deck>, Cloneable {
	
	/**
	 * List that holds all cards
	 */
	private ArrayList<Card> cards;
	
	/**
	 * HashMap that stores the amount of each card in a deck
	 */
	private HashMap<String, Integer> cardCount;
	
	/**
	 * Tells if deck is valid to play with
	 */
	private Boolean valid;
	
	/**
	 * Default constructor
	 */
	public Deck() {
		this.cards = new ArrayList<Card>();
		this.cardCount = new HashMap<String, Integer>();
		this.valid = false;
	}
	
	
	/**
	 * Adds a card to the deck
	 * @param card - Card that should be added
	 */
	public void addCard(Card card) {
		this.cards.add(card);
		if(this.cardCount.containsKey(card.name))
			this.cardCount.put(card.name, this.cardCount.get(card.name) + 1);
		else
			this.cardCount.put(card.name, 1);
		
		this.valid = this.validate();
	}
	
	/**
	 * Shuffles the deck so that cards are presented in different order
	 */
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	/**
	 * Checks if the deck is valid to play with
	 */
	private Boolean validate() {
		if (this.cards.size() < 60)
			return false;
		for (int amount : this.cardCount.values()) {
			if (amount > 4)
				return false;
		}
		return true;
	}
	
	/**
	 * Prints all cards from the deck
	 */
	public void print() {
		for (Card card : this.cards) {
			card.print();
			System.out.println();			
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
    public int compareTo(Deck deck) {
        return ((Integer)this.cards.size()).compareTo((Integer)deck.cards.size());
    }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		try {
			Deck dcopy = (Deck)super.clone();
			dcopy.cards = (ArrayList<Card>)this.cards.clone();
			dcopy.cardCount = (HashMap<String, Integer>)this.cardCount.clone();
			return dcopy;
	    } catch (CloneNotSupportedException e) {
	        Deck dcopy = new Deck();
	        dcopy.valid = this.valid;
	        dcopy.cards = (ArrayList<Card>)this.cards.clone();
			dcopy.cardCount = (HashMap<String, Integer>)this.cardCount.clone();
			return dcopy;
	    }	
	}
	
	/**
	 * This method sorts the deck of cards 
	 * according to cards converted mana cost
	 */
	public void sortDeck() {
		Collections.sort(this.cards);
	}
	
	//getters and setters
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public HashMap<String, Integer> getCardCount() {
		return cardCount;
	}

	public void setCardCount(HashMap<String, Integer> cardCount) {
		this.cardCount = cardCount;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}
