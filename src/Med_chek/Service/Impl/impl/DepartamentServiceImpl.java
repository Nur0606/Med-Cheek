package Med_chek.Service.Impl.impl;

import Med_chek.Models.Department;
import Med_chek.Models.Hospital;
import Med_chek.Service.Impl.DepartamentService;
import Med_chek.Service.Impl.GenericService;
import Med_chek.dao.DepartamentDaoImpl;
import Med_chek.dao.HospitalDaoImpl;
import Med_chek.db.DataBace;

import java.util.List;

public class DepartamentServiceImpl implements GenericService<Department>, DepartamentService{
    DataBace dataBace;
    private final DepartamentDaoImpl departmentDao;
    private final HospitalDaoImpl hospitalDao;

    public DepartamentServiceImpl(DepartamentDaoImpl departmentDao, HospitalDaoImpl hospitalDao) {
        this.departmentDao = departmentDao;
        this.hospitalDao = hospitalDao;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getId() == id){
                return hospital.getDepartments();
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : hospitalDao.getAll()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    return department;
                }
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public String add(Long hospitalId, List<Department> departmentList) {
        departmentDao.add(hospitalId,departmentList);
        return "asadd" ;
    }

    @Override
    public void removeById(Long id) {
        departmentDao.delete(id);
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public String updateById(Long id, Department department) {
        departmentDao.updateById(id,department);

        return " almashcan jok";
    }
}
