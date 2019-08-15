package xyz.sdju.community;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: duzi55
 * @date: 2019-08-11 13:21
 */
public class JavaTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        //1.张三 1222  2.李四 172727  3.王五 18888
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("理光");
        list.add("商友");
//        list.remove(2);
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(i+"."+list.get(i)+"  ");
        }

    }
}
