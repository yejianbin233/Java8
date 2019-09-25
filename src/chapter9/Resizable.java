package chapter9;/**
 * Created by Administrator on 2019/9/24.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Resizable
 * @Description TODO
 * @Date 2019/9/24 10:02
 **/
public interface Resizable extends Drawable{
    int getWidth();
    int getHeight();
    void setWidth();
    void setHeight();
    void setAbsoluteSize(int width, int height);
}
// 其他人实现了 Resizable 接口
class Game implements Resizable{

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth() {

    }

    @Override
    public void setHeight() {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }
}
