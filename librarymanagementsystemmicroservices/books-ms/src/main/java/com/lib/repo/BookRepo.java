package com.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.beans.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
