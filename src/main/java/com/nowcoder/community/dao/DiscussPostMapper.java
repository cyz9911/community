package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    // TODO 分页查询，返回List集合，DiscussPost为帖子对象。
    // todo 参数：
    //      userId：分页查询不需要userId。userId用于开发用户个人主页，个人主页中有“我发布的帖子”功能，该功能就可以调用这个方法，
    //                然后传用户id。在分页查询不需要userId时，值为0，此时不把userId拼到SQL语句中；若userId不为0，就把userId
    //                拼到SQL语句中。
    //      offset：这一页起始行的行号
    //      limit：这一页最多显示多少条数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // TODO 总共多少页需要“共有多少条数据”和“每页显示多少条数据”来计算，“每页显示多少条数据”已经固定，所以需要取得”共有多少条数据“。
    // TODO 计算“共有多少条数据”。当分页查询时，不需要把userId拼到SQL语句中；当查询个人主页，就需要把userId拼到SQL语句中。
    // todo @Param注解用于给参数取别名。如果下面方法只有一个参数,并且在动态SQL的<if>里使用,则必须加别名。如果有方法中有多个参数，就不用加别名。
    int selectDiscussPostRows(@Param("userId") int userId);

}











