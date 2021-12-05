package com.atgugui.dao;

import com.atgugui.pojo.Book;
import com.atgugui.pojo.Page;

import java.util.List;

/**
 * ClassName: BookDao
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public interface BookDao {
    /**
    * Description: 添加图书<br/>
    * @author: 12468<br/>
    * @date: 2021/12/1 22:14<br/>
    * @param:<br/>
    * @return:
    */
    public int addBook(Book book);
    /**
    * Description: 根据id删除图书<br/>
    * @author: 12468<br/>
    * @date: 2021/12/1 22:14<br/>
    * @param:<br/>
    * @return:
    */
    public int deleteBookById(Integer id);
    /**
    * Description: 根据id修改图书<br/>
    * @author: 12468<br/>
    * @date: 2021/12/1 22:15<br/>
    * @param:<br/>
    * @return:
    */
    public int updateBook(Book book);
    /**
    * Description: 根据id查询图书<br/>
    * @author: 12468<br/>
    * @date: 2021/12/1 22:15<br/>
    * @param:<br/>
    * @return:
    */
    public Book queryBookById(Integer id);
    /**
    * Description: 查询图书列表<br/>
    * @author: 12468<br/>
    * @date: 2021/12/1 22:15<br/>
    * @param:<br/>
    * @return:
    */
    public List<Book> queryBooks();

    Number queryPageTotalCount();

    List<Book> queryForPageItem(Integer begin, int pageSize);


    List<Book> queryForPageItemByPrice(Integer begin, int pageSize, int min, int max);

    Object queryPageTotalCountByPrice(int min, int max);
}
