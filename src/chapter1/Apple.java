package chapter1;/**
 * Created by Administrator on 2019/9/12.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Apple
 * @Description 苹果类
 * @Date 2019/9/12 11:17
 **/
public class Apple {
    private String color;
    private int weight;

    // =========== filter method =============
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }
    // =======================================

    // 创建随机颜色且重量在 [100,200]的苹果
    public static Apple builder(){
        Map<Integer,String> colors = getAppleColorMap();
        Random random = new Random();
        return new Apple(colors.get(random.nextInt(7)),random.nextInt(100)+100);
    }

    private static Map<Integer,String> getAppleColorMap(){
        Map<Integer,String> result = new HashMap<>();
        result.put(1,"black");
        result.put(2,"blue");
        result.put(3,"green");
        result.put(4,"purple");
        result.put(5,"yellow");
        result.put(6,"red");
        result.put(7,"rainbow");
        return result;
    }
    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
