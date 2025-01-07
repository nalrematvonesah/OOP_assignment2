package OOP_assignment2.models;

import java.util.Objects;

public class Hospital {
    private String name;
    private String address;
    private int capacity;

    public Hospital(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, capacity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Hospital hospital = (Hospital) obj;
        return capacity == hospital.capacity &&
                Objects.equals(name, hospital.name) &&
                Objects.equals(address, hospital.address);
    }

    @Override
    public String toString() {
        return "Hospital[name=" + name + ", address=" + address + ", capacity=" + capacity + "]";
    }
}
