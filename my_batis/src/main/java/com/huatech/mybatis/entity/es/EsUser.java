package com.huatech.mybatis.entity.es;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-12 14:44
 **/
@Data
@Document(indexName = "user",type = "doc",
        useServerConfiguration = true,createIndex = false)
public class EsUser {
    @Id
    private Integer id;
    @Field(analyzer = "ik_max_word")
    private String name;
    private String age;
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String desc;
    @Field(name = "update_time",type = FieldType.Date, format = DateFormat.custom,
            pattern = "yyyy-MM-dd HH:mm:ss||yyyy-mm-dd||epoch_millis||yyyy-MM-dd'T'HH:mm:ssZ")


    private Date updateTime;

}
