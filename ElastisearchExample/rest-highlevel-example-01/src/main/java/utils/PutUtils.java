package utils;

import com.alibaba.fastjson.JSONObject;
import entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.List;

public class PutUtils {
    private static RestHighLevelClient client;

    static {
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
    }

    private PutUtils(){

    }

    //添加数据
    public static void putAddData(String indexName, String id, User user) throws Exception{
        // 2、创建请求对象
        //User user = new User();
        //user.setName("张一");
        //user.setSex("男");
        //user.setAge(10);

        // 定义请求对象
        IndexRequest request = new IndexRequest(indexName).type("_doc");

        // 设置文档id
        request.id(id);

        // 将json格式字符串放在请求中
        request.source(JSONObject.toJSONString(user), XContentType.JSON);

        //发送请求到ES
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        System.out.println("数据插入结果：" + response.getResult());

    }

    //批量添加数据
    //添加数据
    public static void bulkAddData(String indexName, String startId, List<User> userList) throws Exception{
        // 定义请求对象
        BulkRequest bulkRequest = new BulkRequest();


        for (User user : userList){
            bulkRequest.add(new IndexRequest(indexName).type("_doc").id(startId).source(JSONObject.toJSONString(user), XContentType.JSON));
            startId = String.valueOf(Integer.valueOf(startId) + 1);
        }


        //发送请求到ES
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("bulkAddData status:" + bulk.status());


    }

    //局部更新数据
    public static void updateData(String indexName, String id) throws Exception{
        // 定义请求对象
        UpdateRequest updateRequest = new UpdateRequest().index(indexName).type("_doc").id(id);

        updateRequest.doc(XContentType.JSON, "name","谢四_update", "age", 45);

        //发送请求到ES
        UpdateResponse update = client.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println("updateData status:" + update.status());

    }




    public static void close() throws IOException {
        if (null != client){
            client.close();
        }
    }
}
