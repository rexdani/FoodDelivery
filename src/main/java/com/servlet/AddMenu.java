package com.servlet;

import java.io.IOException;
import java.io.InputStream;

import com.food.daoimp.MenuImp;
import com.food.models.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/addMenu")
public class AddMenu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        String itemName = request.getParameter("itemName");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        String isAvailable = request.getParameter("isAvailable");
        String rating = request.getParameter("rating");

        Part imagePart = request.getPart("imagePath");
        InputStream inputStream = imagePart.getInputStream();
        byte[] imageBytes = inputStream.readAllBytes();
        Menu menu=new Menu(restaurantId, itemName, description, price, isAvailable, rating, imageBytes);
        MenuImp imp=new MenuImp();
        imp.addMenu(menu);
        

        response.sendRedirect("Home"); // redirect to menu listing
    }
}

