package OOP_assignment2.models;

import java.util.Objects;

public class Patient extends Person {
    private int age;
    private String patientId;

    public Patient(String name, int age, String patientId) {
        super(name);
        this.age = age;
        this.patientId = patientId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), patientId);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Patient patient = (Patient) obj;
        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public String toString() {
        return "Patient[" + super.toString() + ", age=" + age + ", patientId=" + patientId + "]";
    }
}
