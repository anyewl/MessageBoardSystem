package work.liziyun.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table()
public class Love {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name1;
    private String name2;
    private String password;
    private String content;
    private Integer power;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastTime;
    private Integer helpCount;

    public Love() {
    }

    public Love(Integer id, String name1, String name2, String password, String content, Integer power, Date lastTime, Integer helpCount) {
        this.id = id;
        this.name1 = name1;
        this.name2 = name2;
        this.password = password;
        this.content = content;
        this.power = power;
        this.lastTime = lastTime;
        this.helpCount = helpCount;
    }

    public Integer getHelpCount() {
        return helpCount;
    }

    public void setHelpCount(Integer helpCount) {
        this.helpCount = helpCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Love{" +
                "id=" + id +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", password='" + password + '\'' +
                ", content='" + content + '\'' +
                ", power=" + power +
                ", lastTime=" + lastTime +
                ", helpCount=" + helpCount +
                '}';
    }
}
