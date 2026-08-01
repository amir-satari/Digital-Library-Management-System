package ir.maktabsharif.repository.Impl.BookRepository;

import ir.maktabsharif.exception.BookNotFoundExceptio;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.util.HibernateConnection;

import java.util.Optional;

public class BookRepositoryImpl implements BookRepositoryGeneric{
    @Override
    public Boolean save(Book book) {
        Book book1 = HibernateConnection.InTxReturned(em -> {
            em.persist(book);
            return book;
        });
        return book1 != null;
    }

    @Override
    public Optional<Book> update(Book book) {
       return Optional.ofNullable(HibernateConnection.InTxReturned(em -> {
            Book book1 = em.merge(em.find(Book.class,book.getId()));
            em.merge(book1);
            return book1;
        }));
    }

    @Override
    public Optional<Book> findByID(Long aLong) {
        return Optional.ofNullable(HibernateConnection.InTxReturned(em ->{
            Book book = em.find(Book.class,aLong);
            return book;
        }));
    }

    @Override
    public void delete(Long aLong) {
        HibernateConnection.InTxReturned(em -> {

            Book book = em.find(Book.class,aLong);
            if (book != null){
                em.remove(book);
                return null;
            }
            throw new BookNotFoundExceptio("Book Not Founded!");
        });
    }
}
