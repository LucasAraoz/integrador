package com.yourcompany.webpageproject.repository;

import com.yourcompany.webpageproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
