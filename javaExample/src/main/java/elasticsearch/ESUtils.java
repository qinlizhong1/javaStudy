package elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.cluster.metadata.AliasMetaData;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class ESUtils {
    private static RestHighLevelClient restHighLevelClient;

    static {
        RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
        restHighLevelClient  = new RestHighLevelClient(restClientBuilder);
        System.out.println("--------------- connect es success  ---------------");
    }

    public static RestHighLevelClient getRestHighLevelClient(){
        return restHighLevelClient;
    }

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
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("animal");

        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse.index());
        System.out.println(createIndexResponse.isAcknowledged());
    }

    /**
     *删除ES中存在的指定索引
     */
    public void indexDelete() throws IOException {
        System.out.println("\n-------------------------- 删除索引   -------------------------- ");

        AcknowledgedResponse acknowledgedResponse =
                restHighLevelClient.indices().delete(new DeleteIndexRequest("animal"), RequestOptions.DEFAULT);

        System.out.println(acknowledgedResponse.isAcknowledged());
    }
}
