package com.company;

public class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    //Конструктор.
    public Person(String name, String family, Integer age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    //Геттеры.
    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    //ФУНКЦИЯ ВЫВОДА НА ЭКРАН:
    @Override
    public String toString() {
        return "Житель {" +
                "имя= " + name +
                ", фамилия= " + family +
                ", возраст= " + age +
                ", пол= " + sex +
                ", образование= " + education +
                "}";
    }
}
