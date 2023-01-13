package com.example.testspringa1.ankieta;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Ankieta {

    @Id
    @SequenceGenerator(
            name = "ankieta_id_squence",
            sequenceName = "ankieta_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ankieta_id_sequence"
    )
    private Integer id;

    String name;
    @ElementCollection
    List<String> answers = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Ankieta() {

    }

    @Override
    public String toString() {
        return "Ankieta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Answers=" + answers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ankieta ankieta = (Ankieta) o;
        return Objects.equals(id, ankieta.id) && Objects.equals(name, ankieta.name) && Objects.equals(answers, ankieta.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, answers);
    }
}
