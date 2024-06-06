package com.springRecap.SpringRecap.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	private GamingConsole gamingConsole;
	public GameRunner(@Qualifier("marioGame") GamingConsole gamingConsole) {
		// TODO Auto-generated constructor stub
		this.gamingConsole=gamingConsole;
	}

	public void run() {
		gamingConsole.down();
		gamingConsole.up();
		gamingConsole.left();
		gamingConsole.right();
		// TODO Auto-generated method stub
		
	}

}
