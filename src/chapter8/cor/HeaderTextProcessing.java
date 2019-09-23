package chapter8.cor;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName HeaderTextProcessing
 * @Description
 * @Date 2019/9/23 17:26
 **/
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        System.out.println("HeaderTextProcessing handleWork." + "  " + input);
        return null;
    }
}
