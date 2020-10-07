package com.endava.internship;

import java.time.LocalDate;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final LocalDate dateOfBirth;
    private String name;
    private String details;

    public Student(String name, LocalDate dateOfBirth, String details) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                dateOfBirth.equals(student.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth);
    }

    @Override
    public int compareTo(Student otherStudent) {
        //compare name
        int nameDiff = name.compareTo(otherStudent.name);
        if (nameDiff != 0) {
            return nameDiff;
        }
        //names are equals compare age
        return dateOfBirth.compareTo(otherStudent.dateOfBirth);
    }


}