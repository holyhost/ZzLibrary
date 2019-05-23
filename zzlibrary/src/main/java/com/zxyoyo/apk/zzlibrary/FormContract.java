package com.zxyoyo.apk.zzlibrary;

import java.util.List;

public interface FormContract {

    interface View extends BaseView<Presenter>{
        // show some message on view,to tell user something happening
        void showMessage(String message);
        // show list result
        void showResult(List<ItemBean> data);
    }

    interface Presenter extends BasePresenter{

        // to load data ,is clear = true ,older data will be remove
        void loadData(boolean clear);
    }

}
