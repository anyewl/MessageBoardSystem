package work.liziyun.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table()
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date time;
    private boolean random;
    private String imgSrc;
    private Integer tagId;
    private String contact;
    private String content;
    private Integer comCount;


    public Article() {
    }

    public Article(Integer id, String name, Date time, boolean random, String imgSrc, Integer tagId, String contact, String content, Integer comCount) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.random = random;
        this.imgSrc = imgSrc;
        this.tagId = tagId;
        this.contact = contact;
        this.content = content;
        this.comCount = comCount;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", random=" + random +
                ", imgSrc='" + imgSrc + '\'' +
                ", tagId=" + tagId +
                ", contact='" + contact + '\'' +
                ", content='" + content + '\'' +
                ", comCount=" + comCount +
                '}';
    }
}
