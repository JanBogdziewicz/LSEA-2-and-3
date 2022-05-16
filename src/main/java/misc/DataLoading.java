package misc;

import java.io.FileReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import entities.Card;
import entities.CreatureCard;
import entities.EquipmentCard;
import metadata.Mana;

public class DataLoading {
	private int numberOfRecords;
//	public static void loadData(ArrayList<Card> cards) {
//		try {
//			cards.clear();
//			String filePath = "G:\\My Drive\\Studies\\Semester 6\\Large Scale Enterprise Applications\\Lab 3\\data.csv";
//
//	        FileReader filereader = new FileReader(filePath);
//
//	        CSVReader csvReader = new CSVReader(filereader);
//	        String[] record;
//	        	
//	        int counter = 0;
//
//	        while ((record = csvReader.readNext()) != null && counter < cards_amount) {
//	        	int id_amount = 5;
//				for(int i = 10; i <= 14; i++) {
//					if(record[i] == "") {
//						id_amount--;
//					}
//				}
//				
//				String[] identity = new String[id_amount];
//				
//				for(int i = 10; i < 10+id_amount; i++) {
//					identity[i-10] = record[i];
//				}
//				
//				Card new_card;
//				
//				if(record[8] == "creature") {
//					new_card = new CreatureCard(record[0],
//													 new Mana(Integer.parseInt(record[1]), 
//															  Integer.parseInt(record[2]), 
//															  Integer.parseInt(record[3]), 
//															  Integer.parseInt(record[4]), 
//															  Integer.parseInt(record[5]), 
//															  Integer.parseInt(record[6])),
//													 record[7],
//													 record[9],
//													 identity,
//													 Card.Rarity.valueOf(record[15]),
//													 Integer.parseInt(record[16]),
//													 Integer.parseInt(record[17]));
//				} else {
//					new_card =  new EquipmentCard(record[0],
//													   new Mana(Integer.parseInt(record[1]), 
//																Integer.parseInt(record[2]), 
//																Integer.parseInt(record[3]), 
//																Integer.parseInt(record[4]), 
//																Integer.parseInt(record[5]), 
//																Integer.parseInt(record[6])),
//													   record[7],
//													   record[9],
//													   identity,
//													   Card.Rarity.valueOf(record[15]),
//													   Integer.parseInt(record[16]));
//				}
//				
//				counter++;
//				cards.add(new_card);
//				synchronized 
//				System.out.println("Added card number: " + counter);
//	        }
//	        csvReader.close();
//	        
//	    }
//	    catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
	
}
