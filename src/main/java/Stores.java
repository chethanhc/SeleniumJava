import java.util.ArrayList;
import java.util.List;

class Store {
    private String name;
    private String address;
    private String contactNumber;
    private List<Product> productList;

    // Constructor, getters, setters, and other methods
    public Store() {
        this.productList = new ArrayList<>();
    }

    // Function to add a product to the store
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Function to get a product by code
    public Product getProductByCode(String code) {
        for (Product product : productList) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }

    // Function to get the stock value of a product by code
    public int getStockValueByCode(String code) {
        Product product = getProductByCode(code);
        return (product != null) ? product.getStockCount() : 0;
    }
}