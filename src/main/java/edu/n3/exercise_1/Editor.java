package edu.n3.exercise_1;

import java.util.*;

public class Editor {

	private String name;
	private final String dni;
	List<News> newsList;
	
	public Editor(String name, String dni) {
		this.name=name;
		this.dni=dni;
		newsList=new ArrayList<>();
	}
	
	public String getDni() {
		return dni;
	}
	
	public void addNews(News news) {
		assert news != null;
		
		newsList.add(news);
	}

	public boolean ifExistNews(String headLine) {
		boolean result=false;
		
		for (News news : newsList) {
			
			if (news.getHeadLine().equals(headLine)) {
				result=true;
			}
		}
		
		return result;
	}

	public void removeNews(String headLine) {
		
		for (int i=0; i<newsList.size(); i++) {
			
			if (newsList.get(i).getHeadLine().equals(headLine)) {
				newsList.remove(i);
			}
		}
	}

	public void showNews() {
		System.out.println(newsList);
	}

	public int calculateScore(String headLine) {
		int result=-1;
		
		for (int i=0; i<newsList.size(); i++) {
			
			if (newsList.get(i).getHeadLine().equals(headLine)) {
				result=newsList.get(i).calculateScore();
			}
		}
		return result;
	}

	public int calculatePrice(String headLine) {
		int result=-1;
		
		for (int i=0; i<newsList.size(); i++) {
			
			if (newsList.get(i).getHeadLine().equals(headLine)) {
				result=newsList.get(i).calculatePrice();
			}
		}
		return result;
	}
}
