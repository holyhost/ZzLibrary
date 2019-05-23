package com.zxyoyo.apk.zzlibrary;

import android.content.Context;

public class FormPresenter implements FormContract.Presenter {

    private Context context;
    private FormContract.View view;

    public FormPresenter(Context context, FormContract.View view) {
        this.context = context;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void loadData(boolean clear) {

    }

    @Override
    public void start(boolean clear) {

    }
}
