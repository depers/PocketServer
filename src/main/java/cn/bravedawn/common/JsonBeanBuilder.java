package cn.bravedawn.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 冯晓 on 2017/10/9.
 */

public class JsonBeanBuilder<T> implements Serializable{

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
    private Integer pre_page;

    @ApiModelProperty(value = "返回数据")
    private T data;

    @ApiModelProperty(value = "栏目标题")
    private String title;

    @ApiModelProperty(value = "栏目描述")
    private String desc;

    @ApiModelProperty(value = "栏目图片")
    private String imageUrl;

    public JsonBeanBuilder() {
    }

    public final JsonBeanBuilder setCode(Integer code){
        this.code = code;
        return this;
    }

    public final JsonBeanBuilder setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public final JsonBeanBuilder setTotal(Integer total){
        this.total = total;
        return this;
    }

    public final JsonBeanBuilder setTotalPage(Integer totalPage){
        this.total_page = totalPage;
        return this;
    }

    public final JsonBeanBuilder setPage(Integer page){
        this.page = page;
        return this;
    }

    public final JsonBeanBuilder setPageSize(Integer pageSize){
        this.pre_page = pageSize;
        return this;
    }

    public final JsonBeanBuilder setData(T data){
        this.data = data;
        return this;
    }

    public final JsonBeanBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public final JsonBeanBuilder setDesc(String desc){
        this.desc = desc;
        return this;
    }

    public final JsonBeanBuilder setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    public final JsonBean build(){
        return new JsonBean(code, msg, total, page, pre_page, total_page, data, title, desc, imageUrl);
    }

    public static JsonBeanBuilder builder(){
        return new JsonBeanBuilder();
    }
}

