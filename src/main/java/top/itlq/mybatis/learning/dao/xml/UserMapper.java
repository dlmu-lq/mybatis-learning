package top.itlq.mybatis.learning.dao.xml;

import top.itlq.mybatis.learning.dao.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User loadUser(int id);
    List<User> selectUser(Map<String,Object> params);
    void insert(User user);
    List<User> selectWithFavorites(Map<String,Object> params);
    List<User> selectWithJoinFavorites(Map<String,Object> params);
}
