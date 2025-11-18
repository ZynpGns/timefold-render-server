package com.example.timefold.domain;

import java.util.HashSet;
import java.util.Set;

public class Employee {

    private Long id;
    private String name;
    /** Çalışanın sahip olduğu skill listesi (örn: "NURSE", "DOCTOR") */
    private Set<String> skills = new HashSet<>();

    public Employee() {
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // ---- getters / setters ----

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

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}
