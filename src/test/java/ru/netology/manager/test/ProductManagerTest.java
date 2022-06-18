package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;
public class ProductManagerTest {
    Product book1 = new Book(1, "Двенадцать лет спустя", 300, "Дюма");
    Product phone1 = new Smartphone(2, "x321", 5000, "Nokia");
    Product phone2 = new Smartphone(3, "x331", 7500, "Nokia");
    Product phone3 = new Smartphone(4, "x10", 33400, "Nokia");
    Product book2 = new Book(5, "Двадцать лет спустя", 450, "Дюма");
    Product book3 = new Book(6, "Десять лет спустя", 740, "Дюма");

    @Test
    public void firstTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(2);
        manager.findAll();

        Product[] actual = manager.findById(3);
        Product[] expected = {phone2};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void matchesTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);



        Product[] actual = manager.searchBy("No");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void secondTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("10");
        Product[] expected = { phone3 };
        Assertions.assertArrayEquals(expected, actual);

        ProductRepository repo1 = new ProductRepository();
        ProductManager manager1 = new ProductManager(repo1);

        manager1.add(book1);
        manager1.add(phone1);
        manager1.add(phone2);
        manager1.add(phone3);
        manager1.add(book2);
        manager1.add(book3);

        Product[] actual1 = manager1.searchBy("Д");
        Product[] expected1 = {book1, book2, book3};
        Assertions.assertArrayEquals(expected1, actual1);

    }
}
