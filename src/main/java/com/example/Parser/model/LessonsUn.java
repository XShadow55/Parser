package com.example.Parser.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class LessonsUn {
    @Id

    Long id;
    @Column(unique=true)
    String startData;
    @Column(unique=true)
    String endData;
    String kurs_1;
    String kurs_2;
    String kurs_3;
    String kurs_4;

    public LessonsUn() {
    }

    public LessonsUn(Long id, String startData, String endData, String kurs_1, String kurs_2, String kurs_3, String kurs_4) {
        this.id = id;
        this.startData = startData;
        this.endData = endData;
        this.kurs_1 = kurs_1;
        this.kurs_2 = kurs_2;
        this.kurs_3 = kurs_3;
        this.kurs_4 = kurs_4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartData() {
        return startData;
    }

    public void setStartData(String startData) {
        this.startData = startData;
    }

    public String getEndData() {
        return endData;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }

    public String getKurs_1() {
        return kurs_1;
    }

    public void setKurs_1(String kurs_1) {
        this.kurs_1 = kurs_1;
    }

    public String getKurs_2() {
        return kurs_2;
    }

    public void setKurs_2(String kurs_2) {
        this.kurs_2 = kurs_2;
    }

    public String getKurs_3() {
        return kurs_3;
    }

    public void setKurs_3(String kurs_3) {
        this.kurs_3 = kurs_3;
    }

    public String getKurs_4() {
        return kurs_4;
    }

    public void setKurs_4(String kurs_4) {
        this.kurs_4 = kurs_4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonsUn lessonsUn = (LessonsUn) o;
        return Objects.equals(startData, lessonsUn.startData) && Objects.equals(endData, lessonsUn.endData) && Objects.equals(kurs_1, lessonsUn.kurs_1) && Objects.equals(kurs_2, lessonsUn.kurs_2) && Objects.equals(kurs_3, lessonsUn.kurs_3) && Objects.equals(kurs_4, lessonsUn.kurs_4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startData, endData, kurs_1, kurs_2, kurs_3, kurs_4);
    }

    @Override
    public String toString() {
        return
                startData + " - " + endData + '\'' +
                ", 1='" + kurs_1 + '\'' +
                ", 2='" + kurs_2 + '\'' +
                ", 3='" + kurs_3 + '\'' +
                ", 4='" + kurs_4 + '\'' ;
    }
}
