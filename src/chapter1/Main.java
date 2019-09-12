package chapter1;/**
 * Created by Administrator on 2019/9/12.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Main
 * @Description chapter1 main run demo
 * @Date 2019/9/12 11:20
 **/
public class Main {

    /*
     * @author yejianbin
     * @Description 筛选苹果库存里的所有绿色苹果
     * @Date 2019/9/12 11:24
     * @Param [inventory]
     * @return java.util.List<chapter1.Apple>
     **/
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 不同点
            if ("green".equals(apple.getColor())) {
            //
                result.add(apple);
            }
        }
        return result;
    }

    /*
     * @author yejianbin
     * @Description 筛选苹果库存里的所有重量超过 150 的苹果
     * @Date 2019/9/12 11:28
     * @Param [inventory]
     * @return java.util.List<chapter1.Apple>
     **/
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 不同点
            if (apple.getWeight() > 150) {
            //
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * ===================================================================
     * 1. 从这两个方法中可以发现，除了被标注了不同点的地方外，其他代码都是一致的。
     * 2. 在此处可以利用参数化编程，将不同的"筛选条件"代码通过参数来传递，
     *    使之可以灵活的通过改变参数来改变方法内部的筛选条件，减少重复代码。
     * ===================================================================
     */
    /*
     * @author yejianbin
     * @Description 参数化的苹果筛选方法，可以通过传递各种苹果筛选条件的"方法引用"来筛选苹果
     * @Date 2019/9/12 11:40
     * @Param [inventory, p]
     * @return java.util.List<chapter1.Apple>
     *
     * Predicate<Apple> 说明 - Predicate 是一个函数式接口，传递的参数方法会替代 Predicate 中的 test() 执行
     **/
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 使用 Predicate 的 test() 方法
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    // 使用行为参数化，传递"方法引用"
//    public static void main(String[] args) {
//        List<Apple> apples = new ArrayList<>();
//        for (int i=0;i<100;i++) {
//            apples.add(Apple.builder());
//        }
//        // 在此处使用各种筛选方法替换 -> filterApples(apples,Apple::isGreenApple)
//        // 挑选所有绿色苹果
//        List<Apple> greenApples = filterApples(apples,Apple::isGreenApple);
//        System.out.println("greenApple size =" + greenApples.size());
//        for (int i=0;i<greenApples.size();i++) {
//            System.out.println(greenApples.get(i).getColor());
//        }
//
//        // 挑选所有重量超过 150 的苹果
//        List<Apple> heavyApples = filterApples(apples,Apple::isHeavyApple);
//        System.out.println("heavyApple size =" + heavyApples.size());
//        for (int i=0;i<heavyApples.size();i++) {
//            System.out.println(heavyApples.get(i).getWeight());
//        }
//    }

    // 除了通过行为参数化来传递方法引用外，还可以使用 Lambda 表达式
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        for (int i=0;i<100;i++) {
            apples.add(Apple.builder());
        }

        List<Apple> greenApples = filterApples(apples,(apple) -> "green".equals(apple.getColor()));
        System.out.println("heavyApple size =" + greenApples.size());
        for (int i=0;i<greenApples.size();i++) {
            System.out.println(greenApples.get(i).getColor());
        }

        List<Apple> heavyApples = filterApples(apples,(apple) -> apple.getWeight() > 150);
        System.out.println("heavyApple size =" + heavyApples.size());
        for (int i=0;i<heavyApples.size();i++) {
            System.out.println(heavyApples.get(i).getWeight());
        }
    }
}
