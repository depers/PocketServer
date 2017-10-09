package cn.bravedawn.controller.app;

import cn.bravedawn.jo.JsonBean;
import cn.bravedawn.service.UserRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@RestController
@RequestMapping("/user_record")
public class UserRecordController {

    @Autowired
    private UserRecordService userRecordService;

    @GetMapping("/{id:\\d+}")
    @ApiOperation("用户记录查询服务")
    public JsonBean query(@PathVariable(name = "id", required = true)Integer userId,
                          @PageableDefault(page = 0, size = 10, sort = "updateDate",
                                  direction = Sort.Direction.DESC)Pageable pageable){

        return userRecordService.queryAllByPage(userId, pageable);
    }

}
