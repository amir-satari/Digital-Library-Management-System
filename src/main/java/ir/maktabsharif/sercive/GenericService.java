package ir.maktabsharif.sercive;

import ir.maktabsharif.model.basemodel.BaseModel;

import java.util.Optional;

public interface GenericService <T extends BaseModel<ID>,ID extends Number>{
    void save(T t);

    void update(T t);

    void remove(ID id);

    void findByID(ID id);

}
