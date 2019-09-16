package chapter10;/**
 * Created by Administrator on 2019/9/16.
 */

import java.util.Optional;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Person
 * @Description Person class
 * @Date 2019/9/16 14:47
 **/
public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
