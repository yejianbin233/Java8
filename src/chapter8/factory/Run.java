package chapter8.factory;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Run
 * @Description
 * @Date 2019/9/23 17:51
 **/
public class Run {
    public static void main(String[] args) throws Exception {
        Product loan = ProductFactory.createProduct("loan");
        Product stock = ProductFactory.createProduct("stock");
        Product bond = ProductFactory.createProduct("bond");

        Product lamProduct = ProductFactory.createProductLam("loan");
    }
}
