package sample;

public class Product {
    private String productName;
    private String quantity;
    private String oldPrice;
    private String newPrice;
    private String imgPath;
    private String Description;

    public Product(String productName, String quantity, String oldPrice, String newPrice, String imgPath, String description) {
        this.productName = productName;
        this.quantity = quantity;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.imgPath = imgPath;
        Description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return
                "productName='" + productName + '\'' +
                ", old price=" + oldPrice +
                        ", new price=" + newPrice +
                '}';
    }
}
