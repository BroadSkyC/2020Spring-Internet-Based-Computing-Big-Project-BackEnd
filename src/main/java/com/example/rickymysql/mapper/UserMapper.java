package com.example.rickymysql.mapper;


import com.example.rickymysql.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {

    void createNewAccount(User user);

    void addLike(Integer id,String likes);

    void addGuanzhu(Integer id,String guanzhu);

    void addFans(Integer id,String fans);

    void addFansNum(Integer id);

    void addConcern(Integer id);

    void addDanmuLike(Integer id,String likeDanmu);

    void addCollect(Integer id,String collect);

    void addHistory(Integer id,String history);

    List<User> getAllUsers();

    User getAccountByOpenId(@Param("openid") String openid);

    User getAccountById(int id);

}
