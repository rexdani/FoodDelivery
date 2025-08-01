package com.servlet;

import java.io.IOException;
import java.io.InputStream;

import com.food.daoimp.RestaurantImp;
import com.food.models.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,
    maxFileSize = 1024 * 1024 * 10,
    maxRequestSize = 1024 * 1024 * 15
)
public class RestuarentRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest res, HttpServletResponse resp) throws ServletException, IOException {
        String name = res.getParameter("name");
        String address = res.getParameter("address");
        String phone = res.getParameter("phoneNumber");
        String cuisineType = res.getParameter("cuisineType"); // Corrected this
        String deliveryTime = res.getParameter("deliveryTime");
        String adminUserId = res.getParameter("adminUserId");
        String rating = res.getParameter("rating");
        Boolean isActive = Boolean.parseBoolean(res.getParameter("isActive"));

        // Get image bytes
        Part imagePart = res.getPart("imagePath");
        InputStream imageStream = imagePart.getInputStream();
        byte[] imageBytes = imageStream.readAllBytes(); // ✅ Fix

        // Create Restaurant object
        Restaurant hotel = new Restaurant(
            name, address, phone, cuisineType, deliveryTime,
            adminUserId, rating, isActive, imageBytes
        );

        // Save to DB
        RestaurantImp hotelimp = new RestaurantImp();
        hotelimp.addRestaurant(hotel);

        // Optionally redirect or set success response
        resp.sendRedirect("restaurant_success.jsp");
    }
}
