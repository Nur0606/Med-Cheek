package Med_chek.Models;

public class Doctor {
    private static long generateId = 1L;
    private long id;
    private String firsName;
    private String LastName;
    private Genders gender;
    private  int experienceYear;

    public Doctor() {
        this.id = generateId++;
    }

    public Doctor(String firsName, String LastName, Genders gender, int experienceYear) {
        this.id = generateId++;
        this.firsName = firsName;
        this.LastName = LastName;
        this.gender = gender;
        this.experienceYear = experienceYear;
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
        return LastName;
    }

    public void setLastName(String getLastName) {
        this.LastName = getLastName;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", getLastName='" + LastName + '\'' +
                ", gender=" + gender +
                ", experienceYear=" + experienceYear +
                '}';
    }
}
