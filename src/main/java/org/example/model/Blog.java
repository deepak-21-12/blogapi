package org.example.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "BLOG_USER_INFO")
public class Blog {


    @Id
    private int blogId;
    private String title;
    private int userId;
    private String status;
    @Temporal(TemporalType.TIME)
    private Date postDate;
    private int likes;
    private String content;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        System.out.println("Id for blog is"+blogId);
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", postDate=" + postDate +
                ", likes=" + likes +
                ", content='" + content + '\'' +
                '}';
    }

}
