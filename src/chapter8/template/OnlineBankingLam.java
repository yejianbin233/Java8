package chapter8.template;/**
 * Created by Administrator on 2019/9/23.
 */

import java.util.function.Consumer;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName OnlineBankingLam
 * @Description 在线银行 Lambda 表达式
 * @Date 2019/9/23 11:29
 **/
public class OnlineBankingLam {
    // 算法骨架，现在已经不需要子类了，直接在参数上传递特定步骤的算法就可以不影响算法骨架的同时改变特定步骤的算法
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy){
        Customer c = Database.getCustomerWithId(1);
        makeCustomerHappy.accept(c);
    }
}
