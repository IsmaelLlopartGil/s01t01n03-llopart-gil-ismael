package edu.n3.exercise_1;

import com.liche.utils.console.menu.ConsoleMenu;
import com.liche.utils.io.*;

public class App {
	
	private static EditorialOffice editorial;
	
	public static void main(String[] args) {
		
		ConsoleMenu mainMenu=new ConsoleMenu();
		mainMenu.addOption("Introduir redactor");
		mainMenu.addOption("Eliminar redactor");
		mainMenu.addOption("Introduir notícia a un redactor");
		mainMenu.addOption("Eliminar notícia");
		mainMenu.addOption("Mostrar totes les notícies per redactor");
		mainMenu.addOption("Calcular puntuació de la notícia");
		mainMenu.addOption("Calcular preu-notícia");
		mainMenu.addOption("Sortir");
		
		boolean exit=false;
		editorial=new EditorialOffice("Tot Esports", 1500);
		
		do {
			
			switch (mainMenu.run()) {
			
			case "Introduir redactor":
				editorial.addEditor(Input.readString("Introdueix el nom: "), Input.readString("Introdueix el DNI: "));
				break;
				
			case "Eliminar redactor":
				editorial.removeEditor(Input.readString("Introdueix el DNI: "));
				break;
				
			case "Introduir notícia a un redactor":
				addNews();
				break;
				
			case "Eliminar notícia":
				removeNews();
				break;
				
			case "Mostrar totes les notícies per redactor":
				showNews();
				break;
				
			case "Calcular puntuació de la notícia":
				calculateScore();
				break;
				
			case "Calcular preu-notícia":
				calculatePrice();	
				break;
				
			case "Sortir":
					exit=true;
				break;
				
			default:
			}
			
		} while (!exit);	
	}

	private static void addNews() {
		String editorDni=Input.readString("Introdueix el DNI de l'editor: ");
		
		if (editorial.ifExistEditor(editorDni)) {
							
			String headLine=Input.readString("Introdueix el títol de la notícia: ");
			
			if (!editorial.ifExistNews(headLine)) {
				News news=null;
				
				switch (requestNewsType()) {
				
				case "Notícia de futbol":
					news=new FootballNews(headLine);
					break;
					
				case "Notícia de bàsquet":
					news=new BasketballNews(headLine);
					break;
					
				case "Notícia de tenis":
					news=new TennisNews(headLine);
					break;
					
				case "Notícia de F1":
					news=new F1News(headLine);
					break;
					
				case "Notícia de motociclisme":
					news=new MotorcyclingNews(headLine);
					break;	
				
				default:
				}	
				if (news!=null) {
					news.setData();
					editorial.addNews(editorDni, news);
				}
				
			}	else {
				System.out.println("El títol de la notícia ja existeix.");
				Input.readString("Prem intro.");
			}
			
		} else {
			System.out.println("El redactor no existeix.");
			Input.readString("Prem intro.");
		}
	}

	private static void removeNews() {
		String editorDni=Input.readString("Introdueix el DNI de l'redactor: ");
		
		if (editorial.ifExistEditor(editorDni)) {
			String headLine=Input.readString("Introdueix el títol de la notícia: ");
			
			if (editorial.ifExistNews(headLine)) {
				editorial.removeNews(editorDni, headLine);
				System.out.println("Notícia eliminada.");
				Input.readString("Prem intro.");
			} else {
				System.out.println("La notícia no existeix.");
				Input.readString("Prem intro.");
			}
		} else {
			System.out.println("El redactor no existeix.");
			Input.readString("Prem intro.");
		}
	}

	private static void showNews() {
		String editorDni=Input.readString("Introdueix el DNI de l'redactor: ");
		
		if (editorial.ifExistEditor(editorDni)) {
			
			editorial.showNews(editorDni);
		} else {
			System.out.println("El redactor no existeix.");
			Input.readString("Prem intro.");
		}
	}

	private static void calculateScore() {
		String editorDni=Input.readString("Introdueix el DNI de l'redactor: ");
		
		if (editorial.ifExistEditor(editorDni)) {
			String headLine=Input.readString("Introdueix el títol de la notícia: ");
			
			if (editorial.ifExistNews(headLine)) {
				System.out.println("Puntuació de la notícia: " + editorial.calculateScore(editorDni, headLine)); 
				
			} else {
				System.out.println("La notícia no existeix.");
				Input.readString("Prem intro.");
			}
		} else {
			System.out.println("El redactor no existeix.");
			Input.readString("Prem intro.");
		}		
	}

	private static void calculatePrice() {
		String editorDni=Input.readString("Introdueix el DNI de l'redactor: ");
		
		if (editorial.ifExistEditor(editorDni)) {
			String headLine=Input.readString("Introdueix el títol de la notícia: ");
			
			if (editorial.ifExistNews(headLine)) {
				System.out.println("Preu de la notícia: " + editorial.calculatePrice(editorDni, headLine)); 
				
			} else {
				System.out.println("La notícia no existeix.");
				Input.readString("Prem intro.");
			}
		} else {
			System.out.println("El redactor no existeix.");
			Input.readString("Prem intro.");
		}
	}

	private static String requestNewsType() {
		ConsoleMenu newsTypeMenu=new ConsoleMenu();
		newsTypeMenu.addOption("Notícia de futbol");
		newsTypeMenu.addOption("Notícia de bàsquet");
		newsTypeMenu.addOption("Notícia de tenis");
		newsTypeMenu.addOption("Notícia de F1");
		newsTypeMenu.addOption("Notícia de motociclisme");
		newsTypeMenu.addOption("Sortir");	
		return newsTypeMenu.run();
	}
}
