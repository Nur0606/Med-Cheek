package Med_chek.Models;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static long generateId = 1L;
    private long id;
    private  String hospitalName;
    private String address;
    private List<Department> departments = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private  List<Patient> patients = new ArrayList<>();

    public Hospital(String hospitalName, String address) {
        this.id = generateId++;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                " hospitalName='" + hospitalName + '\'' +
                " address='" + address + '\'' +
                " departments=" + departments +
                " doctors=" + doctors +
                " patients=" + patients +
                '}';
    }
}
