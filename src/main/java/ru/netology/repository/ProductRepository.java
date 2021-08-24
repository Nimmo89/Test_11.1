package ru.netology.repository;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import ru.netology.domain.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class ProductRepository {
    private static Product[] products = new Product[0];

    public void save(Product item) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        products = tmp;
    }

    public static Product[] findAll() {
        return products;
    }

    public static Product[] findById(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                return new Product[]{item};
            }
        }
        return null;
    }

    public static void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        products = tmp;
    }

    public ProductRepository() {
    }
}