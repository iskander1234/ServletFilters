package com.example.ServletFilters;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action == null){
            Account account = checkCookie(request);
            if (account == null){
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            else{
                AccountModel accModel =  new AccountModel();
                if (accModel.login(account.getUsername(), account.getPassword())){
                    session.setAttribute("username", account.getUsername());
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else{
                    request.setAttribute("error", "Account Invalid");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            }
        }else {
            if (action.equalsIgnoreCase("logout")){
                session.removeAttribute("username");
                Cookie[] cookies = request.getCookies();
                for (Cookie ck : cookies){
                    if (ck.getName().equalsIgnoreCase("username")){
                        ck.setMaxAge(0);
                        response.addCookie(ck);
                    }
                    if (ck.getName().equalsIgnoreCase("password")){
                        ck.setMaxAge(0);
                        response.addCookie(ck);
                    }
                }
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
    }

    private Account checkCookie(HttpServletRequest request){
        Cookie[] cookie = request.getCookies();
        Account account = null;
        if (cookie == null){
            return null;
        }else{
            String username = "", password = "";
            for (Cookie ck : cookie){
                if (ck.getName().equalsIgnoreCase("username"))
                    username = ck.getValue();
                if (ck.getName().equalsIgnoreCase("password"))
                    password = ck.getValue();
            }
            if (!username.isEmpty() && !password.isEmpty())
                account = new Account(username, password);
        }
        return account;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        AccountModel accModel = new AccountModel();
        if (action == null){
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            boolean remember = request.getParameter("remember") != null;
            if (accModel.login(username, password)){
                session.setAttribute("username", "password");
                if (remember){
                    Cookie ckUsername = new Cookie("username", username);
                    ckUsername.setMaxAge(3000);
                    response.addCookie(ckUsername);
                    Cookie ckPassword = new Cookie("password", password);
                    ckPassword.setMaxAge(3000);
                    response.addCookie(ckPassword);
                }
                request.getRequestDispatcher("welcome.jsp").forward(request,response);
            }else{
                request.setAttribute("error", "Account Invalid");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }

        }else {

        }
    }

}
