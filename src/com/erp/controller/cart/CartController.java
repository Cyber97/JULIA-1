package com.erp.controller.cart;

import com.erp.entity.cart.Cart;
import com.erp.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "cc")
public class CartController {
    @Autowired
    CartService cartService;
    @RequestMapping(value = "addBox.do")
    public String addBoxToCart(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Cart cart)
    {
        request.getSession().setAttribute("cart", cart);
        return null;
    }
}
