package cn.bravedawn.common;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * Created by 冯晓 on 2017/10/17.
 */
@Data
public class JsonBean<T> {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String msg;

    @ApiModelProperty(value = "数据总数量")
    private Integer total;

    @ApiModelProperty(value = "数据分页页数")
    private Integer page;

    @ApiModelProperty(value = "数据分页数量")
    private Integer pre_page;

    @ApiModelProperty(value = "返回数据")
    private T data;

    @ApiModelProperty(value = "栏目标题")
    private String title;

    @ApiModelProperty(value = "栏目描述")
    private String desc;

    @ApiModelProperty(value = "栏目图片")
    private String imageUrl;

    public JsonBean(Integer code, String msg, Integer total, Integer page, Integer pre_page, T data, String title, String desc, String imageUrl) {
        this.code = code;
        this.msg = msg;
        this.total = total;
        this.page = page;
        this.pre_page = pre_page;
        this.data = data;
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }
}
