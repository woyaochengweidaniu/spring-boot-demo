package com.lcm.mongo.template;

import com.lcm.mongo.SpringbootMongoApplicationTest;
import com.lcm.mongo.module.User;
import org.bson.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  15:49
 */
public class TemplateTest extends SpringbootMongoApplicationTest {
    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 批量插入
     */
    @Test
    public void testInserAll() {
        List<User> list = new ArrayList<>();
        list.add(User.builder().userName("魔术师").age(12).build());
        list.add(User.builder().userName("小丑").age(15).build());
        list.add(User.builder().userName("灭霸").age(25).build());
        Collection<User> users = mongoTemplate.insertAll(list);
        users.forEach(System.out::println);
    }

    /**
     * 插入
     */
    @Test
    public void testInsert(){
        User user = mongoTemplate.insert(User.builder().userName("钢铁侠").age(20).build());
        System.out.println(user);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){



        Query query = new Query().addCriteria(Criteria.where("userName").is("小丑"));
        User one = mongoTemplate.findOne(query, User.class);
        Optional.of(one).ifPresent(user -> mongoTemplate.remove(user));

    }

    @Test
    public void testDeleteAll(){
        mongoTemplate.dropCollection(User.class);
        mongoTemplate.findAll(User.class).forEach(System.out::println);
    }

    /**
     * 查找所有
     */
    @Test
    public void testFindAll(){
        List<User> all = mongoTemplate.findAll(User.class);
        all.forEach(System.out::println);
    }

    /**
     * 查找名称交小丑或者灭霸
     */
    @Test
    public void testSimpleQuery() {
        Query query = new Query();
        query.addCriteria(new Criteria().orOperator(Criteria.where("userName").is("小丑"),Criteria.where("userName").is("灭霸")));
        System.out.println(query);
        mongoTemplate.find(query, User.class).forEach(System.out::println);
    }


    /**
     * 模糊查询
     */
    @Test
    public void testLikeQuery(){
        String value = "魔术";
        Pattern pattern = Pattern.compile("^.*" + value.trim() + ".*$");
//        Query query = new Query().addCriteria(Criteria.where("userName").regex(pattern));
        Query query = new Query().addCriteria(Criteria.where("userName").regex(".*?" + value + ".*"));
        List<User> userList = mongoTemplate.find(query, User.class);
        userList.forEach(System.out::println);
    }


    /**
     *
     * 高级特性
     * 聚合测试
     */
    @Test
    public void testAggregation(){
        //根据userName分组然后出现统计每个组有多少个文档，然后在将每个组人的年龄汇总
        GroupOperation groupOperation = Aggregation.group("userName").count().as("count").sum("age").as("sum");
        TypedAggregation<User> aggregation = Aggregation.newAggregation(User.class, groupOperation);
        AggregationResults<User> aggregate = mongoTemplate.aggregate(aggregation, User.class);
        Document rawResults = aggregate.getRawResults();
        List<Document> results = (List<Document>) rawResults.get("results");
        for (Document result : results) {
            System.out.println(result.values());
        }
//        System.out.println(rawResults);
    }


}
