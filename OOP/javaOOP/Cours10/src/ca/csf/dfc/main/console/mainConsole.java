package ca.csf.dfc.main.console;

import ca.csf.dfc.classes.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class mainConsole {

	public static Integer identite(Integer p_Value)
	{
		return p_Value;
	}
	
	public static Double carre(Double p_Value)
	{
		return p_Value * p_Value;
	}
	
	public static Integer multiplication(Integer p_ValueOne, Integer p_ValueTwo)
	{
		return p_ValueOne * p_ValueTwo;
	}
	
	private static void obtenirElement01_v01()
	{
		List<Product> produits = DonneesTestStream.createProductList();
		
		List<Product> resultat = produits.stream()
				.filter(p -> p.getProductID() == 12)
				.collect(Collectors.toList());
		
		resultat.forEach(System.out::println);
	}
	
	private static void obtenirSousListeCategorieCondiments_V01()
	{
		List<Product> produits = DonneesTestStream.createProductList();
		
		List<Product> resultat = produits.stream()
				.filter(p -> p.m_Category == "Condiments")
				.collect(Collectors.toList());
		
		resultat.forEach(System.out::println);
	}
	
	private static void obtenirSousListePrixSupp100_V01()
	{
		List<Product> produits = DonneesTestStream.createProductList();
		
		List<Product> resultat = produits.stream()
				.filter(p -> p.m_UnitPrice > 100)
				.collect(Collectors.toList());
		
		resultat.forEach(System.out::println);
	}
	
	private static void obtenirElement01_v02()
	{
		List<Product> produits = DonneesTestStream.createProductList();
		
		Optional<Product> resultat = produits.stream()
				.filter(p -> p.getProductID() == 12)
				.collect(Collectors.reducing((a , b) -> null));
		
		if (resultat.isPresent()) {
			System.out.println(resultat.get());
		} else {
			System.out.println("Non present ou en double");
		}
	}
	
	//private static void obtenirListeNomProduitsOrdonnes_
	
	
	public static void main(String[] args) {
		
//		Function<Integer, Integer> id1 = mainConsole::identite;
//		System.out.println(id1.apply(123));
//		
//		Function<Integer, Integer> id2 = (Integer v) -> v;
//		System.out.println(id2.apply(123));
//		
//		Function<Double, Double> fctCarre_V01 = mainConsole::carre;
//		System.out.println(fctCarre_V01.apply(2.5));
//		
//		BiFunction<Integer, Integer, Integer> fct = ( a, b)-> a + b;
//		System.out.println(fct.apply(123, 456));
//		
//		BiFunction<Integer, Integer, Integer> fctMultiplication_V01 = mainConsole::multiplication;
//		System.out.println(fctMultiplication_V01.apply(5, 10));
//		
//		Function<Integer, Integer> id3 = v -> v;
//		System.out.println(id3.apply(123));
//		
//		BiFunction<Integer, Integer, Integer> fct2 = (a, b) -> a+ b;
//		System.out.println(fct2.apply(123, 456));
//		
//		BiFunction<Integer, Integer, Integer> fctMultiplication_V02 = mainConsole::multiplication;
//		System.out.println(fctMultiplication_V02.apply(5, 10));
//		
//		System.out.println(fctCarre_V01.apply(2.5));
//		
//		obtenirElement01_v01();
//		
//		obtenirSousListeCategorieCondiments_V01();
//		
//		obtenirSousListePrixSupp100_V01();
		
		obtenirElement01_v02();
		
		
		
		
		
	}

}
