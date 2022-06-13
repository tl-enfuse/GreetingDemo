package io.enfuse.Travis.demo.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
public class GreetingRepositoryTest {

    @Autowired
    private GreetingRepository subject;

    @Autowired
    private TestEntityManager entityManager;

    private Greeting returnedGreeting;

    private Greeting testGreeting = new Greeting(1L, "Test Content");

    @BeforeEach
    public void setup(){
        returnedGreeting = subject.save(testGreeting);
    }

    @Test
    public void givenGreeting_save_then_and_get(){
        assertEquals(returnedGreeting.getContent(), testGreeting.getContent());
        Greeting actualGreeting = entityManager.find(Greeting.class, testGreeting.getId());
        assertEquals(actualGreeting.getContent(), testGreeting.getContent());
    }

    @Test
    public void saveGreeting_thenGetGreeting(){
        subject.save(testGreeting);
        assertEquals(testGreeting.getContent(), subject.findById(1L).orElse(null).getContent());
    }

    @Test
    public void updateGreeting(){
        Greeting sameIdGreeting = new Greeting(1L, "Updated for better content.");
        subject.save(sameIdGreeting);
        Greeting greeting = entityManager.find(Greeting.class, returnedGreeting.getId());
        assertEquals(greeting.getContent(), sameIdGreeting.getContent());
    }

    @Test
    public void deleteGreeting(){
        assertEquals(subject.findAll().size(), 1);
        subject.delete(testGreeting);
        assertEquals(subject.findAll().size(), 0);
    }
}
