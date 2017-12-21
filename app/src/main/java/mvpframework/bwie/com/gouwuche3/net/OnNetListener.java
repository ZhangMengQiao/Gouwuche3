package mvpframework.bwie.com.gouwuche3.net;

/**
 * 张梦乔创建于 2017/12/21.
 * 9:05
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onFaliure(Exception e);
}
