package com.example.toptitle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2018/5/5.
 */

public class FragPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    private FragmentManager manager;

    private boolean[] fragmentsUpdateFlag;


    public FragPageAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
        manager = fm;

        this.fragmentsUpdateFlag = fragmentsUpdateFlag;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //得到缓存的fragment
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        //  Fragment fragment = getItem(position);
        //得到tag
        String fragmentTag = fragment.getTag();

        /*if (fragmentsUpdateFlag[position % list.size()]) {
            //如果这个fragment需要更新

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.remove(fragment);

            fragment = list.get(position % list.size());


            transaction.add(container.getId(), fragment, fragmentTag);

            transaction.attach(fragment);

            transaction.commit();

            //复位更新标志

            fragmentsUpdateFlag[position % fragmentsUpdateFlag.length] = false;


        }
*/

        return fragment;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = list.get(position % list.size());
        Log.i("=======", "getItem:position=" + position + ",fragment:"
                + fragment.getClass().getName() + ",fragment.tag="
                + fragment.getTag());

        return fragment;
    }


    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
