package cn.bravedawn.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@Entity
@Data
public class RecordChannel {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private Integer recordId;

    private Integer channelId;
}
