package Med_chek.dao;

import Med_chek.Models.Doctor;
import Med_chek.Models.Hospital;
import Med_chek.db.DataBace;

import java.util.List;

public class DoctorDaoImpl implements DaoGroup<Doctor,Long>{
    private final DataBace dataBace;
    public DoctorDaoImpl(DataBace dataBace) {
        this.dataBace = dataBace;
    }

    @Override
    public boolean add(Long hospitalId,List<Doctor> doctors) {
        for (Hospital hospital : dataBace.getHospitalList()) {
            if (hospital.getId() == hospitalId){
                hospital.setDoctors(doctors);
            }
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {
        for (Hospital hospital : dataBace.getHospitalList()) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId() == id) {
                    return hospital.getDoctors().remove(doctor);
                }
            }
        }
        return false;
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        String aa = "Samat";
        for (Hospital hospital : dataBace.getHospitalList()) {
            for (Doctor hospitalDoctor : hospital.getDoctors()) {
                if (hospitalDoctor.getId() == id){
                    hospitalDoctor.setFirsName(aa);
                }
            }
        }
        return "Almashty ";
    }
    @Override
    public List<Doctor> getAll() {
        for (Hospital hospital : dataBace.getHospitalList()) {
            return hospital.getDoctors();
        }
        throw new RuntimeException(" Incorrect type");
    }
}
