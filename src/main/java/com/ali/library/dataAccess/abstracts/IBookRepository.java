package com.ali.library.dataAccess.abstracts;

import com.ali.library.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository  extends JpaRepository<Book,Integer> {
}
