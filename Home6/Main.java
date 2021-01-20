package ru.geekbrains.homework_6;

public class Main {

    public static void main(String[] args) {

       Cat cat = new Cat("Юша");
       Dog dog = new Dog("Adda");
       Dog dog2 = new Dog("Bessy");
       Cat cat2 = new Cat("Муша");

       cat.run(100);
       cat.swim(5);
       dog.run(300);
       dog.swim(15);
       System.out.println();
       dog2.animalCounter();


    }
}
