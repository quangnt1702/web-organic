package quangnt.product;

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
public class ProductDAO {

    public List<ProductDTO> getAllProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select * from tblProduct ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    double productPrice = Double.parseDouble(rs.getString("productPrice"));
                    int productQuantity = Integer.parseInt(rs.getString("productQuantity"));
                    String image = rs.getString("image");
                    String category = getCategeoryName(rs.getString("categoryID"));
                    String status = getStatusName(rs.getString("statusID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    list.add(new ProductDTO(productID, productName, productPrice, productQuantity, image, category, status, description, createDate));
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

    public List<ProductDTO> getAllActiveProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select * from tblProduct ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    double productPrice = Double.parseDouble(rs.getString("productPrice"));
                    int productQuantity = Integer.parseInt(rs.getString("productQuantity"));
                    String image = rs.getString("image");
                    String category = getCategeoryName(rs.getString("categoryID"));
                    String status = getStatusName(rs.getString("statusID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    if (status.equals("Active")) {
                        list.add(new ProductDTO(productID, productName, productPrice, productQuantity, image, category, status, description, createDate));
                    }
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

    public ProductDTO getProductByProductID(String productID) throws SQLException {
        ProductDTO product = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select * from tblProduct where productID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String productName = rs.getString("productName");
                    double productPrice = Double.parseDouble(rs.getString("productPrice"));
                    int productQuantity = Integer.parseInt(rs.getString("productQuantity"));
                    String image = rs.getString("image");
                    String category = getCategeoryName(rs.getString("categoryID"));
                    String status = getStatusName(rs.getString("statusID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    product = new ProductDTO(productID, productName, productPrice, productQuantity, image, category, status, description, createDate);
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
        return product;
    }

    public boolean updateQuantity(String productID, int productQuantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Update tblProduct "
                        + "set productQuantity=?, statusID=? "
                        + "where productID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, Integer.toString(productQuantity));
                String status = "A";
                if (productQuantity == 0) {
                    status = "NA";
                }
                stm.setString(2, status);
                stm.setString(3, productID);
                check = stm.executeUpdate() > 0;
            }

        } catch (Exception e) {
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

    public List<ProductDTO> searchProducts(String searchText) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select * from tblProduct where productName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchText + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    double productPrice = Double.parseDouble(rs.getString("productPrice"));
                    int productQuantity = Integer.parseInt(rs.getString("productQuantity"));
                    String image = rs.getString("image");
                    String category = getCategeoryName(rs.getString("categoryID"));
                    String status = getStatusName(rs.getString("statusID"));
                    String description = rs.getString("description");
                    String createDate = rs.getString("createDate");
                    list.add(new ProductDTO(productID, productName, productPrice, productQuantity, image, category, status, description, createDate));
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

    public boolean addProduct(ProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Insert into tblProduct(productID, productName, productPrice, productQuantity, image, categoryID, statusID, description, createDate) "
                        + " values(?,?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getProductID());
                stm.setString(2, product.getProductName());
                stm.setDouble(3, product.getProductPrice());
                stm.setInt(4, product.getProductQuantity());
                stm.setString(5, product.getImage());
                stm.setString(6, getCategeoryID(product.getCategory()));
                stm.setString(7, getStatusID(product.getStatus()));
                stm.setString(8, product.getDescription());
                stm.setString(9, product.getCreateDate());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
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

    public boolean disableProduct(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Update tblProduct Set statusID='NA' where productID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
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

    public boolean updateProduct(ProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "Update tblProduct "
                        + "Set productName=?, productPrice=?, productQuantity=?, categoryID=?, description=?, statusID=?, image=? "
                        + " where productID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getProductName());
                stm.setDouble(2, product.getProductPrice());
                stm.setInt(3, product.getProductQuantity());
                stm.setString(4, getCategeoryID(product.getCategory()));
                stm.setString(5, product.getDescription());
                stm.setString(6, getStatusID(product.getStatus()));
                stm.setString(7, product.getImage());
                stm.setString(8, product.getProductID());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
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

    public List<Category> getCategorys() throws SQLException {
        List<Category> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select categoryName from tblCategory ";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String categoryName = rs.getString("categoryName");
                    list.add(new Category(categoryName));
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

    public String getCategeoryName(String id) throws SQLException {
        String name = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select categoryName from tblCategory where categoryID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    name = rs.getString("categoryName");
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
        return name;
    }

    public String getCategeoryID(String name) throws SQLException {
        String id = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select categoryID from tblCategory where categoryName = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getString("categoryID");
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
        return id;
    }

    public String getStatusName(String id) throws SQLException {
        String name = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select statusName from tblStatus where statusID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    name = rs.getString("statusName");
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
        return name;
    }

    public String getStatusID(String name) throws SQLException {
        String id = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "select statusID from tblStatus where statusName = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                rs = stm.executeQuery();
                if (rs.next()) {
                    id = rs.getString("statusID");
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
        return id;
    }
}
