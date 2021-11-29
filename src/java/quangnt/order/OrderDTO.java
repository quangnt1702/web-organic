package quangnt.order;

/**
 *
 * @author ACER
 */
public class OrderDTO {

    private String orderID;
    private String email;
    private String userID;
    private String receiverName;
    private String address;
    private String phone;
    private double totalMoney;
    private String orderDate;
    private String statusID;
    public String paymentStatus;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String email, String userID, String address, String phone, double totalMoney, String orderDate, String statusID, String paymentStatus) {
        this.orderID = orderID;
        this.email = email;
        this.userID = userID;
        this.address = address;
        this.phone = phone;
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;
        this.statusID = statusID;
        this.paymentStatus = paymentStatus;
    }

    public OrderDTO(String orderID, String email, String userID, String receiverName, String address, String phone, double totalMoney, String orderDate, String statusID, String paymentStatus) {
        this.orderID = orderID;
        this.email = email;
        this.userID = userID;
        this.receiverName = receiverName;
        this.address = address;
        this.phone = phone;
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;
        this.statusID = statusID;
        this.paymentStatus = paymentStatus;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
