package Med_chek.Service.Impl.impl;

import Med_chek.Models.Department;
import Med_chek.Models.Doctor;
import Med_chek.Models.Hospital;
import Med_chek.Service.Impl.DoctorService;
import Med_chek.Service.Impl.GenericService;
import Med_chek.dao.DoctorDaoImpl;
import Med_chek.dao.HospitalDaoImpl;

import java.util.List;

public class DoctorServiceImpl implements GenericService<Doctor>, DoctorService {
    private final DoctorDaoImpl doctorDaoImp;
    private final HospitalDaoImpl hospitalDao;

    public DoctorServiceImpl(DoctorDaoImpl doctorDaoImp, HospitalDaoImpl hospitalDao) {
        this.doctorDaoImp = doctorDaoImp;
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String add(Long hospitalId, List<Doctor> doctors) {
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getId() == hospitalId){
                hospital.setDoctors(doctors);
            }
        }
        return "Saktalby! " ;
    }

    @Override
    public void removeById(Long id) {
        doctorDaoImp.delete(id);
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        Doctor doctor1 = findDoctorById(id);
        doctor1.setFirsName(doctor1.getFirsName());
        return " almashty";
    }


    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (id.equals(doctor.getId())){
                    return doctor;
                }
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : hospitalDao.getAll()) {
            for (Department department : hospital.getDepartments()) {
                if (departmentId.equals(department.getId())){
                    for (Doctor doctor : hospital.getDoctors()) {

                        if (doctorsId.contains(doctor.getId())){
                            department.getDoctors().add(doctor);
                            return "Successful!";
                        }
                        throw new RuntimeException("Doctor not found! ");
                    }
                    throw  new RuntimeException("Departments not found !");
                }
            }
        }

        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getId() == id){
                return hospital.getDoctors();
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return null;
    }
}
