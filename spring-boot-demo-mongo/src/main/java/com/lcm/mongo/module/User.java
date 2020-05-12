package com.lcm.mongo.module;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  14:47
 */
@Data
@Builder
@Document
public class User {

    @Id
    private String id;

    private String userName;
}
