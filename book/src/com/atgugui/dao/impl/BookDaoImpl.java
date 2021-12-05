package com.atgugui.dao.impl;

import com.atgugui.dao.BookDao;
import com.atgugui.pojo.Book;

import java.util.List;

/**
 * ClassName: BookDaoImpl
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values (?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?, author = ?, price = ?, sales = ?, stock = ?, img_path = ? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`, `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItem(Integer begin, int pageSize) {
        String sql = "SELECT * FROM t_book LIMIT ?,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Object queryPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemByPrice(Integer begin, int pageSize, int min, int max) {
        String sql = "SELECT * FROM t_book where price between ? and ? order by price LIMIT ?,? ";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }
}
