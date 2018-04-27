package com.superxc.twhomeworkSpringbootbasic.domain;

public class Employee {

    private Long id;

    private String name;

    private Integer age;

    private String gender;

    private static Long firstAvailableId = 0L;

    public Employee() {
    }

    /**
     * Generate id for employee
     */
    public void generateId() {
        id = firstAvailableId++;
    }

    public Employee(String name, Integer age, String gender) {
        generateId();
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
