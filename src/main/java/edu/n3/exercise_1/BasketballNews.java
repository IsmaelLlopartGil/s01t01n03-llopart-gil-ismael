package edu.n3.exercise_1;

import com.liche.utils.io.Input;

public class BasketballNews extends News{

	private String competition;
	private String club;
	
	public BasketballNews(String headline) {
		super(headline);
		
	}
	
	@Override
	public void setData() {
	super.setData();
	competition=Input.readString("Introdueix la competició: ");
	club=Input.readString("Introdueix el nom del club: ");
	}

	@Override
	public int calculatePrice() {
		int tempPrice=250;
		
		if (competition.equals("Eurolliga")) {
			tempPrice+=75;
		}
		
		if (club.equals("Barça") || club.equals("Madrid")) {
			tempPrice+=75;
		}
		
		price=tempPrice;
		return price;
	}

	@Override
	public int calculateScore() {
		int tempScore=4;
		
		if (competition.equals("ACB")) {
			tempScore+=2;
		}
		
		if (competition.equals("Eurolliga")) {
			tempScore+=3;
		}
		
		if (club.equals("Barça") || club.equals("Madrid")) {
			tempScore+=1;
		}
		
		score=tempScore;
		return score;
	}
	
	

}
