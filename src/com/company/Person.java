package com.company;
//Задача на дэдлок
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Person {
    private final String name;
    Lock lock = new ReentrantLock();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Lock getLock() {
        return lock;
    }

    public void greeting(Person person) {
        System.out.format("%s приветсвует %s\n", this.name, person.getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        person.greetingBack(this);
    }

    public void greetingBack(Person person) {
        System.out.format("%s приветсвует %s\n", this.name, person.getName());
    }

    public void safeGreeting(Person person) {
        for(;;) {
            if (getLock().tryLock()) {
                if (person.getLock().tryLock()) {
                    greeting(person);
                    getLock().unlock();
                    person.getLock().unlock();
                    break;
                }
            } else {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Person drug = new Person("Друг");
        Person podruga = new Person("Подруга");

        new Thread(() -> podruga.safeGreeting(drug)).start();
        new Thread(() -> drug.safeGreeting(podruga)).start();
    }
}

