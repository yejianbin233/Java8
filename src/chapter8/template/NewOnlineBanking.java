package chapter8.template;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName NewOnlineBanking
 * @Description TODO
 * @Date 2019/9/23 11:27
 **/
public class NewOnlineBanking extends OnlineBanking{
    @Override
    void makeCustomerHappy(Customer c) {
        System.out.println("New makeCustomerHappy()...");
    }
}
