package ru.geekbrains.home_work_4;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/* 0) Игрок выбирает размер поля: 3х3 или 5х5
 * 1) Инициализация полей
 * 2) Вывод поля в консоль
 * 3) Ход игрока
 * 4) Ход человека
 * 5) Проверка заполненности поля
 * 6) Проверка победы
 * 7) Запрос на повтор игры*/

public class Main {

    private static final char X_POINT = 'X';
    private static final char O_POINT = '0';
    private static final char FREE_PLACE = '.';
    private static final int fieldFormat1 = 3;
    private static final int fieldFormat2 = 5;
    private static char[][] field;
    private static Scanner scan = new Scanner(System.in);
    private static ThreadLocalRandom ran = ThreadLocalRandom.current();

    public static void main(String[] args) {
        format1();
        fillField();
        while (true) {
            manMove();
            fillField();
            if (winCondition(X_POINT)) {
                System.out.println("Вы победили!");
                break;
            }
            if (fieldFulness()) {
                System.out.println("Победила дружба!");
                break;
            }
            aiMove();
            fillField();
            if (winCondition((O_POINT))) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (fieldFulness()) {
                System.out.println("Победила дружба!");
                break;
            }


        }
        System.out.println("Игра окончена!");

    }

    private static void format1() {
        field = new char[fieldFormat1][fieldFormat1];
        for (int i = 0; i < fieldFormat1; i++) {
            for (int j = 0; j < fieldFormat1; j++) {
                field[i][j] = FREE_PLACE;
            }
        }
    }

    private static void format2() {
        field = new char[fieldFormat2][fieldFormat2];
        for (int i = 0; i < fieldFormat2; i++) {
            for (int j = 0; j < fieldFormat2; j++) {
                field[i][j] = FREE_PLACE;
            }
        }
    }


    private static void fillField() {
        System.out.println();
        for (int i = 0; i < fieldFormat1; i++) {
            for (int j = 0; j < fieldFormat1; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();

        }
    }

    private static void fillField2 () {
        System.out.println();
        for (int i = 0; i < fieldFormat2; i++) {
            for (int j = 0; j < fieldFormat2; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();

        }
    }


    private static void manMove() {
        int human_x = -1;
        int human_y = -1;
        do {
            try {
                System.out.println("Введите через пробел координат X и Y от 1 до 3, где X - номер строки, а Y - номер столбца");
                human_x = scan.nextInt() - 1;
                human_y = scan.nextInt() - 1;
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Вводите только числа! ");
                scan = new Scanner(System.in);
            }
        } while (!checkMove(human_x, human_y));
        field[human_x][human_y] = X_POINT;

    }

    private static void aiMove() {
        int ai_x = -1;
        int ai_y = -1;
        System.out.println("Ход компьютера");
        do {
            ai_x = ThreadLocalRandom.current().nextInt(0, 3);
            ai_y = ThreadLocalRandom.current().nextInt(0, 3);
        } while (!checkMove(ai_x, ai_y));
        field[ai_x][ai_y] = O_POINT;
        System.out.println(ai_x);
        System.out.println(ai_y);
    }

    private static boolean checkMove(int x, int y) {
        return x >= 0 && x < fieldFormat1
                && y >= 0 && y < fieldFormat1
                && field[x][y] == FREE_PLACE;
    }

    private static boolean fieldFulness() {
        for (int i = 0; i < fieldFormat1; i++) {
            for (int j = 0; j < fieldFormat1; j++) {
                if (field[i][j] == FREE_PLACE) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean winCondition(char winOrNot) {
        int lines = 0;
        int columns = 0;
        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < fieldFormat1; i++) {
            if (field[i][i] == winOrNot) {
                diag1++;

                if (diag1 == 3)
                    return true;
            }
            if (field[i][fieldFormat1 - i - 1] == winOrNot) {
                diag2++;

                if (diag2 == 3)
                    return true;
            }
            for (int j = 0; j < fieldFormat1; j++) {
                if (field[i][j] == winOrNot) {
                    lines++;

                    if (lines == 3)
                        return true;
                }

                if (field[j][i] == winOrNot) {
                    columns++;

                    if (columns == 3)
                        return true;
                }

            }
            lines = 0;
            columns = 0;
            diag1 = 0;
            diag2 = 0;
        }
        return false;

    }


}
