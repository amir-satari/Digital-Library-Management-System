package ir.maktabsharif.sercive;

import ir.maktabsharif.exception.BookNotFoundExceptio;
import ir.maktabsharif.exception.BookOperationException;
import ir.maktabsharif.exception.BussinesException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.Impl.BookRepository.BookRepositoryImpl;

import java.util.Optional;

public class BookService implements GenericService<Book ,Long>{

    BookRepositoryImpl bookRepository;

    public BookService(){
        this.bookRepository = new BookRepositoryImpl();
    }

    private void validation(Book book){
        if (book.getTitle().isBlank())throw new BussinesException("Book title is empty!");
        if (book.getISBN().isBlank())throw new BussinesException("Book ISBN is empty!");
        if (book.getPrice()<0)throw new BussinesException("Book price is negative!");
    }


    @Override
    public void save(Book book) {
        try {
            validation(book);
            bookRepository.save(book);
            System.out.println("Book operation save successfully ");
        }catch (BussinesException | BookOperationException e){
            System.out.println("Book operation save is failed!");
        }
    }

    @Override
    public void update(Book book) {
        try {
            validation(book);
            bookRepository.update(book);
            System.out.println("Book operation update successfully ");
        }catch (BussinesException | BookOperationException e){
            System.out.println("Book operation update is failed! ");
        }
    }

    @Override
    public void remove(Long aLong) {
        try {
            bookRepository.delete(aLong);
            System.out.println("Book operation remove successfully ");
        }catch (BookNotFoundExceptio e){
            System.out.println("Book operation remove is failed! ");
        }
    }

    @Override
    public boolean findByID(Long aLong) {
        try {
            Optional<Book> book =  bookRepository.findByID(aLong);
            if (book.isEmpty()){
                System.out.println("Book not found for id");
                return false;
            }
            System.out.println("Book founded => "+book);
            return true;
        }catch (BookNotFoundExceptio e){
            System.out.println("Book operation find is failed! ");
        }
        return false;
    }
}
