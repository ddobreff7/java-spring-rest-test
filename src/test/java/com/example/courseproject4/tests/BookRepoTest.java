package com.example.courseproject4.tests;

import com.example.courseproject4.model.Book;
import com.example.courseproject4.repo.BookRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepoTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepo bookRepo;

    @Test
    public void whenFindById_thenReturnById() {
        Book book = new Book();
        book.setTitle("Test title 1");
        book.setAuthor("Test Author 1");
        book.setId(1L);
        entityManager.persist(book);
        entityManager.flush();
        
        Book found = bookRepo.getById(book.getId());
        
        assert(found.getId()).equals(book.getId());
    }
}
