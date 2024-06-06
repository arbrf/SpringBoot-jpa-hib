package com.springRecap.SpringRecap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.springRecap.SpringRecap.game.GameRunner;
import com.springRecap.SpringRecap.game.GamingConsole;

@Configuration
@SpringBootApplication
public class SpringRecapApplication {

	public static void main(String[] args) {
		
		try (//MarioGame marioGame=new MarioGame();
				//SuperContraGame superContraGame=new SuperContraGame();
				//GameRunner runner=new GameRunner(superContraGame);
				//runner.run();
		//		ConfigurableApplicationContext runner = SpringApplication.run(SpringRecapApplication.class, args);
		//		GameRunner gameRunnerBean = runner.getBean(GameRunner.class);
		//		gameRunnerBean.run();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringRecapApplication.class)) {
		context.getBean(GamingConsole.class).down();
		context.getBean(GameRunner.class).run();
		for(String obj:context.getBeanDefinitionNames()) {
			//System.out.println(obj);
			
		}
		
		}
		
	
	}

}
