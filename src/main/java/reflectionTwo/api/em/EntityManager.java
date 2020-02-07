package reflectionTwo.api.em;

import java.util.List;

public interface EntityManager<T> {

    T findById(Long id);

    Long getNextIdVal(String tableName, String columnIdName);

    T insert(T entity);

    List<T> findAll();

}
