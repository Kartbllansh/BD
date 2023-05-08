package Auxiliary;

import Base.*;


import java.util.Random;

/**
 * Класс, позволяющий генерировать рандомного дракона
 */
public class RandomDragon {

    /**
     * Объект класса Random
     */
    static Random random = new Random();

    /**
     * Метод генерирующий рандомную строчку
     *
     * @return the string
     */
    public static String generateRandomWord() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder word = new StringBuilder();
        int length = random.nextInt(10) + 1; // генерируем длину от 1 до 10 символов
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char letter = alphabet.charAt(index);
            word.append(letter);
        }
        return word.toString();
    }

    /**
     * Генерация рандомного цвета
     *
     * @return the random color
     */
    public static Color getRandomColor() {
        Color[] values = Color.values();
        int index = random.nextInt(values.length);
        return values[index];
    }

    /**
     * Генерация рандомного типа
     *
     * @return the random type
     */
    public static DragonType getRandomType() {
        DragonType[] values = DragonType.values();
        int index = random.nextInt(values.length);
        return values[index];
    }

    /**
     * Генерация рандомного числа
     *
     * @return the int
     */
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(91) + 10;
    }

    /**
     * Генерация рандомного дракона
     *
     * @return the dragon
     */
    public static Dragon doRandomDragon(){
        Dragon dragon = new Dragon();
        dragon.setCoordinates(new Coordinates());
        dragon.getCoordinates().setY((float)generateRandomNumber());
        dragon.getCoordinates().setX((float) generateRandomNumber());
        dragon.setName(generateRandomWord());
        dragon.setType(getRandomType());
        dragon.setColor(getRandomColor());
        dragon.setAge(generateRandomNumber());
        dragon.setWeight((long) generateRandomNumber());
        dragon.setHead(new DragonHead());
        dragon.getHead().setToothCount((long) generateRandomNumber());
        dragon.getHead().setEyesCount(generateRandomNumber());
        dragon.getHead().setSize((double) generateRandomNumber());
        System.out.println("Неизвестный дракон создан");
        return dragon;
    }
}
