package top.itlq.mybatis.learning.dao;

import java.time.Instant;

public class UserFavoritesEntity {

    private Integer id;

    private Integer userKey;

    private String content;

    private Instant createTime;

    private Instant operTime;

    private Integer useFlg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserKey() {
        return userKey;
    }

    public void setUserKey(Integer userKey) {
        this.userKey = userKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getOperTime() {
        return operTime;
    }

    public void setOperTime(Instant operTime) {
        this.operTime = operTime;
    }

    public Integer getUseFlg() {
        return useFlg;
    }

    public void setUseFlg(Integer useFlg) {
        this.useFlg = useFlg;
    }

    @Override
    public String toString() {
        return "UserFavoritesEntity{" +
                "id=" + id +
                ", userKey=" + userKey +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", operTime=" + operTime +
                ", useFlg=" + useFlg +
                '}';
    }

}
