package chapter2;/**
 * Created by Administrator on 2019/9/12.
 */

import chapter1.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Main
 * @Description chapter 2 main run
 * @Date 2019/9/12 15:47
 **/
public class Main<T> {

    // 普通的实现方式，不易扩展
    // 挑选绿色的苹果
    public static List<Apple> getGreenApples(List<Apple> apples){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 直接复制上面的 getGreenApples() 方法的代码,仅修改筛选条件 - green -> red
    public static List<Apple> getRedApples(List<Apple> apples){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : apples) {
            // 变化 green -> red
            if ("red".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    // 其他条件的实现 - 根据筛选/根据颜色和重量筛选...
    // 说明：以上的需求,仅仅是筛选条件的变化(且需求类似,可扩展 - 黑苹果、蓝苹果...)。
    // 如果每一次需求的变更都需要创建一个方法,会增加类的阅读难度,并且会有大量的重复代码、相似 API。

    // =====================================================================

    // 一个良好的原则是 - 在编写类似的代码之后,尝试将其"抽象化"。
    // 以筛选的颜色作为示例：将筛选条件 - 颜色,变成一个参数,以适应筛选条件颜色的变化。

    public static List<Apple> filterApplesByColor(List<Apple> apples,String color){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 说明：类似代码抽象化仅能适应单一且类似的业务逻辑实现抽象化,如果需求再变更且更复杂,就不能很好地应对变化的需求了。
    // 例如 - 在筛选颜色的同时也要挑出重量大于 150 g 的苹果

    // ========================================================================

    // 行为参数化 - 定义更高层次的抽象
    // 定义苹果筛选方法
    public static List<Apple> filterApplesByColor(List<Apple> apples,ApplePredicate p){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        List<Apple> apples = new ArrayList<>();
//        for (int i=0;i<100;i++) {
//            apples.add(Apple.builder());
//        }
//        List<Apple> result = filterApplesByColor(apples,new AppleGreenColorPredicate());
//    }

    /*
    * ps：上面的例子使用了"策略模式" - 定义了算法家族 - ApplePredicate 并封装其实现,通过修改 ApplePredicate 的实现类来调用不同的行为,且不会影响到客户的使用。
    * 说明：根据行为参数化的定义, 通过传递不同的 ApplePredicate 实现类, filterApplesByColor 会用不同的行为(因为只能接受对象,否则可以通过传递代码来实现)。
    * 这种模式有一个缺点 - 需要根据需求定义很多不同的实现类,可以通过以下方式优化：
    * 1. 匿名内部类
    * 2. Lambda 表达式
    * */

    // 匿名内部类实现
//    public static void main(String[] args) {
//        List<Apple> apples = new ArrayList<>();
//        for (int i=0;i<100;i++) {
//            apples.add(Apple.builder());
//        }
//
//        List<Apple> result = filterApplesByColor(apples,new AppleGreenColorPredicate(){
//            public boolean test(Apple apple){
//                return "red".equals(apple.getColor());
//            }
//        });
//    }

    // Lambda 表达式实现
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        for (int i=0;i<100;i++) {
            apples.add(Apple.builder());
        }
        List<Apple> result = filterApplesByColor(apples,(Apple apple) -> "red".equals(apple.getColor()));
    }

    // 更通用 - 将类型抽象化
    // 使用泛型,将类型抽象化以更通用的方式解决类似业务逻辑的需求。
    public List<T> filterApplesByColor(List<T> list,Predicate<T> p){
        List<T> result = new ArrayList<T>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
