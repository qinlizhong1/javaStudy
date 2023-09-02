package utils;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

public class SearchUtils {
    private static RestHighLevelClient client;

    static {
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
    }

    private SearchUtils(){

    }


    /*
    GET /user/_search
    {
        "query":{
            "match_all":{

            }
        }
    }
     */
    public static void getMatchAll(String indexName) throws IOException {
        System.out.println("----------------------------  match_all  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        // 指定检索条件:查询索引中全部的数据
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        // 发送请求到ES
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = response.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }
    }


    /*term 精确匹配，不进行分词
    GET /user/_search
    {
        "query":{
            "term":{
                "sex":{
                    "value":"女"
                }
            }
        }
    }
    */
    public static void getTerm(String indexName, String field, Object kw) throws IOException {
        System.out.println("\n\n----------------------------  term  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //指定检索条件
        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery(field, kw)));

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }
    }


    /* match在匹配时会对所查找的关键词进行分词，然后按分词匹配查找。

    size 关键字：指定查询结果中返回指定条数。 默认返回值10条。
    from 关键字：用来指定起始返回位置，和size关键字连用可实现分页效果
    _source"关键字：指定查询的记录包含哪些字段
    sort关键字：按照指定字段对查询到的结果进行排序


    GET /user/_search
    {
        "_source":["name", "desc"],
        "from":1,
        "size":2,
        "query":{
            "match":{
                "desc":"中国"
            }
        },
        "sort":[
            {
                "_id":{
                    "order":"asc"
                }
            }
        ]
    }
    */
    public static void getMatch(String indexName, String field, Object kw) throws IOException {
        System.out.println("\n\n----------------------------  match  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //指定检索条件
        searchRequest.source(new SearchSourceBuilder().from(1).size(3).fetchSource(new String[]{"name", field}, null)
                .sort("_id", SortOrder.DESC).query(QueryBuilders.matchQuery(field, kw)));

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }
    }


    /* multi_match:如果我们希望对文档中的多个字段进行匹配，其中一个字段有这个文档就满足，那么可以使用multi_match查询，
    GET /user/_search
    {
        "query":{
            "multi_match":{
                "query":"美国",
                "fields":["name", "desc"]
            }
        }
    }
    */
    public static void getMultiMatch(String indexName, String[] fields, Object kw) throws IOException {
        System.out.println("\n\n----------------------------  multi_match  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //指定检索条件
        searchRequest.source(new SearchSourceBuilder()
                .query(QueryBuilders.multiMatchQuery(kw).field(fields[0]).field(fields[1])));

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }
    }


    /* range:范围查询
    GET /user/_search
    {
        "query":{
            "range":{
                "age":{
                    "gte":40
                }
            }
        }
    }
    */
    public static void getRange(String indexName, String field, Integer lower, Integer upper) throws IOException {
        System.out.println("\n\n----------------------------  range  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //指定检索条件
        searchRequest.source(new SearchSourceBuilder()
                .query(QueryBuilders.rangeQuery(field).gte(lower)));

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }
    }


    /* bool查询之must查询
    GET /user/_search
    {
        "query":{
            "bool":{
              "must":[
                {
                  "match":{
                    "desc":"中国"
                  }
                },
                {
                  "range": {
                    "age": {
                    "gte": 30
                  }
                }
               }
              ]
            }
        }
    }
    */
    public static void getBoolMust(String indexName, String field, String kw,  String rangeField, Integer lower) throws IOException {
        System.out.println("\n\n----------------------------  bool must  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //指定检索条件
        searchRequest.source(new SearchSourceBuilder()
                .query(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(field, kw))
                                                .must(QueryBuilders.rangeQuery(rangeField).gte(lower))));

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }
    }


    /* bool查询之must查询
    GET /user/_search
    {
        "query":{
            "bool":{
              "should":[
                {
                  "match":{
                    "desc":"中国"
                  }
                },
                {
                  "term": {
                    "sex": {
                      "value": "男"
                    }
                  }
                },
                {
                  "range": {
                    "age": {
                    "gte": 30
                  }
                }
               }
              ],

              "minimum_should_match": 2
            }
        }
    }
    */
    public static void getBoolShould(String indexName, String field, String kw,  String rangeField, Integer lower) throws IOException {
        System.out.println("\n\n----------------------------  bool should  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //指定检索条件
        searchRequest.source(new SearchSourceBuilder()
                .query(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery(field, kw))
                        .should(QueryBuilders.rangeQuery(rangeField).gte(lower))
                        .should(QueryBuilders.termQuery("sex", "男"))
                        .minimumShouldMatch(2)));

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }
    }

    /* exists查询:
    GET /user/_search
    {
        "query":
        {
            "exists":{
                "field":"desc"
            }
        }
    }
    */
    public static void getExists(String indexName, String field) throws IOException {
        System.out.println("\n\n----------------------------  exists  -----------------------");

        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //指定检索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.existsQuery(field));
        searchRequest.source(searchSourceBuilder);

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());

            System.out.println();
        }

    }


    /* highlight:高亮查询
    GET /user/_search
    {
        "query":{
            "match":{
                "desc":"中国"
            }
        },
        "highlight": {
          "fields": {
            "desc": {}
          }
        }
    }

    也对多个字段进行高亮，如下面对name和desc两个字段进行高亮显示：
    GET /user/_search
    {
        "query":{
            "multi_match":{
                "query":"美国",
                "fields": ["name", "desc"]
            }
        },
        "highlight": {
          "fields": [
                {"desc": {}},
                {"name": {}}
            ]
        }
    }
    */
    public static void getHighlight(String indexName, String field, String kw) throws IOException {
        System.out.println("\n\n----------------------------  Highlight  -----------------------");
        //定义请求对象
        SearchRequest searchRequest = new SearchRequest(indexName);

        //自定义高亮 查找
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field(field);//对哪个字段高亮

        //指定检索条件
        searchRequest.source(new SearchSourceBuilder()
                .query(QueryBuilders.matchQuery(field, kw)).highlighter(highlightBuilder));

        //发送请求到ES
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        //处理响应结果
        SearchHit[] hits = search.getHits().getHits();

        for(SearchHit  hit : hits){
            System.out.println("_index : "  + hit.getIndex());
            System.out.println("_id : "  + hit.getId());
            System.out.println("_score : "  + hit.getScore());
            System.out.println("_source string : "  + hit.getSourceAsString());
            System.out.println("高亮信息 : " + hit.getHighlightFields());

            System.out.println();
        }
    }

    public static void close() throws IOException {
        if (null != client){
            client.close();
        }
    }
}
