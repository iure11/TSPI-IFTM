package com.iftm.startexample.models;

import java.util.Objects;

public class Sector {
    private String name;
    private int floor;

    // getters, setters e construtores

    public Sector() {
    }

    public Sector(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public int getFloor() {
        return floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "name='" + name + '\'' +
                ", floor=" + floor +
                '}';
    }

// equals e hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sector)) return false;
        Sector sector = (Sector) o;
        return getFloor() == sector.getFloor() && getName().equals(sector.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFloor());
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }


}