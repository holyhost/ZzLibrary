package com.zxyoyo.apk.zzlibrary;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * time:2019/5/20
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 **/
public class FormFragment extends BaseFragment {

    private LinearLayout ll_parent;
    private List<ItemBean> mDatas;



    public static FormFragment getInstance(){
        return new FormFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_form;
    }

    @Override
    public void finishCreateView(Bundle state) {
        initViews(parentView);
        List<ItemBean> list = new ArrayList<>();
        list.add(new ItemBean("姓名","小明1",true));
        list.add(new ItemBean("姓名","小明2",true));
        list.add(new ItemBean("姓名","小明3",false));
        list.add(new ItemBean("姓名","小明4",false));
        list.add(new ItemBean("姓名","小明5",false));
        list.add(new ItemBean("姓名","小明36",false));
        list.add(new ItemBean("姓名","小明37",false));
        list.add(new ItemBean("姓名","小明38",false));
        list.add(new ItemBean("姓名","小明39",false));
        list.add(new ItemBean("姓名","小明30",false));
        list.add(new ItemBean("姓名","小明320",false));
        list.add(new ItemBean("姓名","小明310",false));
        showResult(list);

    }

    @Override
    protected void loadData() {
        //init  form data

    }



    public void showMessage(String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public void showResult(List<ItemBean> data) {
        if(null == data||data.size()<1) return;
        if(getContext() == null){
            LogUtil.e("FormFragment","getcontext = null ----------------");
            return;
        }
        for(ItemBean bean:data){
            ZzItemView itemView = new ZzItemView(getContext(),bean);
            ll_parent.addView(itemView);
        }
        ll_parent.invalidate();
    }


    private void initViews(View view) {
        // init views
        ll_parent = view.findViewById(R.id.ll_parent);
    }



}
