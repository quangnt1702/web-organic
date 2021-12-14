/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quangnt.contollers;

import com.vnpay.common.Config;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quangnt.mail.SendHTMLEmail;
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
@WebServlet(name = "PayResultController", urlPatterns = {"/PayResultController"})
public class PayResultController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "pay-result.jsp";
    private static final String FAIL = "pay-result.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            //Begin process return from VNPAY
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = (String) params.nextElement();
                String fieldValue = request.getParameter(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);

            if (signValue.equals(vnp_SecureHash)) {
                if ("00".equals(request.getParameter("vnp_ResponseCode"))) {
//                    out.print("GD Thanh cong");
                    HttpSession session = request.getSession();
                    OrderDTO order = (OrderDTO) session.getAttribute("ORDER");
                    order.setPaymentStatus("Y");
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
                            request.setAttribute("MESSAGE", "Payment success! Thanks for using our service!");
                            session.removeAttribute("CART");
                            SendHTMLEmail email=new SendHTMLEmail();
                            email.sendEmail(order, order.getEmail());
                        }
                    }
                } else {
//                    out.print("GD Khong thanh cong");
                    url = FAIL;
                    request.setAttribute("MESSAGE", "Payment error! Please try again!");
                }

            } else {
//                out.print("Chu ky khong hop le");
                request.setAttribute("ERROR_MESSAGE", "Chu ky khong hop le");
            }
        } catch (Exception e) {
            log("Error at PayResultController: " + e.toString());
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
