package com.youxiang.dao;

import com.youxiang.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Rivers
 * @date: 2018/4/8
 */
public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
