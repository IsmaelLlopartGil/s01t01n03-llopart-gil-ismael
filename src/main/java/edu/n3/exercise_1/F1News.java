package edu.n3.exercise_1;

import com.liche.utils.io.Input;

public class F1News extends News{

	private String team;
	
	public F1News(String headline) {
		super(headline);
		
	}

	@Override
	public void setData() {
	super.setData();
	team=Input.readString("Introdueix el nom de l'escuderia: ");
	}
	
	
	@Override
	public int calculatePrice() {
		int tempPrice=100;
		
		if (team.equals("Ferrari") || team.equals("Mercedes")) {
			tempPrice+=50;
		}

		price=tempPrice;
		return price;
	}

	@Override
	public int calculateScore() {
		int tempScore=4;
		
		if (team.equals("Ferrari") || team.equals("Mercedes")) {
			tempScore+=2;
		}
		
		score=tempScore;
		return score;
	}

}
