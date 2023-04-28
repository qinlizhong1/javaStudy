package elasticsearch;

import java.io.IOException;

public class ESTest {
    public static void main(String[] args) throws IOException {
        ESUtils esUtils = new ESUtils();
        esUtils.indexDelete();
        esUtils.indexCreate();
        esUtils.indexView();
    }
}
