package com.springRecap.SpringRecap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springRecap.SpringRecap.game.GameRunner;
import com.springRecap.SpringRecap.game.MarioGame;
import com.springRecap.SpringRecap.game.SuperContraGame;

@SpringBootApplication
public class SpringRecapApplication {

	public static void main(String[] args) {
		
		//MarioGame marioGame=new MarioGame();
		//SuperContraGame superContraGame=new SuperContraGame();
		//GameRunner runner=new GameRunner(superContraGame);
		//runner.run();
		ConfigurableApplicationContext runner = SpringApplication.run(SpringRecapApplication.class, args);
		GameRunner gameRunnerBean = runner.getBean(GameRunner.class);
		gameRunnerBean.run();
		
	
	}

}
