package ir.maktabsharif.model;

import ir.maktabsharif.model.basemodel.BaseModel;
import ir.maktabsharif.model.enums.Stock;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.DialectOverride;

import java.util.Objects;

@Entity
@Table(name = "Books")
@Check(constraints = "price >= 0")
public class Book extends BaseModel<Long> {

    @Column(nullable = false,length = 50)
    private String title;
    @Column(name = "Book_number",nullable = false,unique = true)
    private String ISBN;
    @Column(name = "Publication_Year")
    private Integer publicationYear;
    private Double price;
    @Enumerated
    private Stock stock;
    @Embedded
    private PublisherAddress publisherAddress;

    public Book(String title, String ISBN, Integer publicationYear, Double price, PublisherAddress publisherAddress) {
        this.title = title;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.price = price;
        this.stock = Stock.IN_STOCK;
        this.publisherAddress = publisherAddress;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public PublisherAddress getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(PublisherAddress publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", stock=" + stock +
                ", publisherAddress=" + publisherAddress +
                '}';
    }
}
