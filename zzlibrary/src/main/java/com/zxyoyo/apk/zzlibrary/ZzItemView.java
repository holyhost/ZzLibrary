package com.zxyoyo.apk.zzlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**

 * -----------------------
 * function describe: form item
 **/
public class ZzItemView extends LinearLayout {
    private EditText et_name;
    private TextView tv_name;
    private LinearLayout ll_root;
    private static final int INPUT_TYPE_STRING = 0;// default is string type
    private static final int INPUT_TYPE_PASSWORD = 1;// type password
    private static final int INPUT_TYPE_EMAIL = 2;//  email type
    private static final int INPUT_TYPE_NUMBER = 3;//  number type

    public ZzItemView(Context context) {
        super(context);
    }


    public ZzItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }


    private void initView(Context context,AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.layout_zz_item,this,true);

        tv_name = findViewById(R.id.tv_name);
        et_name = findViewById(R.id.et_name);
        ll_root = findViewById(R.id.ll_root);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ZzItemView);
        if(typedArray!=null && typedArray.length()>0){
            String text = typedArray.getString(R.styleable.ZzItemView_zz_item_text_name);
            String edit = typedArray.getString(R.styleable.ZzItemView_zz_item_edit_name);
            String hint = typedArray.getString(R.styleable.ZzItemView_zz_item_hint_name);
            Boolean focus = typedArray.getBoolean(R.styleable.ZzItemView_zz_item_edit_focus,false);
            Boolean clickable = typedArray.getBoolean(R.styleable.ZzItemView_zz_item_clickable,false);
            int inputType = typedArray.getInt(R.styleable.ZzItemView_zz_item_input_type,0);
            setInputType(inputType);
            int type = typedArray.getInt(R.styleable.ZzItemView_zz_item_type, 0);

            if(!TextUtils.isEmpty(text)){
                tv_name.setText(text);
            }
            if(!TextUtils.isEmpty(edit)){
                et_name.setText(text);
            }
            if(!TextUtils.isEmpty(hint)){
                et_name.setHint(hint);
            }
            if (focus){
                et_name.setFocusable(true);
                et_name.setClickable(true);
                et_name.setFocusable(true);

                et_name.setFocusableInTouchMode(true);

                et_name.requestFocus();

                et_name.findFocus();
            }
            if(clickable){
                ll_root.setOnClickListener(v -> {
                    if(listener!=null){
                        listener.onItemClick();
                    }
                });
            }

        }

    }

    public void setEditable(boolean editable){
        et_name.setClickable(editable);
        et_name.setFocusable(editable);
        et_name.setFocusableInTouchMode(editable);
    }

    public void setText(String text){
        if(et_name!=null){
            et_name.setText(text);
        }
    }

    public void setName(String name){
        tv_name.setText(name);
    }

    public boolean isEmpty(){
        if(TextUtils.isEmpty(et_name.getText().toString()))return true;
        if(TextUtils.equals(et_name.getText().toString(),"0")) return true;
        return false;
    }

    public String getText(){
        if(et_name!=null){
            return et_name.getText().toString();
        }
        return "";
    }

    private void setInputType(int type){
        switch (type){
            case INPUT_TYPE_STRING:
                et_name.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case INPUT_TYPE_PASSWORD:
                et_name.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            case INPUT_TYPE_EMAIL:
                et_name.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case INPUT_TYPE_NUMBER:
                et_name.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            default:
                    et_name.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
