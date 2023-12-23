package Med_chek.dao;

import Med_chek.Models.Hospital;
import Med_chek.db.DataBace;

import java.util.List;

public class HospitalDaoImpl implements DaoGroup<Hospital,Long>{
    private  final DataBace dataBace;


    public HospitalDaoImpl(DataBace dataBace) {
        this.dataBace = dataBace;
    }
    @Override
    public List<Hospital> getAll(){
        return dataBace.getHospitalList();
    }

    @Override
    public boolean add(Long hospitalId, List<Hospital> hospitals) {
        return dataBace.add(hospitals);

    }

    @Override
    public boolean delete(Long id) {
        for (Hospital hospital : dataBace.getHospitalList()) {
            if (hospital.getId() == id){
                return dataBace.getHospitalList().remove(hospital);
            }
        }
        return false;
    }

    @Override
    public String updateById(Long id, Hospital hospital) {
        return null;
    }
}
