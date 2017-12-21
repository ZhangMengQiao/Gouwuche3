package mvpframework.bwie.com.gouwuche3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

import mvpframework.bwie.com.gouwuche3.adapter.ElvAdapter;
import mvpframework.bwie.com.gouwuche3.bean.GetCart;
import mvpframework.bwie.com.gouwuche3.bean.PriceAndCount;
import mvpframework.bwie.com.gouwuche3.prestener.ShangpinPrestener;
import mvpframework.bwie.com.gouwuche3.view.ISecondListener;

public class SecondActivity extends AppCompatActivity implements ISecondListener, View.OnClickListener {
    private ExpandableListView mElv;
    /**
     * 全选
     */
    private CheckBox mCb;
    /**
     * 合计：
     */
    private TextView mTvTotal;
    /**
     * 去结算(0)
     */
    private TextView mTvCount;
    private ShangpinPrestener shangpinPrestener;
    private ElvAdapter elvAdapter;
    private PriceAndCount priceAndCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        shangpinPrestener = new ShangpinPrestener(this);
        shangpinPrestener.getCart();
        mCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elvAdapter.AllOrNone(mCb.isChecked());
            }
        });
    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCb = (CheckBox) findViewById(R.id.cb);
        mTvTotal = (TextView) findViewById(R.id.tvTotal);
        mTvCount = (TextView) findViewById(R.id.tvCount);
       /*mTvCount.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,ConfirmActivity.class);
                if(priceAndCount!=null){
                    intent.putExtra("money",priceAndCount.getPrice()+"");

                }
                startActivity(intent);
            }
        }); */
        //mTvCount.setOnClickListener(this);
    }

    @Override
    public void show(List<GetCart.DataBean> group, List<List<GetCart.DataBean.ListBean>> child) {
        elvAdapter = new ElvAdapter(SecondActivity.this, group, child);
        mElv.setGroupIndicator(null);
        mElv.setAdapter(elvAdapter);
        for (int i = 0; i < group.size(); i++) {
            mElv.expandGroup(i);

        }
    }

    public void setPriceAndCount(PriceAndCount priceAndCount) {
        this.priceAndCount = priceAndCount;
        mTvTotal.setText("合计：" + priceAndCount.getPrice());
        mTvCount.setText("去结算(" + priceAndCount.getCount() + ")");

    }

    public void setAllChecked(boolean bool) {
        mCb.setChecked(bool);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
           /* case R.id.tvCount:
                break;*/
        }
    }
}
