package one_to_one_bi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapPersonAndPancard {
	public static void main(String[] args) {
		EntityManager em= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc =new Scanner(System.in);
		Person p = new Person();
		System.out.println("Enter Name");
		p.setName(sc.next());
		System.out.println("Enter Phone");
		p.setPhone(sc.nextLong());
		Pancard pc=new Pancard();
		System.out.println("Enter Pan number");
		pc.setPno(sc.next());
		System.out.println("Enter pin code");
		pc.setPin(sc.nextInt());
		p.setPc(pc);
		pc.setPerson(p);
		et.begin();
		em.persist(p);
		em.persist(pc);
		et.commit();
		System.out.println("Done");
	}
}
