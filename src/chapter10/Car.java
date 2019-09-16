package chapter10;/**
 * Created by Administrator on 2019/9/16.
 */

import java.util.Optional;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Car
 * @Description Car class
 * @Date 2019/9/16 14:48
 **/
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
