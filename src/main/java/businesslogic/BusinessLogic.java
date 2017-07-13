package businesslogic;

import domain.Product;

import java.util.List;

public interface BusinessLogic {

    boolean addProduct(String title, String description);

    boolean removeProductByTitle(String title);

    List<Product> getAllProducts();


}
