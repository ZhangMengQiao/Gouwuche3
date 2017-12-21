package mvpframework.bwie.com.gouwuche3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //创建属性动画
        ObjectAnimator a1=ObjectAnimator.ofFloat(mIv, "translationY",-500f, 500);
        ObjectAnimator a2=ObjectAnimator.ofFloat(mIv,"rotation", 0f, 360f);
        ObjectAnimator a3=ObjectAnimator.ofFloat(mIv, "alpha", 0f, 1f);
        ObjectAnimator a4=ObjectAnimator.ofFloat(mIv, "scaleX", 2f, 1f);
        ObjectAnimator a5 = ObjectAnimator.ofFloat(mIv, "scaleY", 2f, 1f);
        //创建动画集合
        AnimatorSet set=new AnimatorSet();
        //设置播放时间
        set.setDuration(3000);
        //一起播放
        set.playTogether(a1,a2,a3,a4,a5);
        //开始
        set.start();
        //设置监听
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //结束后跳转
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
    }
}
