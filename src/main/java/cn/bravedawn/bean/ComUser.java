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
public class ComUser {

    @Id
    @GeneratedValue
    private Integer id;

    private String phone;

    private String pwd;

    private String avatar;

    private String nickname;

    private Date updateDate;


}
