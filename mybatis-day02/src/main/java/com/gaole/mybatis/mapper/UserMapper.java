package com.gaole.mybatis.mapper;

import com.gaole.mybatis.entity.QueryVo;
import com.gaole.mybatis.entity.User;

import java.util.List;

/**
 * User类对象的接口
 *
 * @author gl
 */
public interface UserMapper {

    /**
     * 根据用户名进行模糊查询
     *
     * @param queryVo
     * @return
     */
    public List<User> findByQueryVo(QueryVo queryVo);

    /**
     * 返回数据表中的总记录数
     *
     * @return
     */
    public Integer countUser();


    /**
     * 根据性别和用户名进行查询
     *
     * @param user
     * @return
     */
    List<User> findBySexAndUsername(User user);

    /**
     * 根据集合中的多个id进行对象的查询
     *
     * @param queryVo
     * @return
     */
    List<User> findByIds(QueryVo queryVo);

    List<User> findByIds(List<Integer> ids);

    List<User> findByIds(Integer[] ids);
}
