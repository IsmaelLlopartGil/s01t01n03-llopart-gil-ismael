package edu.n3.exercise_1;

import com.liche.utils.io.Input;

public class FootballNews extends News{

	private String competition;
	private String club;
	private String player;
	
	public FootballNews(String headline) {
		super(headline);
	}
	
	@Override
	public void setData() {
	super.setData();
	competition=Input.readString("Introdueix la competició: ");
	club=Input.readString("Introdueix el nom del club: ");
	player=Input.readString("Introdueix el nom del jugador: ");
	}

	@Override
	public int calculatePrice() {
		int tempPrice=300;
		
		if (competition.equals("Lliga de Campions")) {
			tempPrice+=100;
		}
		
		if (club.equals("Barça") || club.equals("Madrid")) {
			tempPrice+=100;
		}
		
		if (player.equals("Ferran Torres") || player.equals("Benzema")) {
			tempPrice+=50;
		}
		
		price=tempPrice;
		return price;
	}

	@Override
	public int calculateScore() {
		int tempScore=5;
		
		if (competition.equals("Lliga de Campions")) {
			tempScore+=3;
		}
		
		if (competition.equals("Lliga")) {
			tempScore+=2;
		}
		
		if (club.equals("Barça") || club.equals("Madrid")) {
			tempScore+=1;
		}
		
		if (player.equals("Ferran Torres") || player.equals("Benzema")) {
			tempScore+=1;
		}
		
		score=tempScore;
		return score;
	}

}
