package hdfs;

import java.io.IOException;

public class HdfsTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("--------- main函数开始 -------");
        Thread.sleep(1000);
        HdfsUtils hdfsUtils = new HdfsUtils();
        hdfsUtils.hdfsMkdirs("/books");
        hdfsUtils.hdfsDelete("/books");
        hdfsUtils.hdfsPut("/tmp/book1", "/books/book1");
        hdfsUtils.hdfsGet("/books/book1", "/tmp/book1_back");
        hdfsUtils.hdfsLs("/books");
    }
}
