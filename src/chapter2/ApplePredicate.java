package chapter2;

import chapter1.Apple;

/**
 * Created by Administrator on 2019/9/12.
 */

// 该接口与第一章节行为参数化使用的 Predicate 类似，不过却是利用策略模式来实现不同的筛选方法
public interface ApplePredicate {
    boolean test(Apple apple);
}
