/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quangnt.contollers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quangnt.order.OrderDAO;
import quangnt.order.OrderDTO;
import quangnt.order.OrderDetail;
import quangnt.product.ProductDAO;
import quangnt.product.ProductDTO;
import quangnt.shopping.Cart;

/**
 *
 * @author ACER
 */
@WebServlet(name = "PlaceOrderController", urlPatterns = {"/PlaceOrderController"})
public class PlaceOrderController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "pay-result.jsp";
    private static final String VN_PAY = "vnpay_home.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String[] methodPayment = request.getParameterValues("methodPayment");
            String userID = request.getParameter("userID");
            String receiverName = request.getParameter("receiverName");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            double totalCart = Double.parseDouble(request.getParameter("totalCart"));
            LocalDateTime currentDateTime = java.time.LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String createDate = currentDateTime.format(format);
            String statusID = "A";
            String paymentStatus = "N";
            UUID uuid = UUID.randomUUID();
            String orderID = uuid.toString();
            OrderDTO order = new OrderDTO(orderID, email, userID, receiverName, address, phoneNumber, totalCart, createDate, statusID, paymentStatus);
            if (methodPayment != null && methodPayment.length == 1) {
                if (methodPayment[0].equals("payment")) {

                    OrderDAO orderDAO = new OrderDAO();
                    boolean check = orderDAO.checkOut(order);
                    if (check) {
                        Cart cart = (Cart) session.getAttribute("CART");
                        boolean checkInsert = false;
                        for (ProductDTO dto : cart.getCart().values()) {
                            String productID = dto.getProductID();
                            int productQuantity = dto.getProductQuantity();
                            double productPrice = dto.getProductPrice();
                            String status = "A";
                            OrderDetail orderDetail = new OrderDetail(order.getOrderID(), productID, productQuantity, productPrice, status);
                            checkInsert = orderDAO.insertOrderDetail(orderDetail);//create orderdetail
                            ProductDAO productDAO = new ProductDAO();
                            //Update quantity available in tblProduct
                            boolean checkUpdate = productDAO.updateQuantity(productID, (dto.getProductQuantity() - dto.getProductQuantityOrder()));
                            if (checkInsert || checkUpdate) {
                                break;
                            }
                        }
                        if (checkInsert) {
                            url = SUCCESS;
                            session.removeAttribute("CART");
                        }
                    }
                }
                if (methodPayment[0].equals("vnpay")) {
                    url = VN_PAY;
                    session.setAttribute("ORDER", order);
                    request.setAttribute("TOTAL_CART", (int)totalCart*22679);
                }
            } else {
                session.setAttribute("ERROR_CHECKOUT", "Please choose one payment method.");
            }
        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
