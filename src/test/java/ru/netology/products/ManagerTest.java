package ru.netology.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private ProductsRepository repository = new ProductsRepository();
    private Manager manager = new Manager(repository);
    Product one = new Book(1, "Гарри Поттер и Философский камень", 674, "Джоан Роулинг");
    Product two = new Book(2, "Гарри Поттер и Тайная комната", 700, "Джоан Роулинг");
    Product three = new Book(3, "Гарри Поттер и Орден феникса", 800, "Джоан Роулинг");
    Product four = new Smartphone(6, "Sony Xperia I", 99_000, "Sony");
    Product five = new Smartphone(12, "Huawei Nova 5T", 25_000, "Huawei");
    Product six = new Smartphone(7, "iPhone 12", 69_000, "Apple");


    @Test
    void shouldSearchByAuthor() {

        repository.getAll();

        Product[] expected = new Product[] {one, two, three};
        Product[] actual = manager.searchBy("Джоан Роулинг");

        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSearchBookByName() {

        repository.getAll();

        Product[] expected = new Product[] {one, two, three};
        Product[] actual = manager.searchBy("Гарри Поттер");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByName() {

        repository.getAll();

        Product[] expected = new Product[] {six};
        Product[] actual = manager.searchBy("iPhone");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {

        repository.getAll();

        Product[] expected = new Product[] {four};
        Product[] actual = manager.searchBy("Sony");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByNameNoSuchProduct() {

        repository.getAll();

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Марк Твен");

        assertArrayEquals(expected, actual);

    }

}

