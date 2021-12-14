/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quangnt.contollers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quangnt.product.ProductDAO;
import quangnt.product.ProductDTO;
import quangnt.shopping.Cart;
import quangnt.user.UserDTO;

/**
 *
 * @author ACER
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "shoping-cart.jsp";
    private static final String LOGIN = "login.html";
    private static final String SUCCESS = "checkout.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Cache-Control", "private,no-store,no-cache");
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDTO userLogin = (UserDTO) session.getAttribute("USER_LOGIN");
            Cart cart = (Cart) session.getAttribute("CART");
            ProductDAO productDAO = new ProductDAO();
            if (userLogin == null) {
                url = LOGIN;
            } else {
                for (ProductDTO product : cart.getCart().values()) {
                    if (product.getProductQuantityOrder() > productDAO.getProductQuantityByID(product.getProductID())) {
                        product.setProductQuantityOrder(productDAO.getProductQuantityByID(product.getProductID()));
                        cart.update(product);
                        session.setAttribute("CART", cart);
                        session.setAttribute("ERROR_CART", "Product" + product.getProductName() + " in stock is not enough. Max is: " + productDAO.getProductQuantityByID(product.getProductID()));
                        return;
                    }
                }
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at CheckOutController: " + e.toString());
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
