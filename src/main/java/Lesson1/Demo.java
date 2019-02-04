package Lesson1;

import org.hibernate.Session;

public class Demo {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Product product = new Product();
        product.setId(987);
        product.setName("TestDemo");
        product.setDescription("32167");
        product.setPrice(1488);

        productRepository.save(product);

    }
}
