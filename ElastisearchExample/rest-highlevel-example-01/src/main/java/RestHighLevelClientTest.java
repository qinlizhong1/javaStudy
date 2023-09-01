import entity.User;
import utils.IndexUtils;
import utils.PutUtils;
import utils.SearchUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class RestHighLevelClientExample{
    public void testIndex() throws IOException {
        System.out.println("------------------------- testIndex -------------------------");
        IndexUtils.addIndex("user");
        IndexUtils.getIndex("user");
        IndexUtils.deleteIndex("user");
    }

    public void testPut() throws Exception {
        System.out.println("\n\n------------------------- testPut -------------------------");
        //新增user索引
        IndexUtils.addIndex("user");

        PutUtils.putAddData("user", "1", new User("张一", "男", 10, "中国北京市朝阳区"));
        PutUtils.putAddData("user", "2", new User("李二", "男", 20,"中国湖南省长沙市"));

        //批量添加数据
        User user1 = new User("王三(美国华尔街)", "男", 30, "中国湖南省邵阳市");
        User user2 = new User("谢四", "女", 40, "美国旧金山");
        User user3 = new User("麻五", "女", 50, "美国东北大学");
        User user4 = new User("曾六", "男", 60, "中国东北大学");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        PutUtils.bulkAddData("user", "3", userList);
        PutUtils.updateData("user", "4");

        //删除索引，为后续测试清理环境数据
        //IndexUtils.deleteIndex("user");

    }

    public void testGet() throws Exception {
        System.out.println("\n\n------------------------- testGet -------------------------");
        SearchUtils.getMatchAll("user");
        SearchUtils.getTerm("user", "sex", "女");
        SearchUtils.getMatch("user", "desc", "中国");
        SearchUtils.getMultiMatch("user", new String[]{"name", "desc"}, "美国");
        SearchUtils.getRange("user", "age", 40 ,50);

    }
}

public class RestHighLevelClientTest {
    public static void main(String[] args) throws Exception {
        RestHighLevelClientExample restHighLevelClientExample = new RestHighLevelClientExample();
        //restHighLevelClientExample.testIndex();
        //restHighLevelClientExample.testPut();
        restHighLevelClientExample.testGet();

    }
}
