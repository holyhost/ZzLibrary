package com.zxyoyo.apk.zzlibrary;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * some utils
 */
public class ZzUtils {

    /**
     * to open or close keyboard
     * @param view
     * @param isShow
     */
    public static void toggleSoftKey(View view, boolean isShow) {
        Context context = view.getContext();
        if (context.getSystemService(Context.INPUT_METHOD_SERVICE) != null) {
            InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (isShow) {
                imm.showSoftInput(view, 0);
            } else {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

        }
    }
}
