package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerSecondTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Унесенные ветром", 1000, "Маргарет Митчелл");
    private Book secondBook = new Book(2, "Тайные виды на гору Фудзи", 2000, "Виктор Пелевин");
    private Smartphone firstSmartphone = new Smartphone(3, "iPhone X", 60000, "Apple");
    private Smartphone secondSmartphone = new Smartphone(4, "Galaxy 10", 55000, "Samsung");
    private Smartphone thirdSmartphone = new Smartphone(5, "Унесенные ветром", 90000, "Custom Mobile");


    @Test
    public void shouldBeEmpty() {
        Product[] expected = new Product[0];
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOne() {
        manager.add(firstBook);
        Product[] expected = new Product[]{firstBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSeveral() {
        manager.add(secondBook);
        manager.add(firstSmartphone);
        Product[] expected = new Product[]{secondBook, firstSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
