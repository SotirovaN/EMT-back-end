package com.finki.backend;

import com.finki.backend.domain.Author;
import com.finki.backend.domain.Country;
import com.finki.backend.domain.dto.BookDto;
import com.finki.backend.domain.enumeration.BookCategory;
import com.finki.backend.service.AuthorService;
import com.finki.backend.service.BookService;
import com.finki.backend.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BackendApplication {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public BackendApplication(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Country country = countryService.save(new Country(0L, "Minnesota, USA", "North America"));
        authorService.save(new Author(0L, "F. Scott", "Fitzgerald", country));
       // authorService.save(new Author(0L, "Andrzej", "Sapkowski", country));

        country = countryService.save(new Country(0L, "Missouri, USA", "North America"));
        authorService.save(new Author(0L, "Gillian", "Flynn", country));

        bookService.save(new BookDto("The Great Gatsby", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("The Beautiful and Damned", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("This Side of Paradise", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("Tender Is the Night", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("Flappers and Philosophers", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("The Diamond as Big as the Ritz", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("Pride & Prejudice", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("Gone Girl", BookCategory.THRILLER, 2L, 5));
        bookService.save(new BookDto("Dark Places", BookCategory.THRILLER, 2L, 5));
        bookService.save(new BookDto("The Grownup", BookCategory.THRILLER, 2L, 5));
        bookService.save(new BookDto("Sharp Objects", BookCategory.THRILLER, 2L, 5));
        bookService.save(new BookDto("Winter Dreams", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("Tender Is the Night and the Last Tycoon", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("The Camel's Back", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("The Lees of Happiness", BookCategory.CLASSICS, 1L, 5));
        bookService.save(new BookDto("The Last of the Belles", BookCategory.CLASSICS, 1L, 5));

    }
}
