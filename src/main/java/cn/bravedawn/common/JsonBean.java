package cn.bravedawn.common;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
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

    @ApiModelProperty(value = "分页总页数")
    private Integer total_page;

    @ApiModelProperty(value = "数据分页页数")
    private Integer page;

    @ApiModelProperty(value = "数据分页数量")
    private Integer page_size;

    @ApiModelProperty(value = "返回数据")
    private T data;

    @ApiModelProperty(value = "栏目标题")
    private String title;

    @ApiModelProperty(value = "栏目描述")
    private String desc;

    @ApiModelProperty(value = "栏目图片")
    private String imageUrl;

    public JsonBean(Integer code, String msg, Integer total, Integer page, Integer pre_page, Integer total_page,
                    T data, String title, String desc, String imageUrl) {
        this.code = code;
        this.msg = msg;
        this.total = total;
        this.page = page;
        this.page_size = pre_page;
        this.data = data;
        this.total_page = total_page;
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }
}
