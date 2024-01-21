class Product {
    private String name;
    private String code;
    private String category;
    private double costPrice;
    private double sellingPrice;
    private double taxPercent;
    private int stockCount;

    public Product(String name, String code, String category, double costPrice, double sellingPrice, double taxPercent, int stockCount) {
        this.name = name;
        this.code = code;
        this.category = category;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.taxPercent = taxPercent;
        this.stockCount = stockCount;
    }

    public double calculateBillingPrice() {
        return sellingPrice * (1 + taxPercent / 100);
    }

    public String getCode() {
        return code;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void reduceStock(int quantity) {
        if (quantity <= stockCount) {
            stockCount -= quantity;
        } else {
            System.out.println("Insufficient stock");
        }
    }
}