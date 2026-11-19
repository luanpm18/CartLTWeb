package web.cart;

import businessClass.Cart;
import businessClass.LineItem;
import businessClass.Product;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        if (action.equals("shop")) {
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            String id = request.getParameter("id");
            if (id == null) {
                id = request.getParameter("id");
            }
            String description = request.getParameter("description");
            double price = 0.0;
            try {
                price = Double.parseDouble(request.getParameter("price"));
            } catch (Exception e) {
                price = 0.0;
            }

            Product product = new Product(id, description, price);
            LineItem lineItem = new LineItem(product, 1);
            cart.addItem(lineItem);

            url = "/cart.jsp";
        } else if (action.equals("update")) {
            String id = request.getParameter("id");
            int quantity = 1;
            try {
                quantity = Integer.parseInt(request.getParameter("quantity"));
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }
            cart.updateQuantity(id, quantity);
            url = "/cart.jsp";
        } else if (action.equals("remove")) {
            String id = request.getParameter("id");
            if (id == null) {
                id = request.getParameter("id");
            }
            cart.removeItemById(id);
            url = "/cart.jsp";
        } else if (action.equals("checkout")) {
            double total = cart.getTotalAmount();
            session.setAttribute("total", String.valueOf(total));
            url = "/checkout.jsp";
        } else if (action.equals("back")) {
            cart.clear();
            session.removeAttribute("cart");
            session.removeAttribute("total");
            url = "/index.jsp";
        }

        // Lưu giỏ hàng vào Session nếu không phải thao tác back
        if (!action.equals("back")) {
            session.setAttribute("cart", cart);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
