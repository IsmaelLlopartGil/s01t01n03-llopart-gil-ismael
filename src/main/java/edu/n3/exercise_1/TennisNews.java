package edu.n3.exercise_1;

import com.liche.utils.io.Input;

public class TennisNews extends News {

	private String competition;
	private String player1;
	private String player2;

	public TennisNews(String headline) {
		super(headline);

	}

	@Override
	public void setData() {
		super.setData();
		competition = Input.readString("Introdueix la competició: ");
		player1 = Input.readString("Introdueix el nom del jugador 1: ");
		player2 = Input.readString("Introdueix el nom del jugador 2: ");
	}

	@Override
	public int calculatePrice() {
		int tempPrice=150;
		
		switch (player1) {
		
		case "Federer":		
		case "Nadal":		
		case "Djokovic":
			tempPrice+=100;
			break;
			
		default:
		}
		
		switch (player2) {
		
		case "Federer":	
		case "Nadal":
		case "Djokovic":
			tempPrice+=100;
			break;
			
		default:
		}
		
		price=tempPrice;
		return price;
	}

	@Override
	public int calculateScore() {
		int tempScore=4;
		
		switch (player1) {
		
		case "Federer":		
		case "Nadal":		
		case "Djokovic":
			tempScore+=3;
			break;
			
		default:
		}
		
		switch (player2) {
		
		case "Federer":	
		case "Nadal":
		case "Djokovic":
			tempScore+=3;
			break;
			
		default:
		}
		
		score=tempScore;
		return score;
	}

}
