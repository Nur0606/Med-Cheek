package Med_chek.Models;

import java.util.Comparator;

public class Patient implements Comparable<Patient> {
    private static long generateId = 1L;
    private long id;
    private String firsName;
    private String lastName;
    private int age;
    private Genders genders;

    public Patient() {
        this.id = generateId++;
    }

    public Patient(String firsName, String lastName, int age, Genders genders) {
        this.id = generateId++;
        this.firsName = firsName;
        this.lastName = lastName;
        this.age = age;
        this.genders = genders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Genders getGenders() {
        return genders;
    }

    public void setGenders(Genders genders) {
        this.genders = genders;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", genders=" + genders +
                '}';
    }

    @Override
    public int compareTo(Patient o) {
        return this.firsName.compareTo(o.getFirsName());
    }

    public static Comparator<Patient> sortByPatientName = new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o1.firsName.compareTo(o2.getFirsName());
        }
    };
}
