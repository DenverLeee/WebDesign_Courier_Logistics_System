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

    @RequestMapping("carAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Car vo = new Car();
        //Fetch the parameters passed in from the page
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

        //Call the insert method of the Service layer
        carService.insert(vo);
        this.redirectList(request, response);
    }

    @RequestMapping("carDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        carService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

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

    @RequestMapping({"carGet", "carEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");//Obtain primary key id
        Car vo = carService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";
        //Determine whether to go to the details display page or the edit page
        response.sendRedirect("car_" + to + ".jsp");
    }

    @RequestMapping("carList")
    public void list(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.redirectList(request, response);
    }

    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Query columns and keyword
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();//Used to store parameters (query conditions) passed in from the control layer
        params.put("searchColumn", searchColumn);//Column to be queried
        params.put("keyword", keyword);//Keyword of the query
        Map<String, Object> map = carService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//Retrieve the total number of records corresponding to the query criteria for paging
        String pageNum = Util.decode(request, "pageNum");//Encapsulation of paging parameters
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) carService.list(params).get("list");//The final result list according to the paging parameters startIndex, pageSize
        pb.setServlet("carList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("car_list.jsp");
    }
}
