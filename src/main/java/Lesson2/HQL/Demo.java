package Lesson2.HQL;

public class Demo {
    public static void main(String[] args) {
        ProductDAO_HQL productDAOHql = new ProductDAO_HQL();

//        productDAOHql.findByName("test");
//        productDAOHql.findByNameSortedAcc("");
//        productDAOHql.findByNameSortedDec("");
//        productDAOHql.findByPrice(9000,100500);
//        productDAOHql.findByPriceSortedDec(9000,100500);
//        productDAOHql.findByContainedName("test");
        productDAOHql.findById(777);
    }
}
