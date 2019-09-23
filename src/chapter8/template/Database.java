package chapter8.template;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Database
 * @Description 数据源
 * @Date 2019/9/23 11:23
 **/
public class Database {
    public static Customer getCustomerWithId(int id){
        System.out.println("database user.");
        return new Customer();
    }
}
