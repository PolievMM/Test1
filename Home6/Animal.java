package ru.geekbrains.homework_6;

public abstract class Animal {

    private String name;
    static int counter = 0;

    public Animal (String name) {
        this.name = name;
            counter++;
    }

    public void animalCounter () {
        System.out.println("Количество созданных котов и собак = " + counter);
    }


    public String getName () {
        return name;
    }


    public abstract void swim(int distance);

    public abstract void run(int distance);





}


//2.	Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3.	У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4.	* Добавить подсчет созданных котов, собак и животных.
