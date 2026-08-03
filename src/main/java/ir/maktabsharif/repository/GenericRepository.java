package ir.maktabsharif.repository;

import ir.maktabsharif.model.basemodel.BaseModel;

import java.util.Optional;

public interface GenericRepository <T extends BaseModel<ID>,ID extends Number>{

    Boolean save(T t);

    Optional<T> update(T t);

    Optional<T> findByID(ID id);

    void delete(ID id);

    boolean Detached(T t);

    void backDetached(T t);


}
