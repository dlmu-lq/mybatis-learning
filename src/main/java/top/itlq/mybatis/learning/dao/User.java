package top.itlq.mybatis.learning.dao;

import java.time.Instant;
import java.util.List;

public class User {

    private Integer id;

    private String name;

    private Integer age;

    private Instant birth;

    private List<UserFavoritesEntity> userFavoritesList;

    private UserFavoritesEntity userFavoritesEntity;

    public Instant getBirth() {
        return birth;
    }

    public void setBirth(Instant birth) {
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public List<UserFavoritesEntity> getUserFavoritesList() {
        return userFavoritesList;
    }

    public void setUserFavoritesEntity(List<UserFavoritesEntity> userFavoritesList) {
        this.userFavoritesList = userFavoritesList;
    }

    public UserFavoritesEntity getUserFavoritesEntity() {
        return userFavoritesEntity;
    }

    public void setUserFavoritesEntity(UserFavoritesEntity userFavoritesEntity) {
        this.userFavoritesEntity = userFavoritesEntity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", userFavoritesList=" + userFavoritesList +
                ", userFavoritesEntity=" + userFavoritesEntity +
                '}';
    }

}
