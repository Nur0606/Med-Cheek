package Med_chek.dao;

import Med_chek.Models.Hospital;
import Med_chek.Models.Patient;
import Med_chek.db.DataBace;

import java.util.List;

public class PatientDaoImpl implements DaoGroup<Patient,Long> {
    private final DataBace dataBace;

    public PatientDaoImpl(DataBace dataBace) {
        this.dataBace = dataBace;
    }

    @Override
    public boolean add(Long hospitalId, List<Patient> patients) {
        for (Hospital hospital : dataBace.getHospitalList()) {
            if (hospital.getId() == hospitalId){
                hospital.setPatients(patients);
            }
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        for (Hospital hospital : dataBace.getHospitalList()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    return hospital.getPatients().remove(patient);
                }
            }
        }
        return true;
    }

    @Override
    public String updateById(Long id, Patient patient) {
        String aa = "Kanat";
        for (Hospital hospital : dataBace.getHospitalList()) {
            for (Patient hospitalPatient : hospital.getPatients()) {
                if (hospitalPatient.getId() == id){
                    hospitalPatient.setFirsName(aa);
                }
            }
        }
        return "almashty" ;
    }
    @Override
    public List<Patient> getAll() {
        for (Hospital hospital : dataBace.getHospitalList()) {
            return hospital.getPatients();
        }
        throw new RuntimeException(" Incorrect type");
    }
}
