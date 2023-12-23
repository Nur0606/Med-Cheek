package Med_chek.Service.Impl.impl;

import Med_chek.Models.Hospital;
import Med_chek.Models.Patient;
import Med_chek.Service.Impl.GenericService;
import Med_chek.Service.Impl.PatientService;
import Med_chek.dao.HospitalDaoImpl;
import Med_chek.dao.PatientDaoImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PatientServiceImpl implements GenericService<Patient>, PatientService {
    private final PatientDaoImpl patientDao;
    private final HospitalDaoImpl hospitalDao;

    public PatientServiceImpl(PatientDaoImpl patientDao, HospitalDaoImpl hospitalDao) {
        this.patientDao = patientDao;
        this.hospitalDao = hospitalDao;
    }


    @Override
    public String add(Long hospitalId, List<Patient> patients) {
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getId() == hospitalId){
                hospital.setPatients(patients);
            }
        }
        throw new RuntimeException(" Incorrect pations!!");
    }

    @Override
    public void removeById(Long id) {
        patientDao.delete(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        patientDao.updateById(id,patient);

        return "almashty";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        patientDao.add(id,patients);
        return "saktaldy";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            for (Patient patient : hospital.getPatients()) {
                if (id.equals(
                        patient.getId())){
                    return patient;
                }
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        TreeMap<Integer, Patient> map = new TreeMap<>();

        for (Hospital hospital : hospitalDao.getAll()) {
            for (Patient patient : hospital.getPatients()) {
                Integer age = patient.getAge();
                if (!map.containsKey(age)) {
                    map.put(age, patient);
                }
            }
        }
        return map;
    }



    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {

        LinkedList<Patient> patients = new LinkedList<>(patientDao.getAll());
        if ("asc".equalsIgnoreCase(ascOrDesc)){
            patients.sort(Patient.sortByPatientName);
        }else {
            patients.sort(Patient.sortByPatientName.reversed());
        }
        return patients;
    }
}
