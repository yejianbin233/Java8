package chapter8.observer;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Guardian
 * @Description TODO
 * @Date 2019/9/23 17:04
 **/
public class Guardian implements Observer{
    @Override
    public void notify(String context) {
        System.out.println("Guardian Observer." + context);
    }
}
