package com.demo.controller;

import com.demo.util.Util;
import com.demo.service.OrderService;
import com.demo.vo.Order;
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
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("orderAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Order vo = new Order();
        //Fetch the parameters passed in from the page
        String orderName = Util.decode(request, "orderName");
        if (orderName != null && !orderName.equals("")) {
            vo.setOrderName(orderName);
        }
        String orderPhone = Util.decode(request, "orderPhone");
        if (orderPhone != null && !orderPhone.equals("")) {
            vo.setOrderPhone(orderPhone);
        }
        String orderAddress = Util.decode(request, "orderAddress");
        if (orderAddress != null && !orderAddress.equals("")) {
            vo.setOrderAddress(orderAddress);
        }
        String orderJiren = Util.decode(request, "orderJiren");
        if (orderJiren != null && !orderJiren.equals("")) {
            vo.setOrderJiren(orderJiren);
        }
        String orderJiphone = Util.decode(request, "orderJiphone");
        if (orderJiphone != null && !orderJiphone.equals("")) {
            vo.setOrderJiphone(orderJiphone);
        }
        String orderJiaddress = Util.decode(request, "orderJiaddress");
        if (orderJiaddress != null && !orderJiaddress.equals("")) {
            vo.setOrderJiaddress(orderJiaddress);
        }
        String orderCarno = Util.decode(request, "orderCarno");
        if (orderCarno != null && !orderCarno.equals("")) {
            vo.setOrderCarno(orderCarno);
        }
        String orderStatus = Util.decode(request, "orderStatus");
        if (orderStatus != null && !orderStatus.equals("")) {
            vo.setOrderStatus(orderStatus);
        }
        String orderDate = Util.decode(request, "orderDate");
        if (orderDate != null && !orderDate.equals("")) {
            vo.setOrderDate(orderDate);
        }
        String orderText = Util.decode(request, "orderText");
        if (orderText != null && !orderText.equals("")) {
            vo.setOrderText(orderText);
        }

        //Calling the add (insert) method of the Service layer
        orderService.insert(vo);
        this.redirectList(request, response);
    }

    @RequestMapping("orderDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        orderService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    @RequestMapping("orderEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Order vo = new Order();
        String id = Util.decode(request, "id");
        if (id != null && !id.equals("")) {
            vo.setId(Long.valueOf(id));
        }
        String orderName = Util.decode(request, "orderName");
        if (orderName != null && !orderName.equals("")) {
            vo.setOrderName(orderName);
        }
        String orderPhone = Util.decode(request, "orderPhone");
        if (orderPhone != null && !orderPhone.equals("")) {
            vo.setOrderPhone(orderPhone);
        }
        String orderAddress = Util.decode(request, "orderAddress");
        if (orderAddress != null && !orderAddress.equals("")) {
            vo.setOrderAddress(orderAddress);
        }
        String orderJiren = Util.decode(request, "orderJiren");
        if (orderJiren != null && !orderJiren.equals("")) {
            vo.setOrderJiren(orderJiren);
        }
        String orderJiphone = Util.decode(request, "orderJiphone");
        if (orderJiphone != null && !orderJiphone.equals("")) {
            vo.setOrderJiphone(orderJiphone);
        }
        String orderJiaddress = Util.decode(request, "orderJiaddress");
        if (orderJiaddress != null && !orderJiaddress.equals("")) {
            vo.setOrderJiaddress(orderJiaddress);
        }
        String orderCarno = Util.decode(request, "orderCarno");
        if (orderCarno != null && !orderCarno.equals("")) {
            vo.setOrderCarno(orderCarno);
        }
        String orderStatus = Util.decode(request, "orderStatus");
        if (orderStatus != null && !orderStatus.equals("")) {
            vo.setOrderStatus(orderStatus);
        }
        String orderDate = Util.decode(request, "orderDate");
        if (orderDate != null && !orderDate.equals("")) {
            vo.setOrderDate(orderDate);
        }
        String orderText = Util.decode(request, "orderText");
        if (orderText != null && !orderText.equals("")) {
            vo.setOrderText(orderText);
        }
        orderService.update(vo);
        this.redirectList(request, response);
    }

    @RequestMapping({"orderGet", "orderEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        Order vo = orderService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";
        response.sendRedirect("order_" + to + ".jsp");
    }


    @RequestMapping("orderList")
    public void list(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.redirectList(request, response);
    }


    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();
        params.put("searchColumn", searchColumn);
        params.put("keyword", keyword);
        Map<String, Object> map = orderService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");
        String pageNum = Util.decode(request, "pageNum");
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) orderService.list(params).get("list");
        pb.setServlet("orderList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("order_list.jsp");
    }
}
