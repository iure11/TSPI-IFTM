package com.iftm.startexample.models.dtos;

import com.iftm.startexample.models.Address;
import com.iftm.startexample.models.Sector;

import java.util.Objects;

public class DeveloperDTO {
    private String id;
    private String name;
    private String lastName;
    private String level;
    private String specialization;
    private Sector sector;
    private Address address;


    public DeveloperDTO() {
    }

    public DeveloperDTO(String id, String name, String lastName, String level, String specialization,
                        Sector sector, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.level = level;
        this.specialization = specialization;
        this.sector = sector;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DeveloperDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", specialization='" + specialization + '\'' +
                ", sector=" + sector +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeveloperDTO)) return false;
        DeveloperDTO that = (DeveloperDTO) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getLastName().equals(that.getLastName()) && getLevel().equals(that.getLevel()) && getSpecialization().equals(that.getSpecialization()) && getSector().equals(that.getSector()) && getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getLevel(), getSpecialization(), getSector(), getAddress());
    }
}
