package fr.partnaire.recrutement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TestTechniqueApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestTechniqueApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestTechniqueApplication.class, args);
	}

	@EventListener(value = ApplicationReadyEvent.class)
	public void runForFun() {
		LOGGER.info("Histoire de lancer quelquechose !?");
	}
}
