package ir.maktabsharif.sercive;

import ir.maktabsharif.model.basemodel.BaseModel;

import java.util.Optional;

public interface GenericService <T extends BaseModel<ID>,ID extends Number>{
    void save(T t);

    Boolean update(T t);

    Boolean remove(ID id);

    Optional<T> findByID(ID id);

}
