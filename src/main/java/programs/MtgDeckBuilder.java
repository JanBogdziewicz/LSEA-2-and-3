package programs;

import entities.*;
import metadata.Mana;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;

import misc.*;

/**
 * Executable class that manages MTG deck building
 * @author Jan Bogdziewicz
 */
public class MtgDeckBuilder {
	
	public static final int cards_amount = 3000000;
	
	/**
	 * Creates new empty card deck and appends it to app's list of decks
	 * @param decks - List of decks that the new deck should be appended to
	 * @return Newly created deck
	 */
	public static Deck createDeck(ArrayList<Deck> decks) {
		Deck newDeck = new Deck();
		decks.add(newDeck);
		return newDeck;
	}
	
	/**
	 * Deletes particular deck
	 * @param decks - List of decks
	 * @param id - ID of deck that should be deleted
	 */
	public static void deleteDeck(ArrayList<Deck> decks, int id) {
		decks.remove(id);
	}
	
	
	/**
	 * Creates sample data for the application
	 * @param decks - list of decks that new decks will be appended to
	 * @param cards - list of cards in database, to which new cards will be added
	 */
	public static void sampleData(ArrayList<Deck> decks, ArrayList<Card> cards) {
		decks.add(new Deck());
		decks.add(new Deck());
		
		//polymorphism example - elements of "cards" are Card objects, but I'm adding CreatureCard and EquipmentCard objects instead
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
		cards.add(new EquipmentCard("Super Boots", new Mana(4, 0, 0, 0, 0, 0), 
				  "DnD", "Boots", new String[] {}, Card.Rarity.RARE, 4));
		
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
		decks.get(0).addCard(cards.get(5));
		
		decks.get(1).addCard(cards.get(6));
		decks.get(1).addCard(cards.get(7));
		decks.get(1).addCard(cards.get(8));
		decks.get(1).addCard(cards.get(9));
		decks.get(1).addCard(cards.get(10));

	}
	
	/**
	 * Sorts the list of decks in the application
	 * @param decks - list of decks to be sorted
	 */
	public static void sortDecks(ArrayList<Deck> decks) {
		Collections.sort(decks);
	}
	
	/**
	 * Shows example of sorting decks
	 * @param decks - list of decks to be sorted
	 */
	public static void sortExample(ArrayList<Deck> decks) {
		decks.get(0).print();
		decks.get(0).sortDeck();
		decks.get(0).print();
		
		showDeckList(decks);
		sortDecks(decks);
		System.out.println();
		showDeckList(decks);
	}
	
	public static void cloneExample(Card card) {
		try {
			Card newCard = (Card)card.clone();
			newCard.setSet("DnD");
			newCard.setCost(new Mana());
			
			System.out.println("Old Card:");
			card.print();
			System.out.println();
			System.out.println("New Card:");
			newCard.print();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints options to use within the application
	 */
	public static void printHelp() {
		System.out.println("Welcome to MTG Deck Builder - please select option:");
		System.out.println("L - Show deck list");
		System.out.println("P - Print deck");
		System.out.println("O - Sorting example");
		System.out.println("C - Cloning example");
	}
	
	
	/**
	 * Prints ID's of decks and their sizes
	 * @param decks - list of decks to be printed
	 */
	public static void showDeckList(ArrayList<Deck> decks) {
		int iterator = 0;
		for (Deck deck : decks) {
			System.out.println("Deck #" + iterator + " - size: " + deck.getCards().size());
			iterator++;
		}
	}
	
	/**
	 * Prints a particular deck
	 * @param deck - a deck to be printed
	 */
	public static void showDeck(Deck deck) {
		deck.print();
	}
	
	public static void loadData(ArrayList<Card> cards) {
		try {
			cards.clear();
			String filePath = "G:\\My Drive\\Studies\\Semester 6\\Large Scale Enterprise Applications\\Lab 3\\data.csv";
			
	        FileReader filereader = new FileReader(filePath);

	        CSVReader csvReader = new CSVReader(filereader);
	        String[] record;
	        	
	        int counter = 0;

	        while ((record = csvReader.readNext()) != null && counter < cards_amount) {
	        	int id_amount = 5;
				for(int i = 10; i <= 14; i++) {
					if(record[i] == "") {
						id_amount--;
					}
				}
				
				String[] identity = new String[id_amount];
				
				for(int i = 10; i < 10+id_amount; i++) {
					identity[i-10] = record[i];
				}
				
				Card new_card;
				
				if(record[8] == "creature") {
					new_card = new CreatureCard(record[0],
													 new Mana(Integer.parseInt(record[1]), 
															  Integer.parseInt(record[2]), 
															  Integer.parseInt(record[3]), 
															  Integer.parseInt(record[4]), 
															  Integer.parseInt(record[5]), 
															  Integer.parseInt(record[6])),
													 record[7],
													 record[9],
													 identity,
													 Card.Rarity.valueOf(record[15]),
													 Integer.parseInt(record[16]),
													 Integer.parseInt(record[17]));
				} else {
					new_card =  new EquipmentCard(record[0],
													   new Mana(Integer.parseInt(record[1]), 
																Integer.parseInt(record[2]), 
																Integer.parseInt(record[3]), 
																Integer.parseInt(record[4]), 
																Integer.parseInt(record[5]), 
																Integer.parseInt(record[6])),
													   record[7],
													   record[9],
													   identity,
													   Card.Rarity.valueOf(record[15]),
													   Integer.parseInt(record[16]));
				}
				
				counter++;
				cards.add(new_card);
				System.out.println("Added card number: " + counter);
	        }
	        csvReader.close();
	        
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void durationTest(ArrayList<Card> cards) {
		int[] x = new int[cards_amount];
		int[] y = new int[cards_amount];
		int[] z = new int[cards_amount];
		
		for(int i = 0; i < cards_amount; i++) {
			x[i] = cards.get(i).getCost().getConvertedManaCost();
			if(cards.get(i).getType() == "creature") {
				y[i] = ((CreatureCard) cards.get(i)).getStrength();
				z[i] = ((CreatureCard) cards.get(i)).getToughness();
			}
		}
		
		Stats stats = new Stats(x, y);
		stats.Calculate();
		double result = stats.getSum();
		System.out.println("The result is: " + result);
	}
	
	public static void durationTestMulti(ArrayList<Card> cards, int numberOfThreads) {
		int[] x = new int[cards_amount];
		int[] y = new int[cards_amount];
		int[] z = new int[cards_amount];
		
		for(int i = 0; i < cards_amount; i++) {
			x[i] = cards.get(i).getCost().getConvertedManaCost();
			if(cards.get(i).getType() == "creature") {
				y[i] = ((CreatureCard) cards.get(i)).getStrength();
				z[i] = ((CreatureCard) cards.get(i)).getToughness();
			}
		}
		
		
		Stats stats = new Stats(x, y);
		
//		StatsMulti thread_1 = new StatsMulti(stats);
//		StatsMulti thread_2 = new StatsMulti(stats);
//		
//		thread_1.start();
//		thread_2.start();
		
		ThreadGroup tg = new ThreadGroup("main");
		int np = Runtime.getRuntime().availableProcessors();
		int ns = numberOfThreads;
 
		int[] ranges = new int[ns];
		for (int i=0; i<ns; i++) {
			ranges[i] = cards_amount/ns;
		}
		
		int rest = cards_amount % ns;
		
		for(int i=0; i<rest; i++) {
			ranges[i]++;
		}
		
		List<StatsMulti> threads = new ArrayList<StatsMulti>();
 
		for (int i=0; i < ns; i++) {
			threads.add(new StatsMulti("T"+i, tg, stats));
		}
		int i=0;
		while (i < threads.size()) {
			if (tg.activeCount() < np) {
				threads.get(i).start();
				i++;
			} else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}

		while(tg.activeCount() > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
//		try {
//			thread_1.join();
//			thread_2.join();
//		} catch (Exception e) {
//		}
		
		double result = stats.getSum();
		System.out.println("The result is: " + result);
	}
	
	/**
	 * Main method
	 * @param args - currently none
	 */
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			ArrayList<Deck> decks = new ArrayList<Deck>();
			ArrayList<Card> cards = new ArrayList<Card>();
			String option;
			
			sampleData(decks, cards);
			printHelp();
			
			while (true) {
				option = scn.nextLine();
				switch(option) {
				case "L":
					showDeckList(decks);
					break;
				case "P":
					System.out.println("ID: ");
					int id = scn.nextInt();
					scn.nextLine();
					showDeck(decks.get(id));
					break;
				case "O":
					sortExample(decks);
					break;
				case "C":
					cloneExample(cards.get(0));
					break;
				case "D":
					long start = System.currentTimeMillis();
					loadData(cards);
					long end = System.currentTimeMillis();
					long duration = end-start;
					
					for (int i=0; i < 10; i++) {
						cards.get(i).print();
					}
					System.out.println("Passed: " + duration + "ms");
					break;
				case "T":
					durationTest(cards);
					//System.out.println("Passed: " + duration + "ms");
				case "M":
					long starts = System.currentTimeMillis();
					durationTestMulti(cards, 2);
					long ends = System.currentTimeMillis();
					long durations = ends-starts;
					System.out.println("Passed: " + durations + "ms");
				default:
					System.out.println("Please select valid option!");
				}
			}
		}
	}
}
