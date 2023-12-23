package Med_chek.Models;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private static Long generateId = 1L;
    private long id;
    private String departmentName;
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {
        this.id = generateId++;
    }


    public Department( String departmentName) {
        this.id = generateId++;
        this.departmentName = departmentName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
