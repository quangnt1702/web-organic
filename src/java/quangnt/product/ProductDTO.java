package quangnt.product;

/**
 *
 * @author ACER
 */
public class ProductDTO {

    private String productID;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private int productQuantityOrder;
    private String image;
    private String category;
    private String status;
    private String description;
    private String createDate;

    public ProductDTO(String productID, String productName, double productPrice, int productQuantity, String image, String category, String status, String description, String createDate) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.image = image;
        this.category = category;
        this.status = status;
        this.description = description;
        this.createDate = createDate;
    }

    public ProductDTO(String productID, String productName, double productPrice, int productQuantity, String category, String status, String description) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.category = category;
        this.status = status;
        this.description = description;
    }

    public ProductDTO(String productID, String productName, double productPrice, int productQuantity, String image, String category, String status, String description) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.image = image;
        this.category = category;
        this.status = status;
        this.description = description;
    }

    public ProductDTO(String productID, String productName, double productPrice, int productQuantity, int productQuantityOrder, String image, String category, String status, String description, String createDate) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productQuantityOrder = productQuantityOrder;
        this.image = image;
        this.category = category;
        this.status = status;
        this.description = description;
        this.createDate = createDate;
    }

    public int getProductQuantityOrder() {
        return productQuantityOrder;
    }

    public void setProductQuantityOrder(int productQuantityOrder) {
        this.productQuantityOrder = productQuantityOrder;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

}
