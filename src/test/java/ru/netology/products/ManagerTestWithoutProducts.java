package ru.netology.products;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.ProductsRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTestWithoutProducts {

    private ProductsRepository repository = new ProductsRepository();
    private Manager manager = new Manager(repository);

    @Test
    void shouldSearchByNameInEmptyRepo() {

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Гарри Поттер");

        assertArrayEquals(expected, actual);

    }
}
