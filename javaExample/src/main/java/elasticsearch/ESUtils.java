package elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.SimpleQueryStringQueryParser;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ESUtils {
    private static RestHighLevelClient restHighLevelClient;
    private static String INDEX = "books";

    static {
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        restHighLevelClient  = new RestHighLevelClient(restClientBuilder);
        System.out.println("--------------- connect es success  ---------------");
    }

    public static RestHighLevelClient getRestHighLevelClient(){
        return restHighLevelClient;
    }


    /************************************************************    索引操作     **********************************************************************/
    /**
    *获取ES中存在的索引
    */
    public void indexView() throws IOException {
        System.out.println("\n-------------------------- 查看索引   -------------------------- ");
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
        GetAliasesResponse getAliasesResponse = restHighLevelClient.indices().getAlias(getAliasesRequest, RequestOptions.DEFAULT);

        //key是索引名称
        Map<String, Set<AliasMetaData>> map = getAliasesResponse.getAliases();

        Set<String> indices = map.keySet();

        for (String key : indices){
            System.out.println("索引名称为:" + key);
        }
    }


    /**
     *创建ES中存在的指定索引,如果指定的索引已经存在，则抛出异常
     */
    public void indexCreate() throws IOException {
        System.out.println("\n-------------------------- 创建索引   -------------------------- ");
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX);

        //设置settings
        createIndexRequest.settings(Settings.builder()
                            .put("index.number_of_shards", 1)
                            .put("index.number_of_replicas", 1));

        //创建索引的同时创建映射:参数1：指定映射json结构   参数2：指定数据类型
        createIndexRequest.mapping("{\n" +
                "      \"properties\":{\n" +
                "        \"name\":{\n" +
                "          \"type\":\"keyword\"\n" +
                "        },\n" +
                "        \"des\":{\n" +
                "          \"type\":\"text\"\n" +
                "        },\n" +
                "        \"price\":{\n" +
                "          \"type\":\"double\"\n" +
                "        },\n" +
                "        \"created_at\":{\n" +
                "          \"type\":\"date\"\n" +
                "        }\n" +
                "     }\n" +
                "  }", XContentType.JSON);

        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse.index());
        System.out.println(createIndexResponse.isAcknowledged());
    }

    /**
     *删除ES中存在的指定索引，索引不存在抛出异常
     */
    public void indexDelete() throws IOException {
        System.out.println("\n-------------------------- 删除索引   -------------------------- ");

        AcknowledgedResponse acknowledgedResponse =
                restHighLevelClient.indices().delete(new DeleteIndexRequest(INDEX), RequestOptions.DEFAULT);

        System.out.println(acknowledgedResponse.isAcknowledged());
    }

    /**
     *判断ES中指定索引是否存在
     */
    public void indexExists() throws IOException {
        boolean isExists = restHighLevelClient.indices().exists(new GetIndexRequest(INDEX), RequestOptions.DEFAULT);
        System.out.println(INDEX +  (isExists ? "索引存在" : "索引不存在"));
    }

    /************************************************************    添加文档操作     **********************************************************************/
    /**
    *添加单条文档
    */
    public void putDataByJson() throws IOException {
        System.out.println("\n-------------------------- 新增文档: json格式  -------------------------- ");
        IndexRequest indexRequest = new IndexRequest(INDEX) //指定索引名称
                                            .id("1")        //指定id
                                            .type("_doc")//指定type
                                            .source("{\"name\": \"book 1\",\"price\": 1.5,\"created_at\": \"2023-01-01\",\"desc\": \"my first book\"}", XContentType.JSON); //json格式数据形式插入文档

        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT );
        System.out.println("新增文档返回值:" + indexResponse);
        System.out.println("新增文档返回状态码:" + indexResponse.status().getStatus());
    }

    /**
     *添加单条文档:map方式
     */
    public void putDataByMap() throws IOException {
        System.out.println("\n-------------------------- 新增文档: map格式  -------------------------- ");

        //通过map组装要添加的数据
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "book 2");
        dataMap.put("price", 2.5);
        dataMap.put("desc", "my second book");
        dataMap.put("created_at", "2023-01-02");

        IndexRequest indexRequest = new IndexRequest(INDEX) //指定索引名称
                .id("2")        //指定id
                .type("_doc")   //指定type
                .source(dataMap); //map格式数据形式插入文档

        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT );
        System.out.println("新增文档返回值:" + indexResponse);
        System.out.println("新增文档返回状态码:" + indexResponse.status().getStatus());
    }

    /**
     *bulk批量添加文档:
     */
    public void putDataBulk() throws IOException {
        System.out.println("\n-------------------------- bulk批量新增文档: map格式  -------------------------- ");
        BulkRequest bulkRequest = new BulkRequest(); //指定索引名称

        //通过map组装要添加的数据
        Map<String, Object> dataMap3 = new HashMap<>();
        dataMap3.put("name", "book 3");
        dataMap3.put("price", 3.5);
        dataMap3.put("desc", "my three book");
        dataMap3.put("created_at", "2023-01-03");

        IndexRequest indexRequest3 = new IndexRequest(INDEX) //指定索引名称
                .id("3")        //指定id
                .type("_doc")   //指定type
                .source(dataMap3); //map格式数据形式插入文档

        Map<String, Object> dataMap4 = new HashMap<>();
        dataMap3.put("name", "book 4");
        dataMap3.put("price", 4.5);
        dataMap3.put("desc", "my forth book");
        dataMap3.put("created_at", "2023-01-04");

        IndexRequest indexRequest4 = new IndexRequest(INDEX) //指定索引名称
                .id("4")        //指定id
                .type("_doc")   //指定type
                .source(dataMap4); //map格式数据形式插入文档

        bulkRequest.add(indexRequest3);
        bulkRequest.add(indexRequest4);

        bulkRequest.timeout(new TimeValue(400)); //设置超时时间

        BulkResponse bulkItemResponses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("bulk批量新增文档返回值:" + bulkItemResponses.getTook());
        if (bulkItemResponses.hasFailures()){
            System.out.println("bulk fail, msg:" + bulkItemResponses.buildFailureMessage());
        }
    }


    /************************************************************    更新文档操作     **********************************************************************/




    /************************************************************    查询文档操作     **********************************************************************/
    /**
     *查询指定索引所有文档:mach_all查询
     * GET /dog/_doc/_search
     * {
     *   "query":{
     *     "match_all":{
     *     }
     *   }
     * }
     */
    public void queryMatchAll() throws IOException {
        System.out.println("\n-------------------------- 查询文档: match_all  -------------------------- ");
        SearchRequest searchRequest = new SearchRequest(INDEX);// INDEX为要查询文档所在的索引
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();//match_all查询
        searchSourceBuilder.query(matchAllQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        TimeValue timeValue = searchResponse.getTook();//此次查询花费的时间
        System.out.println("此次查询花费的时间为:" +timeValue.toString());



        SearchHits searchHits = searchResponse.getHits();
        long total = searchHits.getTotalHits();  //此次查询获取的文档数量
        System.out.println("此次查询获取的文档数量为:" + total);

        Float maxScore = searchHits.getMaxScore();
        System.out.println("此次查询获取的文档得分最高的是:" + maxScore);

        SearchHit[] innerSearchHits = searchHits.getHits();

        //循环获取单条文档信息
        for (SearchHit searchHit : innerSearchHits){
            String index = searchHit.getIndex();
            String type = searchHit.getType();
            String id = searchHit.getId();
            Float score = searchHit.getScore();
            String source = searchHit.getSourceAsString();
            System.out.println("index:" + index + "," + "type:" + type + ","
                              + "id:" + id + "," + "score:" + score + ","
                              + "source:" + source);
        }
    }


    /************************************************************    删除文档操作     **********************************************************************/

}
