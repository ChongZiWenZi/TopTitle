package com.example.toptitle;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    RadioGroup rgChannel;
    HorizontalScrollView hvChannel;
    ViewPager vpNewsList;

    private FragPageAdapter adaper;



    private String[] titles = {"头条", "娱乐", "军事", "美女", "新闻", "好声音", "明星", "KTV"};

    private List<Fragment> fragmentList;

    private boolean[] fragmentsUpdateFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initTab();

        initViewPage();
    }

    private void initView() {
        rgChannel = (RadioGroup) findViewById(R.id.rgChannel);
        hvChannel = (HorizontalScrollView) findViewById(R.id.hvChannel);
        vpNewsList = (ViewPager) findViewById(R.id.vpNewsList);


        rgChannel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                vpNewsList.setCurrentItem(i);

            }
        });


        vpNewsList.setOnPageChangeListener(this);
    }

    private void initTab() {
        fragmentsUpdateFlag = new boolean[titles.length];
        for (int i = 0; i < titles.length; i++) {
            fragmentsUpdateFlag[i] = false;
            RadioButton radioButton = (RadioButton)
                    LayoutInflater.from(this).inflate(R.layout.tab_rb, null);
            radioButton.setId(i);
            radioButton.setText(titles[i]);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);

            rgChannel.addView(radioButton, params);

            rgChannel.check(0);
        }
    }


    private void initViewPage() {

        fragmentList = new ArrayList<>(titles.length);

        for (int i = 0; i < titles.length; i++) {

            NewsFragmnet fragmnet = new NewsFragmnet();


            Bundle bundle = new Bundle();
            bundle.putString("name" + i, titles[i]);

            fragmnet.setArguments(bundle);

            Log.i("DaohHangActivity", fragmnet.hashCode() + "");

            fragmentList.add(fragmnet);


        }

        adaper = new FragPageAdapter(getSupportFragmentManager(), fragmentList);

        //statePageAdapter = new FragStatePageAdapter(getSupportFragmentManager(), fragmentList);

        vpNewsList.setAdapter(adaper);

    }

    /**
     * getMeasuredWidth:包括隐藏的长度
     * 滑动ViewPager时调整ScroollView的位置以便显示按钮
     */
    private void setTab(int index) {

        RadioButton radioButton = (RadioButton) rgChannel.getChildAt(index);

        radioButton.setChecked(true);

        int left = radioButton.getLeft();//视图左侧的位置
        int width = radioButton.getMeasuredWidth();//包含被隐藏的位置

        DisplayMetrics metrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //将当前窗口的一些信息放在DisplayMetrics类中

        int screenWidth = metrics.widthPixels;
        int len = left + width / 2 - screenWidth / 2;//控件放到中间

        hvChannel.smoothScrollTo(len, 0);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {




    }

    @Override
    public void onPageSelected(int i) {

        setTab(i);

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

}
