package com.atgugui.service.impl;

import com.atgugui.dao.BookDao;
import com.atgugui.dao.impl.BookDaoImpl;
import com.atgugui.pojo.Book;
import com.atgugui.pojo.Page;
import com.atgugui.service.BookService;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: BookServiceImpl
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        int i = bookDao.addBook(book);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Override
    public void deleteBookById(Integer id) {
        int i = bookDao.deleteBookById(id);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateBook(Book book) {
        int i = bookDao.updateBook(book);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBook() {
        return bookDao.queryBooks();
    }

    /*
    *@author 12468
    *@Description
    *@Date 2021/12/10 23:33
    *@Param pageNo
            pageSize
    *@Return com.atgugui.pojo.Page<com.atgugui.pojo.Book>
    **/
    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        // 2、设置当前页条数
        page.setPageSize(pageSize);
        // 3、获取当前数据总记录
        Integer pageTotalCount = (Integer) bookDao.queryPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        // 4、求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 1、设置当前页码
        page.setPageNo(pageNo);
        // 5、求当前页数据
        Integer begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItem(begin, pageSize);
        page.setItem(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        // 2、设置当前页条数
        page.setPageSize(pageSize);
        // 3、获取当前数据总记录
        Integer pageTotalCount = (Integer) bookDao.queryPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);
        // 4、求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        // 1、设置当前页码
        page.setPageNo(pageNo);
        // 5、求当前页数据
        Integer begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemByPrice(begin, pageSize, min, max);
        page.setItem(items);

        return page;
    }
}
