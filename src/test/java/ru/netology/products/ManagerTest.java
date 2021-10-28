package ru.netology.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.ProductsRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private ProductsRepository repository = new ProductsRepository();
    private Manager manager = new Manager(repository);
    Product one = new Book(1, "Гарри Поттер и Философский камень", 674, "Джоан Роулинг");
    Product two = new Book(2, "Гарри Поттер и Тайная комната", 700, "Джоан Роулинг");
    Product three = new Book(3, "Гарри Поттер и Орден феникса", 800, "Джоан Роулинг");
    Product four = new Smartphone(6, "Sony Xperia I", 99_000, "Sony");
    Product five = new Smartphone(12, "iPhone 8", 25_000, "Apple");
    Product six = new Smartphone(7, "iPhone 12", 69_000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);

    }

    @Test
    void shouldSearchByAuthor() {

        Product[] expected = new Product[]{one, two, three};
        Product[] actual = manager.searchBy("Джоан Роулинг");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchBookByName() {

        Product[] expected = new Product[]{one, two, three};
        Product[] actual = manager.searchBy("Гарри Поттер");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByName() {

        Product[] expected = new Product[] {five, six};
        Product[] actual = manager.searchBy("iPhone");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {

        Product[] expected = new Product[]{four};
        Product[] actual = manager.searchBy("Sony");

        assertArrayEquals(expected, actual);

    }


}

