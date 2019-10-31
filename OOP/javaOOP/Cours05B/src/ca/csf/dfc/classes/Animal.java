package ca.csf.dfc.classes;

import java.util.Random;

public abstract class Animal {

	Random rand = new Random();

	public abstract int GetTagNumber();
	
	public abstract String Breathe();
	
	public abstract String Move();
}
