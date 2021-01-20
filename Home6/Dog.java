package ru.geekbrains.homework_6;

public class Dog extends Animal {

    public Dog (String name) {
        super(name);

    }

    @Override
    public void swim(int distance) {

        if (distance > 10)
            System.out.println("Собаки не могут проплыть больше 10 метров.");
        else
            System.out.printf("Собака %s проплыла %d метров \n", getName(),distance);
    }

    @Override
    public void run(int distance) {
        if (distance > 500)
            System.out.println("Собака не может пробежать больше полукилометра.");
        else
            System.out.printf("Собака %s пробежала %d метров. \n", getName(),distance);

    }


}



////2.	Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
////3.	У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
////4.	* Добавить подсчет созданных котов, собак и животных.