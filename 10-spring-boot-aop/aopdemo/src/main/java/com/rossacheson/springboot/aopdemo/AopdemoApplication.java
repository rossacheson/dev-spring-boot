package com.rossacheson.springboot.aopdemo;

import com.rossacheson.springboot.aopdemo.dao.AccountDAO;
import com.rossacheson.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
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
