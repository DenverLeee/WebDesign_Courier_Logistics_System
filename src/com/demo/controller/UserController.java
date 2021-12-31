package com.demo.controller;

import com.demo.util.Util;
import com.demo.service.UserService;
import com.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("userAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        User vo = new User();
        //Fetch the parameters passed in from the page
        String username = Util.decode(request, "username");
        if (username != null && !username.equals("")) {
            vo.setUsername(username);
        }
        String password = Util.decode(request, "password");
        if (password != null && !password.equals("")) {
            vo.setPassword(password);
        }
        String realName = Util.decode(request, "realName");
        if (realName != null && !realName.equals("")) {
            vo.setRealName(realName);
        }
        String userSex = Util.decode(request, "userSex");
        if (userSex != null && !userSex.equals("")) {
            vo.setUserSex(userSex);
        }
        String userPhone = Util.decode(request, "userPhone");
        if (userPhone != null && !userPhone.equals("")) {
            vo.setUserPhone(userPhone);
        }
        String userText = Util.decode(request, "userText");
        if (userText != null && !userText.equals("")) {
            vo.setUserText(userText);
        }
        String userType = Util.decode(request, "userType");
        if (userType != null && !userType.equals("")) {
            vo.setUserType(userType);
        }

        //Calling the add (insert) method of the Service layer
        userService.insert(vo);
        this.redirectList(request, response);
    }

    @RequestMapping("userDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        userService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    @RequestMapping("userEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        User vo = new User();
        String id = Util.decode(request, "id");
        if (id != null && !id.equals("")) {
            vo.setId(Long.valueOf(id));
        }
        String username = Util.decode(request, "username");
        if (username != null && !username.equals("")) {
            vo.setUsername(username);
        }
        String password = Util.decode(request, "password");
        if (password != null && !password.equals("")) {
            vo.setPassword(password);
        }
        String realName = Util.decode(request, "realName");
        if (realName != null && !realName.equals("")) {
            vo.setRealName(realName);
        }
        String userSex = Util.decode(request, "userSex");
        if (userSex != null && !userSex.equals("")) {
            vo.setUserSex(userSex);
        }
        String userPhone = Util.decode(request, "userPhone");
        if (userPhone != null && !userPhone.equals("")) {
            vo.setUserPhone(userPhone);
        }
        String userText = Util.decode(request, "userText");
        if (userText != null && !userText.equals("")) {
            vo.setUserText(userText);
        }
        String userType = Util.decode(request, "userType");
        if (userType != null && !userType.equals("")) {
            vo.setUserType(userType);
        }
        userService.update(vo);
        this.redirectList(request, response);
    }

    @RequestMapping({"userGet", "userEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        User vo = userService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";
        response.sendRedirect("user_" + to + ".jsp");
    }

    @RequestMapping("userList")
    public void list(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.redirectList(request, response);
    }

    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();
        params.put("searchColumn", searchColumn);
        params.put("keyword", keyword);
        Map<String, Object> map = userService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");
        String pageNum = Util.decode(request, "pageNum");
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) userService.list(params).get("list");
        pb.setServlet("userList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("user_list.jsp");
    }
}
