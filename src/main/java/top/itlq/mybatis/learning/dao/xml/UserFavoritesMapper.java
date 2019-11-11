package top.itlq.mybatis.learning.dao.xml;

import top.itlq.mybatis.learning.dao.UserFavoritesEntity;

import java.util.List;

public interface UserFavoritesMapper {
    List<UserFavoritesEntity> selectWithUserKey(int id);
}
