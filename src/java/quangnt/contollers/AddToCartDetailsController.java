/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quangnt.contollers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quangnt.product.ProductDAO;
import quangnt.product.ProductDTO;
import quangnt.shopping.Cart;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AddToCartDetailsController", urlPatterns = {"/AddToCartDetailsController"})
public class AddToCartDetailsController extends HttpServlet {

    private static final String ERROR = "ShowDetailsController";
    private static final String SUCCESS = "ShowDetailsController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String productID = request.getParameter("productID");
            int productQuantityOrder = Integer.parseInt(request.getParameter("productQuantityOrder"));
            ProductDAO dao = new ProductDAO();
            ProductDTO product = dao.getProductByProductID(productID);
            product.setProductQuantityOrder(productQuantityOrder);
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
                if (product.getProductQuantityOrder() > product.getProductQuantity()) {
                    request.setAttribute("ERROR_DETAIL", "Product in stock is not enough. Max is: " + product.getProductQuantity());
                } else {
                    cart = new Cart();
                    cart.add(product);
                    session.setAttribute("CART", cart);
                    url = SUCCESS;
                }
            } else {
                boolean flag = true;
                for (ProductDTO productDTO : cart.getCart().values()) {
                    if (productDTO.getProductID().equals(productID)) {
                        productQuantityOrder = productQuantityOrder + productDTO.getProductQuantityOrder();
                        if (productQuantityOrder > product.getProductQuantity()) {
                            request.setAttribute("ERROR_DETAIL", "Product in stock is not enough. Max is: " + product.getProductQuantity());
                        } else {
                            product = productDTO;
                            product.setProductQuantityOrder(productQuantityOrder);
                            cart.update(product);
                            session.setAttribute("CART", cart);
                            url = SUCCESS;
                        }
                        flag = false;
                    }
                }
                if (flag) {
                    if (product.getProductQuantityOrder() > product.getProductQuantity()) {
                        request.setAttribute("ERROR_DETAIL", "Product in stock is not enough. Max is: " + product.getProductQuantity());
                    } else {
                        cart.add(product);
                        session.setAttribute("CART", cart);
                        url = SUCCESS;
                    }
                }
            }
        } catch (Exception e) {
            log("Error at AddToCartController: " + e.toString());
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
