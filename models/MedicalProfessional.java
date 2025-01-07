package OOP_assignment2.models;

import java.util.Objects;

public class MedicalProfessional extends Person {
    private String specialty;
    private int yearsOfExperience;

    public MedicalProfessional(String name, String specialty, int yearsOfExperience) {
        super(name);
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialty, yearsOfExperience);
    }

    @Override
    public String toString() {
        return "MedicalProfessional[" + super.toString() + ", specialty=" + specialty + ", yearsOfExperience=" + yearsOfExperience + "]";
    }
}
