package ca.mss.springboot.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * Provide an indication of application health. Uses {@link HealthIndicator}
 * 
 * @author sprabhu
 *
 */
public class AppStatusHealthIndicator implements ApplicationListener<ApplicationReadyEvent>, HealthIndicator {

	boolean started = false;

	/**
	 * Event that determines whether application started successfully or not.
	 */
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		started = true;
	}

	/**
	 * Event handler to determine health of the application.
	 */
	@Override
	public Health health() {
		Health.Builder healthBuilder;
		if (started) {
			healthBuilder = Health.up();
		} else {
			healthBuilder = Health.down();
		}

		return healthBuilder.build();
	}
}