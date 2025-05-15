package com.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.beans.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
