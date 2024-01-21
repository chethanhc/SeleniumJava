import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Create Gson object for JSON processing
        Gson gson = new Gson();

        // Create two store objects
        Store store1 = new Store();
        Store store2 = new Store();

        // Load products from JSON file using Gson
        List<Product> products = loadProductsFromJson();

        int numProducts = Math.min(products.size(), 10);

        // Add products to stores
        for (int i = 0; i < numProducts; i++) {
            store1.addProduct(products.get(i));
            store2.addProduct(products.get(i));
        }

        // Create functions to get price and stock value of a product in a store
        String productCode = "P001";
        double priceInStore1 = getPriceInStore(store1, productCode);
        int stockValueInStore1 = getStockValueInStore(store1, productCode);

        System.out.println("Price of product " + productCode + " in Store 1: $" + priceInStore1);
        System.out.println("Stock value of product " + productCode + " in Store 1: " + stockValueInStore1);

        // Bonus Task: Create a cart and get the final cost of products in the cart
        List<Product> cart = new ArrayList<>();
        cart.add(store1.getProductByCode("P001"));
        cart.add(store1.getProductByCode("P002"));

        double finalCost = calculateFinalCost(cart);
        System.out.println("Final cost of products in the cart: $" + finalCost);
    }

    // Function to load products from a JSON file
    private static List<Product> loadProductsFromJson() {
        try (FileReader reader = new FileReader("D:\\JavaSeleniumAssignment\\JsonAssignment\\src\\main\\resources\\products.json")) {
            Type productListType = new TypeToken<List<Product>>() {}.getType();
            return new Gson().fromJson(reader, productListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Function to get the price of a product by code in a store
    private static double getPriceInStore(Store store, String productCode) {
        Product product = store.getProductByCode(productCode);
        return (product != null) ? product.calculateBillingPrice() : 0.0;
    }

    // Function to get the stock value of a product by code in a store
    private static int getStockValueInStore(Store store, String productCode) {
        return store.getStockValueByCode(productCode);
    }

    // Bonus Task: Function to calculate the final cost of products in a cart
    private static double calculateFinalCost(List<Product> cart) {
        double finalCost = 0.0;
        for (Product product : cart) {
            finalCost += product.calculateBillingPrice();
        }
        return finalCost;
    }
}