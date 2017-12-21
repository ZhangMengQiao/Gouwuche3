package mvpframework.bwie.com.gouwuche3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import mvpframework.bwie.com.gouwuche3.bean.ShangpinBean;
import mvpframework.bwie.com.gouwuche3.prestener.ShangpinPrestener;
import mvpframework.bwie.com.gouwuche3.view.IShangpinView;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener, IShangpinView {
    private ImageView mIv;
    private TextView mTvBargainPrice;
    private TextView mTvPrice;
    /**
     * 购物车
     */
    private TextView mTvCart;
    /**
     * 加入购物车
     */
    private TextView mTvAddCart;

    private ShangpinPrestener shangpinPrestener;
    /**
     * 123
     */
    private TextView mJiaqian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        shangpinPrestener = new ShangpinPrestener(this);
        shangpinPrestener.doPost();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
        mTvBargainPrice = (TextView) findViewById(R.id.tvBargainPrice);
        mTvBargainPrice.setOnClickListener(this);
        mTvPrice = (TextView) findViewById(R.id.tvPrice);
        mTvPrice.setOnClickListener(this);
        mTvCart = (TextView) findViewById(R.id.tvCart);
        mTvCart.setOnClickListener(this);
      //  mTvAddCart = (TextView) findViewById(R.id.tvAddCart);
      //  mTvAddCart.setOnClickListener(this);
        mJiaqian = (TextView) findViewById(R.id.jiaqian);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tvCart:
                Intent intent = new Intent(ShowActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
           /* case R.id.tvAddCart:
                shangpinPrestener.addCart();
                break;*/
        }
    }

    @Override
    public void show(ShangpinBean shangpinBean) {
        String images = shangpinBean.getData().getImages();
        String[] split = images.split("\\|");
        Glide.with(this).load(split[0]).into(mIv);

        mTvBargainPrice.setText( shangpinBean.getData().getTitle());
        mTvPrice.setText(  shangpinBean.getData().getSubhead());
        mJiaqian.setText("￥"+shangpinBean.getData().getPrice()+"");
    }

    @Override
    public void addShwo(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
