package ru.netology.products;

public class Manager {
    private ProductsRepository repository;

    public Manager(ProductsRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }
    public void getAll() {repository.getAll(); }

    Product one = new Book(1, "Гарри Поттер и Философский камень", 674, "Джоан Роулинг");
    Product two = new Book(2, "Гарри Поттер и Тайная комната", 700, "Джоан Роулинг");
    Product three = new Book(3, "Гарри Поттер и Орден феникса", 800, "Джоан Роулинг");
    Product four = new Smartphone(6, "Sony Xperia I", 99_000, "Sony");
    Product five = new Smartphone(12, "Huawei Nova 5T", 25_000, "Huawei");
    Product six = new Smartphone(7, "iPhone 12", 69_000, "Apple");

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        repository.add(one);
        repository.add(two);
        repository.add(three);
        repository.add(four);
        repository.add(five);
        repository.add(six);
        for (Product product : repository.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Book
            Smartphone phone = (Smartphone) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (phone.getName().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (phone.getManufacturer().contains(search)) {
                return true;
            }
            return false;
        }

        return false;

    }

}

