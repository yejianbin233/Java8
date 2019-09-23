package chapter8.template;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName OnlineBanking
 * @Description 在线银行
 * @Date 2019/9/23 11:21
 **/
public abstract class OnlineBanking {
    // 算法骨架
    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(1);
        makeCustomerHappy(c);
    }

    // 延迟到子类实现，子类可以自定义该步骤的算法
    abstract void makeCustomerHappy(Customer c);
}
