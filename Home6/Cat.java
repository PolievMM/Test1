package ru.geekbrains.homework_6;

import java.io.IOException;

public class Cat extends Animal {



    public Cat (String name) {
        super(name);

    }

    @Override
    public void swim(int distance) {

        if (distance <= 0 | distance >= 0)

        System.out.println("Кошки не могут плавать.");

    }

    @Override
    public void run(int distance) {

        if (distance > 200)
            System.out.println("Кошки не могут пробежать больше 200 метров.");
        else if (distance < 0)
            System.out.println("Животные не могут пробежать отрицательную дистанцию.");
        else
            System.out.println("Кошка " + getName() + " пробежала " + distance + " метров.");
    }




}


////2.	Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
////3.	У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
////4.	* Добавить подсчет созданных котов, собак и животных.