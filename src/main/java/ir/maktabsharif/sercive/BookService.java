package ir.maktabsharif.sercive;

import ir.maktabsharif.model.Book;

import java.util.Optional;

public class BookService implements GenericService<Book ,Long>{

    @Override
    public void save(Book book) {

    }

    @Override
    public Boolean update(Book book) {
        return null;
    }

    @Override
    public Boolean remove(Long aLong) {
        return null;
    }

    @Override
    public Optional<Book> findByID(Long aLong) {
        return Optional.empty();
    }
}
