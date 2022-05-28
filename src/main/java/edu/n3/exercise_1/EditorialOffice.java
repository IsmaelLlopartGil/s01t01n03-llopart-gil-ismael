package edu.n3.exercise_1;

import java.util.*;
import com.liche.utils.io.*;

public class EditorialOffice {
	private String name;
	private double editorsSalary;
	private List<Editor> editorList;
	
	public EditorialOffice(String name, double editorsSalary) {
		this.name=name;
		this.editorsSalary=editorsSalary;
		editorList=new ArrayList<>();
	}
	
	public void addEditor(String name, String dni) {
		
		if (!ifExistEditor(dni)) {
			Editor editor=new Editor(name, dni);
			editorList.add(editor);
		} else {
			System.out.println("El redactor ya existeix.");
			Input.readString("Prem intro.");
		}
		
	}

	public void removeEditor(String dni) {		
		int editorIndex=searchEditor(dni);
		
		if (editorIndex!=-1) {
			editorList.remove(editorIndex);
			System.out.println("Redactor eliminat.");
			Input.readString("Prem intro.");
		} else {
			System.out.println("El redactor no existeix.");
			Input.readString("Prem intro.");
		}		
	}
	
	private int searchEditor(String dni) {
		int index=-1;
		
		if (editorList!=null) {		
			int i=0;
			
			while (i<editorList.size() && index==-1) {
				
				if (editorList.get(i).getDni().equals(dni)) {
					index=i;
				}
				
				i++;
			}			
		} 
		
		return index;
	}
	
	public void addNews(String editorDni, News news) {
		int editorIndex=searchEditor(editorDni);
		editorList.get(editorIndex).addNews(news);
	}
	
	public boolean ifExistEditor(String dni) {
		boolean result=false;
		
		if (searchEditor(dni)!=-1) {
			result=true;
		}	
		return result;		
	}

	public boolean ifExistNews(String headLine) {
		boolean result=false;
		
		for (Editor editor : editorList) {
			
			if (editor.ifExistNews(headLine)) {
				result=true;
			}
		}
		
		return result;
	}

	public void removeNews(String editorDni, String headLine) {
		int indexEditor = searchEditor(editorDni);
		editorList.get(indexEditor).removeNews(headLine);
	}

	public void showNews(String editorDni) {
		int indexEditor = searchEditor(editorDni);
		editorList.get(indexEditor).showNews();
	}

	public int calculateScore(String editorDni, String headLine) {
		int indexEditor = searchEditor(editorDni);
		return editorList.get(indexEditor).calculateScore(headLine);
	}

	public int calculatePrice(String editorDni, String headLine) {
		int indexEditor = searchEditor(editorDni);
		return editorList.get(indexEditor).calculatePrice(headLine);
	}
}
