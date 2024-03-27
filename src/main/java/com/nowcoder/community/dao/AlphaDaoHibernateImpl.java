package com.nowcoder.community.dao;
import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")   //TODO 给Bean命名
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}













