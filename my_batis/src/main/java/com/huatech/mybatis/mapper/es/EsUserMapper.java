package com.huatech.mybatis.mapper.es;

import com.huatech.mybatis.entity.es.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-12 15:06
 **/
public interface EsUserMapper extends ElasticsearchRepository<EsUser,Integer> {
}
