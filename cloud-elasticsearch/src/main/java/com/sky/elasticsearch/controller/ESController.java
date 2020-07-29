package com.sky.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.sky.elasticsearch.component.ESClientComponent;
import com.sky.elasticsearch.entity.SubmitUserPayOrderRequest;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhuang
 * @date 2020-07-29 18:57
 */
@RestController
public class ESController {

    @Autowired
    private ESClientComponent esClientComponent;

    @PostMapping(value = "/es/submit")
    public String submit(@RequestBody SubmitUserPayOrderRequest userPayOrderRequest) {
        Long result = esClientComponent.save("zz", JSON.toJSONString(userPayOrderRequest));
        return String.valueOf(result);
    }

    @PostMapping(value = "/es/search")
    public String query() {
        Map<String, String> result = new HashMap<>();

        //匹配所有文档 参数列表(字段名称或者value值)
        MatchAllQueryBuilder bqb = QueryBuilders.matchAllQuery().queryName("payAblAmount");
        String matchAllQueryResult = esClientComponent.search("zz", bqb, 10);
        result.put("matchAllQueryResult", matchAllQueryResult);

        //分词查询 text为中文，matchPhraseQuery/matchPhraseQueryResult都可以查询
        QueryBuilder matchPhraseQuery = QueryBuilders.matchPhraseQuery("id", "三大");
        String matchPhraseQueryResult = esClientComponent.search("zz", matchPhraseQuery, 10);
        result.put("matchPhraseQueryResult", matchPhraseQueryResult);

        //text为英文，matchPhrasePrefixQuery适用于英文 一般在存储的时候会默认把英文按照单词分词
        QueryBuilder matchPhrasePrefixQuery = QueryBuilders.matchPhrasePrefixQuery("id", "text");
        String matchPhrasePrefixQueryResult = esClientComponent.search("zz", matchPhrasePrefixQuery, 10);
        result.put("matchPhrasePrefixQueryResult", matchPhrasePrefixQueryResult);

        //匹配字段数据  es中index:zz，column:id text:阿三大苏打  三苏也能查询到这条数据
        QueryBuilder matchQuery = QueryBuilders.matchQuery("id", "三苏");
        String matchQueryResult = esClientComponent.search("zz", matchQuery, 10);
        result.put("matchQueryResult", matchQueryResult);

        //将text匹配多个字段 参数列表(text，Field1，Field2，Field3，Field4........)
        QueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery("1", "id", "status");
        String multiMatchQueryResult = esClientComponent.search("zz", multiMatchQuery, 10);
        result.put("multiMatchQueryResult", multiMatchQueryResult);

        //模糊查询 由于分词关系 (?匹配单个字符，*匹配多个字符) 中文只能查询单个字 而英文可以任意长度
        QueryBuilder wildcardQuery = QueryBuilders.wildcardQuery("id", "*extzzwq*");
        String wildcardQueryResult = esClientComponent.search("zz", wildcardQuery, 10);
        result.put("wildcardQueryResult", wildcardQueryResult);

        //复合查询 must的意义等同sql查询中的and  must的参数为上面任意一个QueryBuilder
        QueryBuilder BoolQueryBuilder = QueryBuilders.boolQuery().must(matchPhraseQuery).must(matchQuery);
        String BoolQueryBuilderResult = esClientComponent.search("zz", BoolQueryBuilder, 10);
        result.put("BoolQueryBuilderResult", BoolQueryBuilderResult);
        return JSON.toJSONString(result);
    }
}
