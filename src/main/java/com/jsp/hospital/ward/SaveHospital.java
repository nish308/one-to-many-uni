package com.jsp.hospital.ward;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveHospital {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nish");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital = new Hospital();
		hospital.setHospital_name("KEM Hospital");
		hospital.setLocation("Parel");
		
		Ward ward = new Ward();
		ward.setWard_name("Emergency");
		ward.setFloor("First Floor");
		
		Ward ward1 = new Ward();
		ward1.setWard_name("OPD");
		ward1.setFloor("Ground Floor");
		
		ArrayList<Ward>wards = new ArrayList<Ward>();
		wards.add(ward);
		wards.add(ward1);
		
		hospital.setWards(wards);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(ward);
		entityManager.persist(ward1);
		entityTransaction.commit();
	}
}
