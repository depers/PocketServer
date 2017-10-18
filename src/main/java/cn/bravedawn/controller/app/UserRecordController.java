package cn.bravedawn.controller.app;

import cn.bravedawn.bean.UserRecord;
import cn.bravedawn.common.JsonBean;
import cn.bravedawn.service.UserRecordService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@RestController
@Slf4j
@RequestMapping("/record")
public class UserRecordController {

    @Autowired
    private UserRecordService userRecordService;

    @GetMapping("/{id:\\d+}")
    @ApiOperation("用户记录查询服务")
    public JsonBean query(@ApiParam("用户id") @PathVariable(name = "id", required = true)Integer userId,
                          @ApiParam("页数信息") @PageableDefault(page = 0, size = 10, sort = "updateDate",
                                  direction = Sort.Direction.DESC)Pageable pageable){

        return userRecordService.queryAllByPage(userId, pageable);
    }

    @PostMapping()
    @ApiOperation("新增记录")
    public JsonBean add(@ApiParam("记录信息") UserRecord userRecord){
        return userRecordService.add(userRecord);
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation("用户删除记录")
    public JsonBean delete(@ApiParam("记录id") @PathVariable(name = "id", required = true)Integer recordId){
        return userRecordService.delete(recordId);
    }

    @PostMapping("/star/{id:\\d+}")
    @ApiOperation("记录加星操作")
    public JsonBean addStar(@ApiParam("记录id") @PathVariable(name = "id", required = true)Integer recordId){
        return userRecordService.addStar(recordId);
    }

    @DeleteMapping("/star/{id:\\d+}")
    @ApiOperation("记录消星操作")
    public JsonBean deleteStar(@ApiParam("记录id") @PathVariable(name = "id", required = true)Integer recordId){
        return userRecordService.deleteStar(recordId);
    }

    @GetMapping("/star/{id:\\d+}")
    @ApiOperation("获取加星记录")
    public JsonBean getStar(@ApiParam("用户id") @PathVariable(name = "id", required = true)Integer userId){
        return userRecordService.getStar(userId);
    }
}
