package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import java.io.IOException;

public class HdfsUtils {
    private static FileSystem fileSystem;//FileSystem是java操作HDFS的客户端对象

    static  {
        Configuration configuration;
        configuration = new Configuration();//用来对core-site.xml hdfs-site.xml进行配置
        configuration.set("fs.defaultFS", "hdfs://localhost:8020");  //连接hdfs的地址
        configuration.set("dfs.replication","1");//设置上传文件的副本集

        //不设置fs.hdfs.impl（core-site中的配置）， 会报错： No FileSystem for scheme "hdfs"
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        try {
            fileSystem = FileSystem.get(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建hdfs目录
     */
    public void hdfsMkdirs(String pathString) throws IOException {
        System.out.println("\n-------------------------- 创建hdfs目录   -------------------------- ");
        boolean res = fileSystem.mkdirs(new Path(pathString));

        System.out.println( pathString + ((res == true) ? " 目录创建成功" : " 目录创建失败"));

    }

    /**
     * 删除hdfs目录或文件
     */
    public void hdfsDelete(String pathString) throws IOException {
        System.out.println("\n-------------------------- 删除hdfs目录   -------------------------- ");
        boolean res = fileSystem.delete(new Path(pathString), true);///参数1:目录路径  参数2:是否递归删除

        System.out.println( pathString + ((res == true) ? " 目录删除成功" : " 目录删除失败"));

    }

    /**
     * 上传本地文件到hdfs
     * srcPathString：本地文件路径
     * dstPathString：hdfs文件路径
     */
    public void hdfsPut(String srcPathString, String dstPathString) throws IOException {
        System.out.println("\n-------------------------- 上传本地文件到hdfs   -------------------------- ");

        fileSystem.copyFromLocalFile(new Path(srcPathString), new Path(dstPathString));
    }

    /**
     * 下载hdfs文件到本地
     * srcPathString：hdfs文件路径
     * dstPathString：本地文件路径
     */
    public void hdfsGet(String srcPathString, String dstPathString) throws IOException {
        System.out.println("\n-------------------------- 下载hdfs文件到本地   -------------------------- ");
        fileSystem.copyToLocalFile(new Path(srcPathString), new Path(dstPathString));
    }


    /**
     * 列出目录存在的文件
     */
    public void hdfsLs(String pathString) throws IOException, InterruptedException {
        System.out.println("\n----------------------- 列出目录存在的文件   ----------------------- ");
        Path path = new Path(pathString);
        Thread.sleep(2000);
        RemoteIterator<LocatedFileStatus> files= fileSystem.listFiles(path, false);

        while (files.hasNext()){
           LocatedFileStatus next= files.next();
            System.out.println(next.getPath());
        }

    }
}
