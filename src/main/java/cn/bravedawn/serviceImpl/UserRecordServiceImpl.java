package cn.bravedawn.serviceImpl;

import cn.bravedawn.bean.UserRecord;
import cn.bravedawn.common.JsonBean;
import cn.bravedawn.common.JsonBeanBuilder;
import cn.bravedawn.common.ResponseCode;
import cn.bravedawn.common.UrlType;
import cn.bravedawn.repository.RecordChannelRepository;
import cn.bravedawn.repository.UserRecordRepository;
import cn.bravedawn.service.UserChannelService;
import cn.bravedawn.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by 冯晓 on 2017/10/9.
 */

@Service
public class UserRecordServiceImpl implements UserRecordService{

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private RecordChannelRepository recordChannelRepository;

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
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .setTotal((int) userRecordPage.getTotalElements())
                .setPage(userRecordPage.getNumber())
                .setData(userRecordPage.getContent())
                .setPageSize(userRecordPage.getNumberOfElements())
                .build();
    }


    public JsonBean add(UserRecord userRecord){
        userRecord.setResource(getResource(userRecord.getUrl()));
        userRecord.setUpdateDate(new Date());
        userRecord.setStar("a");
        userRecordRepository.save(userRecord);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .build();
    }

    public JsonBean delete(Integer recordId){
        UserRecord record = userRecordRepository.findOne(recordId);
        if (record == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该记录不存在")
                    .build();
        }
        userRecordRepository.delete(recordId);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .build();

    }

    public JsonBean addStar(Integer recordId){
        UserRecord record = userRecordRepository.findOne(recordId);
        if (record == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该记录不存在")
                    .build();
        }
        record.setStar("b");
        userRecordRepository.save(record);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .build();

    }

    public JsonBean deleteStar(Integer recordId){
        UserRecord record = userRecordRepository.findOne(recordId);
        if (record == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该记录不存在")
                    .build();
        }
        record.setStar("a");
        userRecordRepository.save(record);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .build();

    }

    public JsonBean getStar(Integer userId){
        List<UserRecord> userRecordList = userRecordRepository.findAllByUserIdAndStar(userId, "b");
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .setTotal(userRecordList.size())
                .setData(userRecordList)
                .build();
    }


    private String getResource(String url){
        if (url.contains(UrlType.WEIXIN.getKeyWord())){
            return UrlType.WEIXIN.getUrl();
        } else if (url.contains(UrlType.JIANSHU.getKeyWord())){
            return UrlType.JIANSHU.getUrl();
        } else if (url.contains(UrlType.ZHIHU.getKeyWord())){

            return UrlType.ZHIHU.getUrl();
        } else if (url.contains(UrlType.JUEJIN.getKeyWord())){

            return UrlType.JUEJIN.getUrl();
        } else if (url.contains(UrlType.WEIBO.getKeyWord())){

            return UrlType.WEIBO.getUrl();
        } else{
            return url;
        }

    }
}
