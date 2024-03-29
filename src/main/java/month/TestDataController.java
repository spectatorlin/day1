package month;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
 
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class TestDataController {
 
    /**
     *  快速添加一千万条测试数据
     * @param args
     */
    public  static void main(String[] args){
 
        String sql = "INSERT INTO user_data(id,attr1) VALUES(%s,'CSDN臭弟弟测试数据');";
        System.out.println(String.format(sql, IdWorker.getId()));
        String path="F:\\testData.sql";
        File file=new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            //BufferedOutputStream是Java中一个用于输出字节流的缓冲区类。
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path)) ;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                //写数据  IdWorker是一个Java类，该方法返回一个long类型的ID。
                bos.write(String.format(sql, IdWorker.getId()).getBytes());
                if(i<10000000-1){
                    bos.write("\n".getBytes());
                }
            }
 
            long endTime = System.currentTimeMillis();
            System.out.println("一千万条测试数据耗时:" + (endTime - startTime));
 
            //释放资源
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}