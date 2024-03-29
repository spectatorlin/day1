package month;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class two {
    public static void main(String[] args) {
        String s1="a";
        String s2="b";
        String s3="ab";
        String s4=s1+s2;
        String s5="a"+"b";
        Object o = new Object();
        System.out.println(s3==s4);
        System.out.println(s5==s4);
        System.out.println(s4);
        System.out.println(s3==s5);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1,1);
        concurrentHashMap.get(1);
        HashMap hashMap = new HashMap();

    }
}
