package chapter8.factory;/**
 * Created by Administrator on 2019/9/23.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName ProductFactory
 * @Description 简单工厂模式
 * @Date 2019/9/23 17:48
 **/
public class ProductFactory {
    final static Map<String,Supplier<Product>> map = new HashMap<>();
    public static Product createProduct(String name) throws Exception {
        switch (name){
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default : throw new Exception();
        }
    }

    static {
        map.put("loan",Loan::new);
        map.put("stock",Stock::new);
        map.put("bond",Bond::new);
    }
    public static Product createProductLam(String name) throws Exception {

        Supplier<Product> p = map.get(name);

        if (p != null)
            return p.get();
        throw new Exception();
    }
}
