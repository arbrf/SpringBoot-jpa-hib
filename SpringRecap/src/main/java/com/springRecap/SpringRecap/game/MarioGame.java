package com.springRecap.SpringRecap.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class MarioGame implements GamingConsole{
	public void up() {
		System.out.println("Jump up");
	}
	
	public void down() {
		System.out.println("Go into Hole");
	}
	public void left() {
		System.out.println("Stop");
	}
	public void right() {
		System.out.println("Accelerate");
	}
	
}
