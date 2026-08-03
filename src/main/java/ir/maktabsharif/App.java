package ir.maktabsharif;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.PublisherAddress;
import ir.maktabsharif.sercive.BookService;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static BookService bookService = new BookService();


    public static void main(String[] args) {


        PublisherAddress publisherAddress = new PublisherAddress("maneaged","detached","cleare");
        Book book = new Book("entity lifeceycele","test",2026,250.0,publisherAddress);
        System.out.println("Book in Transient state "+book);

        System.out.println();

        bookService.save(book);
        System.out.println("book in managed state "+book);

        System.out.println();
        System.out.println("Book in detached state");
        bookService.Detached(book);
        book.setTitle("change");
        System.out.println(book);

        System.out.println();
        System.out.println("Book back in detached state");
        bookService.backDetached(book);

        System.out.println();
        bookService.remove(book.getId());






        while (true){
            System.out.print("======menu======\n" +
                    "1. create book\n" +
                    "2. delete book\n" +
                    "3. find by id\n" +
                    "4. update book\n" +
                    "menu => ");
            int menu = scanner.nextInt();

            switch (menu){
                case 1:
                    createBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    findById();
                    break;
                case 4:
                    updateBook();
                    break;
                default:
                    System.out.println("your menu is failed!");
            }
        }

    }
    public static void createBook(){
        System.out.println("enter title : ");
        String title = scanner.next();

        System.out.println("enter ISBN : ");
        String ISBN = scanner.next();

        System.out.println("enter publication Year : ");
        Integer publicationYear = scanner.nextInt();

        System.out.println("enter price : ");
        Double price = scanner.nextDouble();

        System.out.println("enter publisherAddress city : ");
        String city = scanner.next();

        System.out.println("enter publisherAddress street : ");
        String street = scanner.next();

        System.out.println("enter publisherAddress postalCode : ");
        String postalCode = scanner.next();

        PublisherAddress publisherAddress = new PublisherAddress(city,street,postalCode);
        Book book = new Book(title,ISBN,publicationYear,price,publisherAddress);
        bookService.save(book);

    }

    public static void deleteBook(){
        System.out.println("Enter your id : ");
        Long id = scanner.nextLong();
        bookService.remove(id);
    }

    public static void findById(){
        System.out.println("Enter your id : ");
        Long id = scanner.nextLong();
        bookService.findByID(id);
    }

    public static void updateBook(){
        System.out.println("Enter your id : ");
        Long id = scanner.nextLong();
        boolean ishave = bookService.findByID(id);
        if (ishave){
            System.out.println("enter title : ");
            String title = scanner.next();

            System.out.println("enter ISBN : ");
            String ISBN = scanner.next();

            System.out.println("enter publication Year : ");
            Integer publicationYear = scanner.nextInt();

            System.out.println("enter price : ");
            Double price = scanner.nextDouble();

            System.out.println("enter publisherAddress city : ");
            String city = scanner.next();

            System.out.println("enter publisherAddress street : ");
            String street = scanner.next();

            System.out.println("enter publisherAddress postalCode : ");
            String postalCode = scanner.next();

            PublisherAddress publisherAddress = new PublisherAddress(city,street,postalCode);
            Book book = new Book(title,ISBN,publicationYear,price,publisherAddress);
            book.setId(id);

            bookService.update(book);
        }

    }


}
