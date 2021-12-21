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

    /**
     * 增加订单
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("orderAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Order vo = new Order();
        //取出页面传进来的参数
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

        //调用Service层的增加（insert）方法
        orderService.insert(vo);
        this.redirectList(request, response);
    }

    /**
     * 删除订单
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("orderDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        orderService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    /**
     * 编辑订单
     *
     * @param response
     * @param request
     * @throws IOException
     */
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

    /**
     * 获取订单的详细信息（详情页面与编辑页面要显示该订单的详情）并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping({"orderGet", "orderEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");//取出主键id
        Order vo = orderService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";//判断是去详情显示页面还是编辑页面
        response.sendRedirect("order_" + to + ".jsp");
    }

    /**
     * 根据条件查询订单的列表并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("orderList")
    public void list(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.redirectList(request, response);
    }

    /**
     * 跳转到列表页面
     *
     * @param request
     * @param response
     */
    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询列和关键字
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();//用来保存控制层传进来的参数(查询条件)
        params.put("searchColumn", searchColumn);//要查询的列
        params.put("keyword", keyword);//查询的关键字
        Map<String, Object> map = orderService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//根据查询条件取出对应的总记录数，用于分页
        String pageNum = Util.decode(request, "pageNum");//封装分页参数
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) orderService.list(params).get("list");//根据分页参数startIndex、pageSize查询出来的最终结果list
        pb.setServlet("orderList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("order_list.jsp");
    }
}
