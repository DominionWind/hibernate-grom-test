package Lesson1;

public class Demo {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Product product = new Product();
        product.setId(789654);
        product.setName("TestDemo");
        product.setDescription("32167");
        product.setPrice(1488);

        productRepository.save(product);
//        System.out.println(productRepository.read().toString());
    }
}
