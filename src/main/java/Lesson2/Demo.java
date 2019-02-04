package Lesson2;

import Lesson1.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setName("TestDemo");
        product.setDescription("32167");
        product.setPrice(1488);

        Product product1 = new Product();
        product1.setName("dfgdfg");
        product1.setDescription("456sdfgsfg");
        product1.setPrice(654);

        Product product2 = new Product();
        product2.setName("glghgh");
        product2.setDescription("ZXC66115");
        product2.setPrice(98721);

        Product product3 = new Product();
        product3.setName("sebuhvnoas");
        product3.setDescription("vozMMF");
        product3.setPrice(357951);

        ArrayList<Product> products = (ArrayList<Product>) Arrays.asList(product1,product2,product3);


        productDAO.save(product);
//        System.out.println(productRepository.read().toString());
        productDAO.delete(777);
        product.setPrice(2488);
        productDAO.equals(product);

        productDAO.saveProducts(products);

        productDAO.updateProducts(products);

        productDAO.deleteProducts(products);
    }
}
