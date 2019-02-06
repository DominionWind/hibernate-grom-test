package Lesson2.NSQL;

public class Demo {
    public static void main(String[] args) {
        ProductDAO_NativeSQL productDAONativeSQL = new ProductDAO_NativeSQL();

        productDAONativeSQL.findByContainedName("test");
//        productDAONativeSQL.findById(777);
//        productDAONativeSQL.findByName("test");
//        productDAONativeSQL.findByNameSortedAcc("");
//        productDAONativeSQL.findByNameSortedDec("");
//        productDAONativeSQL.findByPrice(9000,100500);
//        productDAONativeSQL.findByPriceSortedDec(9000,100500);
    }
}
