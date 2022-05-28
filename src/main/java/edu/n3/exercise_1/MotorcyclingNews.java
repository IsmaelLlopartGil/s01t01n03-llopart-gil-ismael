package edu.n3.exercise_1;

import com.liche.utils.io.Input;

public class MotorcyclingNews extends News {

	private String team;

	public MotorcyclingNews(String headline) {
		super(headline);

	}
	
	@Override
	public void setData() {
	super.setData();
	team=Input.readString("Introdueix el nom de l'equip: ");
	}

	@Override
	public int calculatePrice() {
		int tempPrice=100;
		

		if (team.equals("Honda") || team.equals("Yamaha")) {
			tempPrice+=50;
		}
		
		price=tempPrice;
		return score;
	}

	@Override
	public int calculateScore() {
		int tempScore=3;
		
		if (team.equals("Honda") || team.equals("Yamaha")) {
			tempScore+=3;
		}
		
		score=tempScore;
		return score;
	}
}
