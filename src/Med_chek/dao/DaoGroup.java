package Med_chek.dao;

import java.util.List;

public interface DaoGroup <T,ID>{
    boolean add(ID hospitalId, List<T> t);
    boolean delete(Long id);
    String updateById(Long id, T t);
    List<T> getAll();
}
