package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;
    // TODO Get请求访问首页，响应的是index.html，故不需要写@ResponseBody
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {    // Stirng为View的名字，不用ModelAndView。TODO Page为分页的条件
        // TODO getIndexPage方法调用之前,SpringMVC会自动实例化Model和Page,并将Page注入Model。所以,在thymeleaf中可以直接访问Page对象中的数据.
        page.setRows(discussPostService.findDiscussPostRows(0));    // TODO 设置页面的总数据条数
        page.setPath("/index");    // todo 设置页面的访问路径
                                                                        // TODO 后两个参数：当前页的起始行、总页码
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>(); // TODO ！！封装帖子和帖子id对应的用户
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);      // 装帖子
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);      // 装帖子对应的用户
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);       // 把查询结果给Model，从而返回给页面
        return "/index";    // TODO 返回路径templates/index.html，templates可省略
    }

}
