package com.rossacheson.springboot.aopdemo;

import com.rossacheson.springboot.aopdemo.dao.AccountDAO;
import com.rossacheson.springboot.aopdemo.dao.MembershipDAO;
import com.rossacheson.springboot.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AccountDAO accountDAO,
			MembershipDAO membershipDAO,
			TrafficFortuneService trafficFortuneService
	) {
		return runner -> {
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO);
			// demoTheAfterThrowingAdvice(accountDAO);
			// demoTheAfterAdvice(accountDAO);
			// demoTheAroundAdvice(trafficFortuneService);
			demoTheAroundAdviceHandleException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");
		boolean tripWire = true;
		String fortune = trafficFortuneService.getFortune(true);
		System.out.println("My fortune is: " + fortune);
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String fortune = trafficFortuneService.getFortune(true);
		System.out.println("My fortune is: " + fortune);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try{
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\n Main Program caught exception: " + e);
		}
		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try{
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\n Main Program caught exception: " + e);
		}
		System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// call the AccountDAO getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addMember();
		membershipDAO.goToSleep();
	}

}
