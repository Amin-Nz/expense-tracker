package com.example.expensetracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExpenseTrackerApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(ExpenseTrackerApiApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Expense Tracker API application...");
		ApplicationContext context = SpringApplication.run(ExpenseTrackerApiApplication.class, args);
		logger.info("Expense Tracker API application started successfully");

		// Log some application details
		String[] beanNames = context.getBeanDefinitionNames();
		logger.debug("Loaded {} beans", beanNames.length);

		String appName = context.getApplicationName();
		logger.info("Application Name: {}", appName);

		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		logger.info("Active Profiles: {}", String.join(", ", activeProfiles));

		logger.info("Expense Tracker API is ready to use");
	}
}