package chapter8.observer;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName LeMonde
 * @Description TODO
 * @Date 2019/9/23 17:05
 **/
public class LeMonde implements Observer {
    @Override
    public void notify(String context) {
        System.out.println("LeMonde Observer." + context);
    }
}
