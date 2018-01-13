package com.gaole.mybatis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 包装实体类
 *
 * @author gl
 * @create 2018-01-13-16:29
 */
public class QueryVo implements Serializable {

    private User user;

    private List<Integer> listIds;

    private Integer[] arrayIds;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getListIds() {
        return listIds;
    }

    public void setListIds(List<Integer> listIds) {
        this.listIds = listIds;
    }

    public Integer[] getArrayIds() {
        return arrayIds;
    }

    public void setArrayIds(Integer[] arrayIds) {
        this.arrayIds = arrayIds;
    }
}
