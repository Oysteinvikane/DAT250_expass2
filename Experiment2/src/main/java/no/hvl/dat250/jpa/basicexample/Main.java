package no.hvl.dat250.jpa.basicexample;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "bank";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
        for (Person person : personList) {
            System.out.println(personList);
        }
        System.out.println("Size: " + personList.size());

        
        Person person = new Person();
        person.setName("Max Mustermann");
        
        
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        
        CreditCard creditCard1 = new CreditCard();
        creditCard1.setNumber(12345);
        creditCard1.setBalance(-5000);
        creditCard1.setLimit(-10000);
        
        Pincode pincode1 = new Pincode();
        pincode1.setPincode(123);
        pincode1.setCount(1);
        
        creditCard1.setPincode(pincode1);
        
        CreditCard creditCard2 = new CreditCard();
        creditCard2.setNumber(123);
        creditCard2.setBalance(1);
        creditCard2.setLimit(2000);
        
        Pincode pincode2 = new Pincode();
        pincode2.setPincode(321);
        pincode2.setCount(2);
        
        creditCard1.setPincode(pincode2);
        
        Set<CreditCard> creditCards = new HashSet<>();
        creditCards.add(creditCard1);
        creditCards.add(creditCard2);
        person.setCreditCards(creditCards);
        
               
        Bank bank = new Bank();
        bank.setName("Pengebank");

        em.getTransaction().begin();

        em.persist(person);
        em.persist(address);
        em.persist(creditCard1);
        em.persist(creditCard2);
        
        em.persist(bank);

        em.getTransaction().commit();
        em.close();

    }
}