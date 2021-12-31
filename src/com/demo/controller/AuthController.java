package com.demo.controller;

import com.demo.service.UserService;
import com.demo.util.Util;
import com.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class AuthController extends HttpServlet {
    @Autowired
    private UserService userService;

    @RequestMapping("authLogin")
    public void login(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        String username = Util.decode(request, "username");
        String password = Util.decode(request, "password");

        String validationCode = Util.decode(request, "validationCode");
        if (validationCode != null && !validationCode.equals(request.getSession().getAttribute("validationCode"))) {//Verify number incorrect
            request.getSession().setAttribute("alert_msg", "Error,Verify Number incorrect！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Map<String, Object> params = new HashMap();
        params.put("searchColumn", "username");//Search by `username`
        params.put("keyword", username);
        List<User> list = (List<User>) userService.list(params).get("list");
        for (User user : list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {//Find Admin
                request.getSession().setAttribute("loginUser", user);
                request.getRequestDispatcher(Util.decode(request, "forwardPage")).forward(request, response);
                return;
            }
        }
        request.getSession().setAttribute("alert_msg", "Error,Username or password incorrect！");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @RequestMapping("authRegister")
    public void register(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        String username = Util.decode(request, "username");
        String password = Util.decode(request, "password");
        System.out.println("username=" + username);
        System.out.println("password=" + password);

        Map<String, Object> params = new HashMap();
        params.put("searchColumn", "username");//Search by `username`
        params.put("keyword", username);
        params.put("startIndex", 0);
        params.put("pageSize", Long.MAX_VALUE);
        List<User> list = (List<User>) userService.list(params).get("list");
        for (User user : list) {
            if (user.getUsername().equals(username) /*&& user.getPassword().equals(password)*/) {//User already exist, change another username to register!
                request.getSession().setAttribute("alert_msg", "Error,User already exist！");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
        }
        User vo = new User();
        vo.setUsername(username);
        vo.setPassword(password);
        //vo.setUserType("General User");//need a default value
        userService.insert(vo);
        request.getSession().setAttribute("alert_msg", "Successfully!Username：[" + username + "]");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @RequestMapping("authLogout")
    public void logout(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        if (user != null) {
            session.removeAttribute("loginUser");
        }
        response.sendRedirect("login.jsp");
    }

    @RequestMapping("authValidationCode")
    public void validationCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String codeChars = "0123456789";
        // A collection of characters for the graphical CAPTCHA, the system will randomly select some characters from this string as the CAPTCHA
        //  Get the length of the captcha set
        int charsLength = codeChars.length();
        //  All three statements close the browser's buffer, 
        //but because browser versions differ, 
        //use all three statements together to close the browser's buffer
        response.setHeader("ragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //  Set the length and width of the graphic captcha (the size of the graphic)
        int width = 90, height = 20;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();//  Get the Graphics object used to output the text
        Random random = new Random();
        g.setColor(Util.getRandomColor(180, 250));// Randomly set the colour to be filled
        g.fillRect(0, 0, width, height);//  Filled graphic background
        //  Setting the initial font
        g.setFont(new Font("Times New Roman", Font.ITALIC, height));
        g.setColor(Util.getRandomColor(120, 180));// Randomly set font colours
        //  Used to save the last randomly generated verification code
        StringBuilder validationCode = new StringBuilder();
        //  Random font for captcha
        String[] fontNames = {"Times New Roman", "Book antiqua", "Arial"};
        for (int i = 0; i < 4; i++) {
            //  Randomly set the font of the current CAPTCHA character
            g.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC, height));
            //  Randomly obtain the characters of the current CAPTCHA
            char codeChar = codeChars.charAt(random.nextInt(charsLength));
            validationCode.append(codeChar);
            //  Randomly set the colour of the current CAPTCHA character
            g.setColor(Util.getRandomColor(10, 100));
            //  Output the captcha characters on the graph, with x and y generated randomly
            g.drawString(String.valueOf(codeChar), 16 * i + random.nextInt(7), height - random.nextInt(6));
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5 * 60);
        //  Save the validation code in the session object, key is validation_code
        session.setAttribute("validationCode", validationCode.toString());
        g.dispose();//  Close the Graphics object
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "JPEG", os);// Send graphical verification code to client in JPEG format
    }

    @RequestMapping("authResetPassword")
    public void resetPassword(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        String msg;
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        String oldPassword = Util.decode(request, "oldPassword");
        if (!loginUser.getPassword().equals(oldPassword)) {
            msg = "Password Error！";
        } else {
            String newPassword = Util.decode(request, "newPassword");
            loginUser.setPassword(newPassword);
            this.userService.update(loginUser);
            msg = "Successfully Modify！";
        }
        request.getSession().setAttribute("alert_msg", msg);
        request.getRequestDispatcher("reset_password.jsp").forward(request, response);
    }
}
