package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
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


    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
    }

    @Test
    public void shouldFindAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone, thirdSmartphone};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Тайные виды на гору Фудзи");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("виктор пелевин");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLabel() {
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneName() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("galaxy 10");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 1;
        manager.idToRemove(idToRemove);
        Product[] expected = new Product[]{secondBook, firstSmartphone, secondSmartphone, thirdSmartphone};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByNameSeveral() {
        Product[] expected = new Product[]{firstBook, thirdSmartphone};
        Product[] actual = manager.searchBy("Унесенные ветром");
        assertArrayEquals(expected, actual);
    }
}
