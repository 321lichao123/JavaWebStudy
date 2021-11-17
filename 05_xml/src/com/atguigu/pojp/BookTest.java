package com.atguigu.pojp;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BookTest
 *
 * @Author: lichao
 * @Date: 2021/11/16
 * @Description:
 */
public class BookTest {
    @Test
    public void test1() {
        // 创建一个saxReader输入流，去读取xml配置文件，生产document对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("src/books.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws DocumentException {
        // 1、读取xml文件
        SAXReader reader = new SAXReader();
        // 2、读取文件
        Document document = reader.read("src/books.xml");
        // 3、通过document对象获取根元素
        Element rootElement = document.getRootElement();
        // 4、获取元素
        // element()和elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        for(Element book : books) {
            // asXML()：把标签对象转换为标签字符串
            // System.out.println(book.asXML());
            String sn = book.attributeValue("id");
            Element name = book.element("name");
            String nameText = name.getText();
            String authorText = book.elementText("author");
            Double priceText = Double.parseDouble(book.elementText("price"));
             System.out.println(new Book(sn, nameText, authorText, priceText));
        }
    }
}
