package xyz.zjr.me;

import java.io.Serializable;

/**
 * @Author: qingshan
 */
public class Blog implements Serializable{
    Integer id; // 文章ID
    String name; // 文章标题
    Integer authorId; // 文章作者ID

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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + id +
                ", name='" + name + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}
