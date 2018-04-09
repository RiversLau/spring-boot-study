package com.youxiang;

import com.youxiang.dao.BookDao;
import com.youxiang.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootStudyApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testBookDao() {
        List<Book> bookList = bookDao.findByReader("rivers");
        assert 0 == bookList.size();
    }

	@Test
	public void contextLoads() {

	}

}
