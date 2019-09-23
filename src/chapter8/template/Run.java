package chapter8.template;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Run
 * @Description TODO
 * @Date 2019/9/23 11:26
 **/
public class Run {
    public static void main(String[] args) {
        // 普通的模板方法
//        OnlineBanking banking = new NewOnlineBanking();
//        banking.processCustomer(1);

        // Lambda 表达式模板方法
        new OnlineBankingLam().processCustomer(1,(Customer c) -> System.out.println("New Lambda use..."));
    }
}
