package com.springRecap.SpringRecap.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacMan implements GamingConsole{
	public void up() {
		System.out.println("PacMan go up");
	}
	
	public void down() {
		System.out.println("PacMan go down");
	}
	public void left() {
		System.out.println("PacMan go left");
	}
	public void right() {
		System.out.println("PacMan go right");
	}
	
}
