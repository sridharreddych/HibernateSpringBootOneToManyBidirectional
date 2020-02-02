package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    
    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }        

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert author with books  ...");
            bookstoreService.insertAuthorWithBooks();

            System.out.println("\nDelete a book of an author...");
            bookstoreService.deleteBookOfAuthor();
            
            System.out.println("\nDelete all book of an author...");
            bookstoreService.deleteAllBooksOfAuthor();
        };
    }
}
/*
 * 
 * The Best Way To Map The @OneToMany Bidirectional Association

SlideShare presentation can be found here.

Description: This application is a proof of concept of how is correct to implement the bidirectional @OneToMany association from the performance perspective.

Key points:

always cascade from parent to child
use mappedBy on the parent
use orphanRemoval on parent in order to remove children without references
use helper methods on parent to keep both sides of the association in sync
use lazy fetching on both side of the association
as entities identifiers, use assigned identifiers (business key, natural key (@NaturalId)) and/or database-generated identifiers and override (on child-side) properly the equals() and hashCode() methods as here
if toString() need to be overridden, then pay attention to involve only the basic attributes fetched when the entity is loaded from the database
Note: Pay attention to remove operations, especially to removing child entities. The CascadeType.REMOVE and orphanRemoval=true may produce too many queries. In such scenarios, relying on bulk operations is most of the time the best way to go for deletions.


 * 
 * 
 */
