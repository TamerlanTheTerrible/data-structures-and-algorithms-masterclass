package exercises.stack;

import java.util.ArrayDeque;

/**
 * Created by Temurbek Ismoilov on 21/01/23.
 */

public class AnimalQueue {
    private ArrayDeque<Dog> dogs;
    private ArrayDeque<Cat> cats;
    private int order;

    public AnimalQueue() {
        this.dogs = new ArrayDeque<>();
        this.cats = new ArrayDeque<>();
        this.order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Cat) {
            cats.add((Cat) animal);
        } else {
            dogs.add((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (cats.isEmpty() && dogs.isEmpty()) {
            System.out.println("no animals");
            return null;
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else if (dogs.isEmpty()) {
            return cats.poll();
        } else {
            Cat cat = cats.peek();
            Dog dog = dogs.peek();
            if (cat.isOlderThan(dog)) {
                return cats.poll();
            } else {
                return dogs.poll();
            }
        }
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public abstract class Animal {
        private int order;
        protected String name;
        public Animal(String n) {
            name = n;
        }

        public abstract String name();

        public void setOrder(int ord) {
            order = ord;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    public class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }

        public String name() {
            return "Cat: " + name;
        }
    }

    public class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }

        public String name() {
            return "Dog: " + name;
        }
    }
}
