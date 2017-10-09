package cn.bravedawn.jo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@Data
public class JsonBean {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "数据总数量")
    private Integer total;

    @ApiModelProperty(value = "数据分页页数")
    private Integer page_size;

    @ApiModelProperty(value = "返回数据")
    private Object data;
}
