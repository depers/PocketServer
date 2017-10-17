package cn.bravedawn.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@Entity
@Data
public class UserChannel {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private String channel;

    private String descText;

    private String imageUrl;

    private Date updateDate;
}
