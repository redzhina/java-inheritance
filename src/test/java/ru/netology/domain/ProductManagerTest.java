package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Унесенные ветром", 1000, "Маргарет Митчелл");
    private Book secondBook = new Book(2, "Тайные виды на гору Фудзи", 2000, "Виктор Пелевин");
    private Smartphone firstSmartphone = new Smartphone(3, "iPhone X", 60000, "Apple");
    private Smartphone secondSmartphone = new Smartphone(4, "Galaxy 10", 55000, "Samsung");
    private Smartphone thirdSmartphone = new Smartphone(5, "Унесенные ветром", 90000, "Custom Mobile");

    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test

    public void shouldGetAll() {
        setUp();
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.getRepository().findAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByName() {
        setUp();
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Унесенные ветром");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByAuthor() {
        setUp();
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("виктор пелевин");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByLabel() {
        setUp();
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("apple");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindBySmartphoneName() {
        setUp();
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("galaxy 10");
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldRemoveById() {
        Book firstBook = new Book(1, "Унесенные ветром", 1000, "Маргарет Митчелл");
        Book secondBook = new Book(2, "Тайные виды на гору Фудзи", 2000, "Виктор Пелевин");
        int idToRemove = 1;
        manager.add(firstBook);
        manager.add(secondBook);
        repository.removeById(idToRemove);
        Product[] expected = new Product[]{secondBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldBeEmpty() {
        Product[] expected = new Product[0];
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOne() {
        manager.add(firstBook);
        Product[] expected = new Product[]{firstBook};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddSeveral() {
        manager.add(secondBook);
        manager.add(firstSmartphone);
        Product[] expected = new Product[]{secondBook, firstSmartphone};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByNameSeveral() {
        setUp();
        Product[] expected = new Product[]{firstBook, thirdSmartphone};
        Product[] actual = manager.searchBy("Унесенные ветром");
        assertArrayEquals(expected, actual);
    }
}
