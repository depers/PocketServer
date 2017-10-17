package cn.bravedawn.serviceImpl;

import cn.bravedawn.bean.UserRecord;
import cn.bravedawn.common.JsonBean;
import cn.bravedawn.repository.UserRecordRepository;
import cn.bravedawn.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;

/**
 * Created by 冯晓 on 2017/10/9.
 */

@Service
public class UserRecordServiceImpl implements UserRecordService{

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Transactional
    public void update(Integer id, Integer userId){
        userRecordRepository.update(id, userId);
    }

    public JsonBean queryAllByPage(Integer userId, Pageable pageable){
        //JsonBean jsonBean = new JsonBean();
        Specification<UserRecord> specification = new Specification<UserRecord>() {
            @Override
            public Predicate toPredicate(Root<UserRecord> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("userId");
                return criteriaBuilder.equal(path, userId);
            }
        };
        Page<UserRecord> userRecordPage = userRecordRepository.findAll(specification, pageable);

//        jsonBean.setTotal(userRecordPage.getNumberOfElements());
//        jsonBean.setPage_size(userRecordPage.getNumber());
//        jsonBean.setCode(0);
//        jsonBean.setMessage("success");
//        jsonBean.setData(userRecordPage.getContent());

        return null;
    }
}
