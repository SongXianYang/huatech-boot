package com.huatech.mybatis.service;

import com.huatech.mybatis.entity.Param;
import com.huatech.mybatis.entity.User;
import com.huatech.mybatis.entity.es.EsUser;
import com.huatech.mybatis.mapper.UserMapper;
import com.huatech.mybatis.mapper.es.EsUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-12 15:36
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private EsUserMapper esUserMapper;


    @Override
    public Map<String, Object> findMysql(Param param) {
        StopWatch watch = new StopWatch();
        watch.start();
        HashMap<String, Object> map = new HashMap<>(10);
        if ("mysql".equals(param.getType())) {
            List<User> users = userMapper.findAllByParam(param.getInputParam());
            map.put("list", users);
        } else {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("name", param.getInputParam()));
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("desc", param.getInputParam()));
            String s = boolQueryBuilder.toString();
            log.info("findMysql: "+s);

            Iterable<EsUser> search =esUserMapper.search(boolQueryBuilder);
            map.put("list", search);
        }
        /*
        POST user/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "match_phrase": {
            "name": "王"
          }
        },
        {
          "match_phrase": {
            "desc": "王"
          }
        }
      ]
    }
  }
}
         */


        watch.stop();
        long lastTaskTimeMillis = watch.getLastTaskTimeMillis();
        map.put("time", lastTaskTimeMillis);


        return map;

    }

    @Override
    public Map<String, Object> findEs() {
        return null;
    }


}
