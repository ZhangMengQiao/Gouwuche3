package mvpframework.bwie.com.gouwuche3.model;

import java.util.Map;

import mvpframework.bwie.com.gouwuche3.bean.AddcartBean;
import mvpframework.bwie.com.gouwuche3.bean.GetCart;
import mvpframework.bwie.com.gouwuche3.bean.ShangpinBean;
import mvpframework.bwie.com.gouwuche3.net.OnNetListener;

/**
 * 张梦乔创建于 2017/12/21.
 * 9:32
 */

public interface IShangpinModel {
    public void doPost(Map<String,String> params, OnNetListener<ShangpinBean> onNetListener);
    public void doAdd(Map<String,String> params, OnNetListener<AddcartBean> onNetListener);
    public void GetCart(Map<String,String> params, OnNetListener<GetCart> onNetListener);
}
