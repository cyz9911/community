package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    // 注入数据访问层Mapper
    @Autowired
    private DiscussPostMapper discussPostMapper;
    // 业务层Service调用数据访问层Dao：分页查询（社区主页分页查询或者个人发帖页分页查询）
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }
    // 业务层Service调用数据访问层Dao：查询总共多少条数据（社区主页或个人主页的总数据条数）
    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}
