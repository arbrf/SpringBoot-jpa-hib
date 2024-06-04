package com.springRecap.SpringRecap.game;

public class SuperContraGame implements GamingConsole {
	public void up() {
		System.out.println("Contra Jump up");
	}
	
	public void down() {
		System.out.println("Contra go into Hole");
	}
	public void left() {
		System.out.println("Contra Stop");
	}
	public void right() {
		System.out.println("Contra Accelerate");
	}


	
}
