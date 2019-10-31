package ca.csf.dfc.classes.main.console;

import ca.csf.dfc.classes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class mainConsole {

	private static <TypeElement> void afficher(List<TypeElement> p_List)
	{
		for (TypeElement list : p_List) {
			System.out.print(list + " ");
		}
		System.out.println();
	}
	
	private static <TypeElement> void inverser(List<TypeElement> p_List)
	{
		Collections.reverse(p_List);
	}
	
	public static void main(String[] args) {
		
		List<Integer> integer = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			integer.add(i + 1);
		}
		
		afficher(integer);
		inverser(integer);
		afficher(integer);
		
		List<Double> doubleListe = new ArrayList<Double>();
		
		for (int i = 0; i < 10; i++) {
			doubleListe.add(1 + i * 1.5);
		}
		
		afficher(doubleListe);
		inverser(doubleListe);
		afficher(doubleListe);
		
	}

}
