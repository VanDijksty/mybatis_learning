package com.styyyds.mybatis.pojo;

import java.util.Date;

public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Character sex;
    private Double height;
    private Date birth;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", birth=" + birth +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Student(Long id, String name, Character sex, Integer age, Double height, Date birth) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.birth = birth;
    }

    public Student() {
    }
}
