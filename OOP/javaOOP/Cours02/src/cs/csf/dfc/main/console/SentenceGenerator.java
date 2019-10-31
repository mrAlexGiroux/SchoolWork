package cs.csf.dfc.main.console;

import java.util.Random;

public class SentenceGenerator {

	private String m_Sentence;
	Random rand = new Random();
	
	public SentenceGenerator()
	{
		this.m_Sentence = "";
	}
	
	public String GeneratorArticles()
	{
		String[] articles = new String[] {"le ", "la ","les ","un "};
		return articles[rand.nextInt(3)] ;
	}

	public String GeneratorNames()
	{
		String[] names = new String[] {"chat ", "chien ","tasse ","voiture "};
		return names[rand.nextInt(3)] ;
	}

	public String GeneratorVerb()
	{
		String[] verbs = new String[] {"allait ", "courrait ","volait ","nageait "};
		return verbs[rand.nextInt(3)] ;
	}

	public String GeneratorPreposition()
	{
		String[] preposition = new String[] {"vers ", "dans ","sur ","avec "};
		return preposition[rand.nextInt(3)] ;
	}

	public String GenerateSentence()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.GeneratorArticles());
		sb.append(this.GeneratorNames());
		sb.append(this.GeneratorVerb());
		sb.append(this.GeneratorArticles());
		sb.append(this.GeneratorNames());
		return sb.toString();
	}
}
