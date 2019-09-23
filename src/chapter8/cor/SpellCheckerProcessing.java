package chapter8.cor;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName SpellCheckerProcessing
 * @Description
 **/
public class SpellCheckerProcessing extends ProcessingObject<String>{
    @Override
    protected String handleWork(String input) {
        System.out.println("SpellCheckerProcessing" + "  " + input);
        return null;
    }
}
