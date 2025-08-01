package com.servlet;

import java.io.IOException;

import com.food.daoimp.MenuImp;
import com.food.models.Cart;
import com.food.models.CartItem;
import com.food.models.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Handle hotel context switching
        String newResId = request.getParameter("resid");
        if(newResId==null) {
        	newResId = (String)session.getAttribute("resId");
        }
        String oldResId = (String) session.getAttribute("oldresid");

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || oldResId == null || !oldResId.equals(newResId)) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("oldresid", newResId);
        }

        session.setAttribute("resId", newResId);

        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addCartItem(request, cart);
                break;
            case "update":
            	updateCartItem(request, cart);
                break;
            case "delete":
                deleteCartItem(request, cart);
                break;
            default:
                break;
        }
        RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
		rd.include(request, response);
        
    }

    private void addCartItem(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        MenuImp menuDao = new MenuImp();
        Menu menuItem = menuDao.getMenu(itemId);

        if (menuItem != null) {
            CartItem cartItem = new CartItem(
                    menuItem.getMenuId(),
                    menuItem.getItemName(),
                    menuItem.getPrice(),
                    quantity,
                    menuItem.getImagePath()
            );
            cart.addCartItem(cartItem);
        }
    }

    private void updateCartItem(HttpServletRequest request, Cart cart) {
    	 int itemId = Integer.parseInt(request.getParameter("itemId"));
         int quantity = Integer.parseInt(request.getParameter("quantity"));

         MenuImp menuDao = new MenuImp();
         Menu menuItem = menuDao.getMenu(itemId);

         if (menuItem != null) {
             CartItem cartItem = new CartItem(
                     menuItem.getMenuId(),
                     menuItem.getItemName(),
                     menuItem.getPrice(),
                     quantity,
                     menuItem.getImagePath()
             );
             cart.updateCartItem(cartItem, quantity);;
         }
    }

    private void deleteCartItem(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        CartItem item = cart.getItemById(itemId);
        if (item != null) {
            cart.deleteCartItem(item);
        }
    }
}
