package chapter5;/**
 * Created by Administrator on 2019/9/19.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName FindAndMatchDemo
 * @Description 查找和匹配 demo
 * @Date 2019/9/19 11:37
 **/
public class FindAndMatchDemo {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("apple11", 11));
        fruits.add(new Fruit("peach", 11));
        fruits.add(new Fruit("banana", 10));

        System.out.println("===========================");

//        boolean result = fruits.stream().anyMatch(f -> {
//            System.out.println(f.toString());
//            return f.getPrice() == 10;
//        }); // 具有短路功能

//        boolean result = fruits.stream().allMatch(f -> {
//            System.out.println(f.toString());
//            return f.getPrice() == 10;
//        }); // 具有短路功能

//        boolean result = fruits.stream().noneMatch(f -> {
//            System.out.println(f.toString());
//            return f.getPrice() == 00;
//        });// 具有短路功能

//        Optional<Fruit> result = fruits.stream().findAny();
//        System.out.println(result.get().toString());// 只会获取流中的第一个元素，不是随机

//        Optional<Fruit> result = fruits.stream().findFirst(); // 获取流第一个元素
//        //ps：findAny() 和 findFirst () 效果一样，这很奇怪（为什么 findAny 不是随机？）...
        /*
        * 在我的理解，findAny() 方法是随机的，可是 Stream 的执行顺序是按照 Stream 内的第一个元素进行操作，
        * 而 findAny() 是只要 Stream 中存在元素即可满足条件，直接返回该元素。
        * 这就是 findAny() 与 findFirst() 结果一致的原因。
        * 可是，为什么 findAny 不随机返回一个呢？我个人感觉 findAny 的语义就是返回任意一个，每个都是随机的...
        * */

//        int result = fruits.stream().map(f -> f.getPrice())
//                .reduce(0, (a,b) -> a + b);// reduce -> 求和

//        Optional result = fruits.stream().map(f -> f.getPrice())
//                .reduce((x,y) -> x > y ? x : y);// 最大值

//        Optional result = fruits.stream().map(f -> f.getPrice())
//                .reduce(Integer::min);// 最小值

//        fruits.stream().forEach(f -> System.out.println(f.getName()));
//        int result = (int) fruits.stream().count();

//        List<Fruit> result = fruits.stream().sorted(comparing(fruit -> fruit.getPrice())).collect(toList());

        System.out.println(result);
    }

    public static class Fruit {
        private String name;
        private Integer price;

        public Fruit(String name, Integer price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Fruit{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
