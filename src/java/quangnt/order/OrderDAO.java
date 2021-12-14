package quangnt.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quangnt.utils.DBUtil;

/**
 *
 * @author ACER
 */
public class OrderDAO {

    public boolean checkOut(OrderDTO order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tblOrder(userID,receiverName,email,address,phoneNumber,totalMoney,orderDate,statusID,paymentStatus,orderID) "
                        + " values(?,?,?,?,?,?,?,?,?,?) ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, order.getUserID());
                stm.setString(2, order.getReceiverName());
                stm.setString(3, order.getEmail());
                stm.setString(4, order.getAddress());
                stm.setString(5, order.getPhone());
                stm.setDouble(6, order.getTotalMoney());
                stm.setString(7, order.getOrderDate());
                stm.setString(8, order.getStatusID());
                stm.setString(9, order.getPaymentStatus());
                stm.setString(10, order.getOrderID());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<OrderDTO> getAllOrders() throws SQLException {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select * from tblOrder order by orderDate desc";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String orderID = rs.getString("orderID");
                    String email = rs.getString("email");
                    String userID = rs.getString("userID");
                    String receiverName = rs.getString("receiverName");
                    String address = rs.getString("address");
                    String phone = rs.getString("phoneNumber");
                    double totalMoney = rs.getDouble("totalMoney");
                    String orderDate = rs.getString("orderDate");
                    String statusID = rs.getString("statusID");
                    String paymentStatus = rs.getString("paymentStatus");
                    list.add(new OrderDTO(orderID, email, userID, receiverName, address, phone, totalMoney, orderDate, statusID, paymentStatus));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<OrderDetail> getAllOrderDetailsByOrderID(String orderID) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select * from tblDetailOrder where orderID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String orderDetailID=rs.getString("detailOrderID");
                    String productID=rs.getString("productID");
                    int quantity=rs.getInt("quantity");
                    double price=rs.getDouble("price");
                    String statusID=rs.getString("statusID");
                    list.add(new OrderDetail(orderDetailID, orderID, productID, quantity, price, statusID));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean insertOrderDetail(OrderDetail orderDetail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tblDetailOrder(orderID,productID,quantity,price,statusID) "
                        + " values(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderDetail.getOrderID());
                stm.setString(2, orderDetail.getProductID());
                stm.setInt(3, orderDetail.getQuantity());
                stm.setDouble(4, orderDetail.getPrice());
                stm.setString(5, orderDetail.getStatusID());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
