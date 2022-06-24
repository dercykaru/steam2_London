package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        //Количество жителей в городе Лондон:
        int numPeopleLondon = 1_00;

        Collection<Person> persons = new ArrayList<>(numPeopleLondon);
        for (int i = 0; i < numPeopleLondon; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }
        System.out.println("Список всех жителей: .................");
        //Список всех жителей (список может быть большим!):
        for (Person p :
                persons) {
            System.out.println(p);
        }
        System.out.println();


        //Определение количества маленьких:
        long countSmall = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("В Лондоне сейчас малышни: " + countSmall);
        System.out.println();

        //Определение фамилий призывников:
        List<String> man2ArmyNow = persons.stream()
                .filter(x -> x.getAge() <= 27)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getSex() == Sex.MAN)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        System.out.println("Город Лондон набрал этих призывников: " + man2ArmyNow);
        System.out.println();

        //Определение фамилий трудоспособных:
        List<String> workers = persons.stream()
                //Фильтр на образование:
                .filter(x -> x.getEducation() == Education.HIGHER)
                //Фильтр на нижний предел возраста:
                .filter(x -> x.getAge() >= 18)
                //Фильтр на женщин <60, мужчин <65:
                .filter(x -> ((x.getSex() == Sex.WOMAN) && (x.getAge()) < 60) || ((x.getSex() == Sex.MAN) && (x.getAge() < 65)))
                .map(x -> x.getFamily())
                //Сортировка:
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        //Вывод на экран ВСЕХ трудоспособных. Список может быть большим!
        //System.out.println("Трудоспособны: " + workers);

        //Вывод на экран первых 15 элеметов большого списка:
        //Проверка, что элементов >15:
        System.out.println("Трудоспособны (первые 15 в списке): ");
        int maxWorkers;
        if (workers.size() < 15) {
            maxWorkers = workers.size();
        } else maxWorkers = 15;

        for (int i = 0; i < maxWorkers; i++) {
            System.out.println(workers.get(i));
        }

    }
}
