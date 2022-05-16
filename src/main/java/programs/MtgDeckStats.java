package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import entities.Card;
import entities.CreatureCard;
import entities.Deck;
import entities.EquipmentCard;
import metadata.Mana;

/**
 * Executable class used to calculate statistics for decks
 * @author Jan Bogdziewicz
 */
public class MtgDeckStats {

	/**
	 * Creates sample data for the application
	 * @param decks - list of decks that new decks will be appended to
	 * @param cards - list of cards in database, to which new cards will be added
	 */
	public static void sampleData(ArrayList<Deck> decks, ArrayList<Card> cards) {
		decks.add(new Deck());
		decks.add(new Deck());
		
		cards.add(new CreatureCard("Valki, God of Lies", new Mana(1, 0, 1, 0, 0, 0), 
				  "Kaldheim", "God", new String[] {"Black"}, Card.Rarity.COMMON, 2, 1));
		cards.add(new CreatureCard("Karazikar, the Eye Tyrant", new Mana(3, 0, 1, 1, 0, 0), 
				  "DnD", "Beholder", new String[] {"Black", "Red"}, Card.Rarity.RARE, 5, 5));
		cards.add(new CreatureCard("Grim Hireling", new Mana(3, 0, 1, 0, 0, 0), 
				  "DnD", "Tiefling Rogue", new String[] {"Black"}, Card.Rarity.UNCOMMON, 3, 2));
		cards.add(new EquipmentCard("Sol Talisman", new Mana(), 
				  "Strixhaven", null, new String[] {}, Card.Rarity.COMMON, 3));
		cards.add(new EquipmentCard("Swiftfoot Boots", new Mana(2, 0, 0, 0, 0, 0), 
				  "Strixhaven", "Boots", new String[] {}, Card.Rarity.MYTHIC_RARE, 1));
		
		cards.add(new CreatureCard("Tectonic Giant", new Mana(2, 0, 0, 2, 0, 0), 
				  "Kaldheim", "Elemental Giant", new String[] {"Red"}, Card.Rarity.MYTHIC_RARE, 3, 4));
		cards.add(new CreatureCard("Dream Pillager", new Mana(5, 0, 0, 2, 0, 0), 
				  "Kaldheim", "Dragon", new String[] {"Red"}, Card.Rarity.UNCOMMON, 4, 4));
		cards.add(new CreatureCard("Lealia, the Blade Reforged", new Mana(2, 0, 0, 1, 0, 0), 
				  "Strixhaven", "Spirit Warrior", new String[] {"Red"}, Card.Rarity.UNCOMMON, 2, 2));
		cards.add(new EquipmentCard("Commander's Sphere", new Mana(3, 0, 0, 0, 0, 0), 
				  "Kamigawa", "Sphere", new String[] {}, Card.Rarity.MYTHIC_RARE, 2));
		cards.add(new EquipmentCard("Oracle's Vault", new Mana(4, 0, 0, 0, 0, 0), 
				  "DnD", null, new String[] {}, Card.Rarity.COMMON, 5));
		
		decks.get(0).addCard(cards.get(0));
		decks.get(0).addCard(cards.get(1));
		decks.get(0).addCard(cards.get(2));
		decks.get(0).addCard(cards.get(3));
		decks.get(0).addCard(cards.get(4));
		
		decks.get(1).addCard(cards.get(5));
		decks.get(1).addCard(cards.get(6));
		decks.get(1).addCard(cards.get(7));
		decks.get(1).addCard(cards.get(8));
		decks.get(1).addCard(cards.get(9));

	}
	
	/**
	 * Prints options to use within the application
	 */
	public static void printHelp() {
		System.out.println("Welcome to MTG Deck Builder - please select option:");
		System.out.println("S - Sample Data");
		System.out.println("M - calculate mean converted mana cost");
		System.out.println("C - calculate number of cards in particular color");
	}
	
	
	/**
	 * Calculates mean of the deck cards converted mana cost
	 * @param deck - deck of which mean cmc should be calculated
	 * @return calculated mean of converted mana cost
	 */
	public static double cmcMean(Deck deck) {
		int sum = 0;
		for (Card card : deck.getCards()) {
			sum+=card.getCost().getConvertedManaCost();
		}
		return Double.valueOf(sum)/Double.valueOf(deck.getCards().size());
	}
	
	/**
	 * Counts how many cards of each color are present in the deck. 
	 * Note that if a card has more than one color it will be counted for each color separately.
	 * If card is non-colored then it won't be count.
	 * @param deck - deck of which colors should be counted
	 * @return The hashmap of colors and counts
	 */
	public static HashMap<String, Integer> countColors(Deck deck) {
		HashMap<String, Integer> colorCount = new HashMap<String, Integer>();
		
		for (Card card : deck.getCards()) {
			for (String color : card.getColorIdentity()) {
				if (colorCount.containsKey(color))
					colorCount.put(color, colorCount.get(color) + 1);
				else
					colorCount.put(color, 1);
			}
		}
		
		return colorCount;
	}
	
	
	/**
	 * Main method
	 * @param args - currently none
	 */
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			ArrayList<Deck> decks = new ArrayList<Deck>();
			ArrayList<Card> cards = new ArrayList<Card>();
			
			System.out.println("Give username: ");
			String username = scn.nextLine();
			String option;
			int id;
			
			printHelp();
			
			while (true) {
				option = scn.nextLine();
				switch(option) {
				case "S":
					sampleData(decks, cards);
					break;
				case "M":
					System.out.println("ID: ");
					id = scn.nextInt();
					scn.nextLine();
					double mean = cmcMean(decks.get(id));
					System.out.println("Mean CMC of this deck is: " + mean);
					break;
				case "C":
					System.out.println("ID: ");
					id = scn.nextInt();
					scn.nextLine();
					HashMap<String, Integer> colorCounts = countColors(decks.get(id));
					for (String color : colorCounts.keySet()) {
						System.out.println(color + " " + colorCounts.get(color));
					}
					break;
				default:
					System.out.println("Please select valid option!");
				}
			}
		}
	}

}
