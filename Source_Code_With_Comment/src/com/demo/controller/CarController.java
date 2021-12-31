package com.demo.controller;

import com.demo.util.Util;
import com.demo.service.CarService;
import com.demo.vo.Car;
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
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 增加车辆
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("carAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Car vo = new Car();
        //取出页面传进来的参数
        String carName = Util.decode(request, "carName");
        if (carName != null && !carName.equals("")) {
            vo.setCarName(carName);
        }
        String carSiji = Util.decode(request, "carSiji");
        if (carSiji != null && !carSiji.equals("")) {
            vo.setCarSiji(carSiji);
        }
        String carPhone = Util.decode(request, "carPhone");
        if (carPhone != null && !carPhone.equals("")) {
            vo.setCarPhone(carPhone);
        }
        String carStatus = Util.decode(request, "carStatus");
        if (carStatus != null && !carStatus.equals("")) {
            vo.setCarStatus(carStatus);
        }
        String carText = Util.decode(request, "carText");
        if (carText != null && !carText.equals("")) {
            vo.setCarText(carText);
        }

        //调用Service层的增加（insert）方法
        carService.insert(vo);
        this.redirectList(request, response);
    }

    /**
     * 删除车辆
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("carDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        carService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    /**
     * 编辑车辆
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("carEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Car vo = new Car();
        String id = Util.decode(request, "id");
        if (id != null && !id.equals("")) {
            vo.setId(Long.valueOf(id));
        }
        String carName = Util.decode(request, "carName");
        if (carName != null && !carName.equals("")) {
            vo.setCarName(carName);
        }
        String carSiji = Util.decode(request, "carSiji");
        if (carSiji != null && !carSiji.equals("")) {
            vo.setCarSiji(carSiji);
        }
        String carPhone = Util.decode(request, "carPhone");
        if (carPhone != null && !carPhone.equals("")) {
            vo.setCarPhone(carPhone);
        }
        String carStatus = Util.decode(request, "carStatus");
        if (carStatus != null && !carStatus.equals("")) {
            vo.setCarStatus(carStatus);
        }
        String carText = Util.decode(request, "carText");
        if (carText != null && !carText.equals("")) {
            vo.setCarText(carText);
        }
        carService.update(vo);
        this.redirectList(request, response);
    }

    /**
     * 获取车辆的详细信息（详情页面与编辑页面要显示该车辆的详情）并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping({"carGet", "carEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");//取出主键id
        Car vo = carService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";//判断是去详情显示页面还是编辑页面
        response.sendRedirect("car_" + to + ".jsp");
    }

    /**
     * 根据条件查询车辆的列表并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("carList")
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
        Map<String, Object> map = carService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//根据查询条件取出对应的总记录数，用于分页
        String pageNum = Util.decode(request, "pageNum");//封装分页参数
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) carService.list(params).get("list");//根据分页参数startIndex、pageSize查询出来的最终结果list
        pb.setServlet("carList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("car_list.jsp");
    }
}
