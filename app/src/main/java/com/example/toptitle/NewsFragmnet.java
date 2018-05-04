package com.example.toptitle;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/5/5.
 */

public class NewsFragmnet extends Fragment{
    private String TAG = getClass().getSimpleName();


    private int hashCode = this.hashCode();


    private  int hashCode1=getClass().hashCode();


    @Override
    public void onAttach(Context context) {


        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);


        View view = inflater.inflate(R.layout.layout_new_frag, container, false);

        TextView textView= (TextView) view.findViewById(R.id.textView);

        textView.setText(hashCode+"");

        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onStart();
    }

    @Override
    public void onResume() {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onResume();
    }

    @Override
    public void onPause() {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onPause();
    }

    @Override
    public void onStop() {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        String Method = Thread.currentThread().getStackTrace()[2].getMethodName();
        printlog(Method);
        super.onDetach();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }


    private void printlog(String method) {


        Log.i(TAG, "==hashcode==" + hashCode + "===method===" + method);

    }
}
