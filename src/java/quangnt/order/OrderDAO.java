package quangnt.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
