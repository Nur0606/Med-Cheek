package Med_chek.Service.Impl.impl;

import Med_chek.Models.Hospital;
import Med_chek.Models.Patient;
import Med_chek.Service.Impl.HospitalService;
import Med_chek.dao.HospitalDaoImpl;
import Med_chek.db.DataBace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    DataBace dataBace = new DataBace();
    private final HospitalDaoImpl hospitalDao;

    public HospitalServiceImpl(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        hospitalDao.getAll().add(hospital);
        return  "Saktaldy ";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getId() == id) {
                return hospital;
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAll();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            for (Patient patient : hospital.getPatients()) {
                if (id == patient.getId()){
                    return   hospital.getPatients();
                }
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public String deleteHospitalById(Long id) {
        hospitalDao.delete(id);
        return  " ochty";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital> map = new HashMap<>();
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getAddress().equals(address)){
                map.put(address,hospital);
                System.out.println(map);
            }
        }
        return map;
    }
}
