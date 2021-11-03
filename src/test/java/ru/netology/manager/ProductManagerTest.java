package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());
    private Product first = new Product(1111, "стол", 1000);
    private Book second = new Book(11112, "Синяя", 100, "Папа Карло");
    private Smartphone third = new Smartphone(3333, "Honor", 12000, "Huawei");
    private Smartphone fourth = new Smartphone(4444, "Samsung", 12000, "Samsung");
    private Book fifth = new Book(55555, "Букварь", 190, "Папа Карло");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldSearchByNameAndMadeBy() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {fourth};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByNameBook() {
        Product[] actual = manager.searchBy("Синяя");
        Product[] expected = {second};
        assertArrayEquals(actual, expected);

    }
    @Test
    public void shouldSearchByNameSmartphone() {
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {third};
        assertArrayEquals(actual, expected);

    }
    @Test
    public void shouldSearchByAutor() {
        Product[] actual = manager.searchBy("Папа Карло");
        Product[] expected = {second, fifth};
        assertArrayEquals(actual, expected);
    }



    @Test
    public void shouldSearchByMadeBy() {
        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = {third};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void shouldSearchByNoText() {
        Product[] actual = manager.searchBy("Cat");
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }
}