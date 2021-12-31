package com.demo.controller;

import com.demo.util.Util;
import com.demo.service.NoticeService;
import com.demo.vo.Notice;
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
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("noticeAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Notice vo = new Notice();
        //Fetch the parameters passed in from the page
        String noticeName = Util.decode(request, "noticeName");
        if (noticeName != null && !noticeName.equals("")) {
            vo.setNoticeName(noticeName);
        }
        String noticeText = Util.decode(request, "noticeText");
        if (noticeText != null && !noticeText.equals("")) {
            vo.setNoticeText(noticeText);
        }
        String noticeType = Util.decode(request, "noticeType");
        if (noticeType != null && !noticeType.equals("")) {
            vo.setNoticeType(noticeType);
        }
        String createDate = Util.decode(request, "createDate");
        if (createDate != null && !createDate.equals("")) {
            vo.setCreateDate(createDate);
        }

        //Calling the add (insert) method of the Service layer
        noticeService.insert(vo);
        this.redirectList(request, response);
    }

    @RequestMapping("noticeDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        noticeService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    @RequestMapping("noticeEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Notice vo = new Notice();
        String id = Util.decode(request, "id");
        if (id != null && !id.equals("")) {
            vo.setId(Long.valueOf(id));
        }
        String noticeName = Util.decode(request, "noticeName");
        if (noticeName != null && !noticeName.equals("")) {
            vo.setNoticeName(noticeName);
        }
        String noticeText = Util.decode(request, "noticeText");
        if (noticeText != null && !noticeText.equals("")) {
            vo.setNoticeText(noticeText);
        }
        String noticeType = Util.decode(request, "noticeType");
        if (noticeType != null && !noticeType.equals("")) {
            vo.setNoticeType(noticeType);
        }
        String createDate = Util.decode(request, "createDate");
        if (createDate != null && !createDate.equals("")) {
            vo.setCreateDate(createDate);
        }
        noticeService.update(vo);
        this.redirectList(request, response);
    }

    @RequestMapping({"noticeGet", "noticeEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        Notice vo = noticeService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";
        response.sendRedirect("notice_" + to + ".jsp");
    }

    @RequestMapping("noticeList")
    public void list(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.redirectList(request, response);
    }

    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Query Key Word
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();//Used to store parameters (query conditions) passed in from the control layer
        params.put("searchColumn", searchColumn);//Column to be queried
        params.put("keyword", keyword);//Keyword of the query
        Map<String, Object> map = noticeService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//Retrieve the total number of records corresponding to the query criteria for paging
        String pageNum = Util.decode(request, "pageNum");//Encapsulation of paging parameters
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) noticeService.list(params).get("list");//The final result list according to the paging parameters startIndex, pageSize
        pb.setServlet("noticeList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("notice_list.jsp");
    }
}
