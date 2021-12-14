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

/**
 *
 * @author ACER
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String ADD_PRODUCT = "AddProductController";
    private static final String DELETE_PRODUCT = "DeleteProductController";
    private static final String EDIT_PRODUCT = "EditProductController";
    private static final String SHOW_DETAILS = "ShowDetailsController";
    private static final String SEARCH = "SearchController";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String ADD_TO_CART_DETAILS = "AddToCartDetailsController";
    private static final String UPDATE_CART = "UpdateCartController";
    private static final String DELETE_CART = "DeleteCartController";
    private static final String CHECK_OUT = "CheckOutController";
    private static final String PLACE_ORDER = "PlaceOrderController";
    private static final String DELETE_USER = "DeleteUserController";
    private static final String UNBAN_USER = "UnbanUserController";
    private static final String EDIT_CATEGORY = "EditCategoryController";
    private static final String ADD_CATEGORY = "AddCategoryController";
    private static final String GET_ALL_PRODUCT = "AdminShowListProductController";
    private static final String GET_ALL_USER = "AdminShowListUserController";
    private static final String GET_ALL_CATEGORY = "AdminShowListCategoryController";
    private static final String GET_ALL_ORDER = "AdminShowListOrderController";
    private static final String GET_ALL_ACTIVE_PRODUCT = "UserShowListProductController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Sign In".equals(action)) {
                url = LOGIN;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("Add".equals(action)) {
                url = ADD_PRODUCT;
            } else if ("Delete".equals(action)) {
                url = DELETE_PRODUCT;
            } else if ("Save".equals(action)) {
                url = EDIT_PRODUCT;
            } else if ("ShopDetails".equals(action)) {
                url = SHOW_DETAILS;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("AddToCart".equals(action)) {
                url = ADD_TO_CART;
            } else if ("ADD TO CART".equals(action)) {
                url = ADD_TO_CART_DETAILS;
            } else if ("UpdateCart".equals(action)) {
                url = UPDATE_CART;
            } else if ("DeleteCart".equals(action)) {
                url = DELETE_CART;
            } else if ("GoToCheckOut".equals(action)) {
                url = CHECK_OUT;
            } else if ("Place Order".equals(action)) {
                url = PLACE_ORDER;
            } else if ("Delete User".equals(action)) {
                url = DELETE_USER;
            } else if ("Unban".equals(action)) {
                url = UNBAN_USER;
            } else if ("Save Category".equals(action)) {
                url = EDIT_CATEGORY;
            } else if ("Add Category".equals(action)) {
                url = ADD_CATEGORY;
            } else if ("GetAllProduct".equals(action)) {
                url = GET_ALL_PRODUCT;
            } else if ("GetAllUser".equals(action)) {
                url = GET_ALL_USER;
            } else if ("GetAllCategory".equals(action)) {
                url = GET_ALL_CATEGORY;
            } else if ("GetAllOrder".equals(action)) {
                url = GET_ALL_ORDER;
            } else if ("GetAllActiveProduct".equals(action)) {
                url = GET_ALL_ACTIVE_PRODUCT;
            } else {
                request.setAttribute("ERROR", "Function is not available!");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
