package edu.n3.exercise_1;

import com.liche.utils.io.Input;

public abstract class News {

	protected String headLine;
	protected String text;
	protected int score;
	protected int price;
	
	public News(String headline) {
		this.headLine=headline;
		score=-1;
		price=-1;
	}
	
	public void setData() {
	text = Input.readString("Introdueix el text de la noticia: ");
	}
	
	public abstract int calculatePrice();
	
	public abstract int calculateScore();
	
	public String getHeadLine() {
		return headLine;
	}

	@Override
	public String toString() {
		return "Títol: " + headLine + ", Text: " + text + ", Puntuació: " + score + ", Preu: " + price + "\n";
	}
	
}
