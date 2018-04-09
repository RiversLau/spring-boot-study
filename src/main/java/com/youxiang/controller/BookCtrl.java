package com.youxiang.controller;

import com.youxiang.common.AmazonProperties;
import com.youxiang.dao.BookDao;
import com.youxiang.domain.Book;
import com.youxiang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: Rivers
 * @date: 2018/4/8
 */
@Controller
@RequestMapping("/books")
public class BookCtrl {

    private BookDao bookDao;
    private AmazonProperties amazonProperties;

    @Autowired
    public BookCtrl(BookDao bookDao, AmazonProperties amazonProperties) {
        this.bookDao = bookDao;
        this.amazonProperties = amazonProperties;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listBooksByReader(User reader, Model model) {

        List<Book> bookList = bookDao.findByReader(reader.getUsername());
        if (bookList != null) {
            model.addAttribute("bookList", bookList);
            model.addAttribute("user", reader);
            model.addAttribute("amazonId", amazonProperties.getAssociatedId());
        }
        return "books";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addBook2ReadingList(@PathVariable String reader, Book book) {
        book.setReader(reader);
        bookDao.save(book);
        return "redirect:/books/{reader}";
    }
}
