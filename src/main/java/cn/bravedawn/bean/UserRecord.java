package cn.bravedawn.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@Entity
@Data
public class UserRecord {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private String url;

    private String title;

    private String colorAvatar;

    private String resource;

    private String star;

    private Date updateDate;

    @Transient
    private boolean mStar;

    @Transient
    private String channel;

}
