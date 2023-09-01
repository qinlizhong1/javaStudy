package utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class IndexUtils {
    private static RestHighLevelClient client;

    static {
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
    }

    private IndexUtils(){

    }

    /**
     * 作用：设置索引mappings、settings
     * put /user
     * {
     *    "mappings": {
     *      "_doc"{
     *          "properties": {
     *              "age": {
     *                  "type": "integer"
     *              },
     *              "name": {
     *                  "type": "text",
     *                  "fields": {
     *                      "keyword": {
     *                          "type": "keyword"
     *                      }
     *                  }
     *              },
     *              "sex": {
     *                  "type": "keyword"
     *              },
     *              "desc": {
     *                 "type": "text",
     *                 "analyzer":"ik_smart",
     *                 "search_analyzer":"ik_smart"
     *              }
     *          }
     *       }
     *     },
     *      "settings": {
     *            "number_of_shards": "3",
     *            "number_of_replicas": "1"
     *       }
     * }
     */

    public static void addIndex(String indexName) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);

        // 添加mappings，对比上述结构来理解
        request.mapping("_doc",

                XContentType.JSON);

        String mappingStr = "{\"properties\":{\"name\":{\"type\":\"text\", \"fields\":{\"keyword\":{\"type\":\"keyword\"}}},\"sex\":{\"type\":\"keyword\"}," +
                "\"age\":{\"type\":\"integer\"}, \"desc\":{\"type\":\"text\", \"analyzer\":\"ik_smart\", \"search_analyzer\":\"ik_smart\"}}}";

        //SONObject.parseObject 方法是用于将字符串类型的 JSON 数据转换为 Java 的 HashMap 类型的数据。(com.alibaba.fastjson.JSONObject)
        Map mappings = JSONObject.parseObject(mappingStr, Map.class);
        System.out.println("mappings--->" + mappings);
        request.mapping(mappings);


        // 添加settings，对比上述结构来理解
        request.settings(Settings.builder().put("index.number_of_shards", 3)
                                            .put("index.number_of_replicas", 1));



        //设置索引的别名
        request.alias(new Alias("china_user"));


        //同步方式发送请求
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

        //处理响应
        boolean acknowledged = createIndexResponse.isAcknowledged();

        boolean shardsAcknowledged = createIndexResponse
                .isShardsAcknowledged();

        System.out.println("acknowledged = " + acknowledged);
        System.out.println("shardsAcknowledged = " + shardsAcknowledged);

        //client.close();
    }




    /*
    * 作用：删除索引
    * delete /user
    */
    public static void deleteIndex(String indexName) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);

        AcknowledgedResponse acknowledgedResponse = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("acknowledged = " + acknowledgedResponse.isAcknowledged());

        //client.close();
    }

    /*
     * 作用：查看索引
     *get /user/_mapping
     */
    public static void getIndex(String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest(indexName);

        // 发送请求到ES
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);

        // 处理响应结果
        System.out.println("aliases：" + response.getAliases());
        System.out.println("mappings：" + response.getMappings());
        System.out.println("settings：" + response.getSettings());
        Set<Map.Entry<String, MappingMetaData>> entries = response.getMappings().entrySet();

        for(Map.Entry<String, MappingMetaData> entry : entries){

            MappingMetaData mappingMetaData = entry.getValue();
            Map<String, Object> sourceAsMap = mappingMetaData.getSourceAsMap();

            Set<Map.Entry<String, Object>> entries1 = sourceAsMap.entrySet();

            for (Map.Entry<String, Object> entry1 : entries1){
                System.out.println(entry1.getKey() + "--->" + entry1.getValue());
            }

            //System.out.println(entry.getKey() + "--->" + entry.getValue().);
        }



        //client.close();
    }


    public static void close() throws IOException {
        if (null != client){
            client.close();
        }
    }
}

