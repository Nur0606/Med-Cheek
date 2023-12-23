package Med_chek.Service.Impl;

import Med_chek.Models.Department;

import java.util.List;

public interface DepartamentService {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
