package com.jsp.person.account;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonAcc {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nish");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction(); 
		
		Person person = new Person();
		person.setName("Shubham");
		person.setEmail("shub@mail.com");
		person.setCno(12345678);
		person.setGender("Male");
		
		Account account1 = new Account();
		account1.setAcc_no(54313357);
		account1.setBank_name("HDFC");
		account1.setIfsc_code("HDFC0000575");
		
		Account account2 = new Account();
		account2.setAcc_no(24733357);
		account2.setBank_name("AXIS");
		account2.setIfsc_code("AXIX000075");
		
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		
		//Set person with multiple bank accounts
		person.setAccounts(accounts);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityTransaction.commit();
		
	}
}
