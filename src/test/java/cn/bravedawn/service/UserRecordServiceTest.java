package cn.bravedawn.service;

import cn.bravedawn.bean.UserRecord;
import cn.bravedawn.repository.UserRecordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;

/**
 * Created by 冯晓 on 2017/10/9.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRecordServiceTest {

    @Autowired
    private UserRecordService userRecordService;

    @Autowired
    private UserRecordRepository userRecordRepository;


    @Test
    public void update() throws Exception {
        //userRecordService.update(10, 9);
    }


    @Test
    public void testPage(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "updateDate");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0, 5, sort);
        Page<UserRecord> userRecordPage = userRecordRepository.findAll(pageable);

        System.out.println("查询的总页数：" + userRecordPage.getTotalPages());
        System.out.println("查询的总记录数：" + userRecordPage.getTotalElements());
        System.out.println("查询的当前是第几页：" + userRecordPage.getNumber());
        System.out.println("查询的当前页数的集合：" + userRecordPage.getContent());
        for (UserRecord record : userRecordPage.getContent()){
            System.out.println(record.toString());
        }
        System.out.println("查询的当前页面的记录数：" + userRecordPage.getNumberOfElements());
    }


    /**
     * 分页
     * 排序
     * 查询条件 userId > 5
     */
    @Test
    public void testJpaSpecificationExecutor(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "updateDate");
        Sort sort = new Sort(order);
        // page：是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(0, 5, sort);

        /**
         * root：就是我们要查询的类型（UserRecord）
         * criteriaQuery：添加查询条件
         * criteriaBuilder：构建
         */
        Specification<UserRecord> specification = new Specification<UserRecord>() {
            @Override
            public Predicate toPredicate(Root<UserRecord> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("userId");
                return criteriaBuilder.gt(path, 5);
            }
        };

        Page<UserRecord> userRecordPage = userRecordRepository.findAll(specification, pageable);

        System.out.println("查询的总页数：" + userRecordPage.getTotalPages());
        System.out.println("查询的总记录数：" + userRecordPage.getTotalElements());
        System.out.println("查询的当前是第几页：" + userRecordPage.getNumber());
        System.out.println("查询的当前页数的集合：" + userRecordPage.getContent());
        for (UserRecord record : userRecordPage.getContent()){
            System.out.println(record.toString());
        }
        System.out.println("查询的当前页面的记录数：" + userRecordPage.getNumberOfElements());
    }



}