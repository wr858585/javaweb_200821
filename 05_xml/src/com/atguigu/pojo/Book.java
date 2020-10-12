package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.math.BigDecimal;
import java.util.List;

public class Book {

    private String sn;
    private String name;
    private String author;
    private BigDecimal price;

    public Book() {
    }

    public Book(String sn, String name, String author, BigDecimal price) {
        this.sn = sn;
        this.name = name;
        this.author = author;
        this.price = price;
    }


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }


    public static void main(String[] args) throws DocumentException {
        // 读取xml文件，生成Document对象
        SAXReader saxReader = new SAXReader();
        // 读取xml文件，生成Document对象
        Document document = saxReader.read("05_xml/src/books.xml");

        // 通过Document对象获取根元素 == boos
        Element rootElement = document.getRootElement();
        // asXML() 把对象转换为xml字符串
        // System.out.println(rootElement.asXML());

        // elements() 根据给定的标签名，查找子标签对象集合返回
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            // elementText() 获取指定标签名元素的文本内容
            String nameText = book.elementText("name");
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            // attributeValue()获取指定属性的值返回;
            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue,nameText,authorText,new BigDecimal(priceText)));
        }
    }
}
