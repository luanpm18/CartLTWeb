package businessClass;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String description;
    private double price;

    public Product() {
        this.id = "";
        this.description = "";
        this.price = 0.0;
    }

    public Product(String id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Helper methods for compatibility with code/productCode references
    public String getCode() {
        return id;
    }

    public void setCode(String code) {
        this.id = code;
    }

    public String getProductCode() {
        return id;
    }

    public void setProductCode(String productCode) {
        this.id = productCode;
    }

}
