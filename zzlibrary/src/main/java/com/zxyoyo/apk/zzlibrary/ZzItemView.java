package com.zxyoyo.apk.zzlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.Selection;
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
    private EditText et_name;//using for right input
    private TextView tv_name;// using for left text showing
    private LinearLayout ll_root;// root view of zzitemview
    private View line_view;// the item bottom line
    private ItemBean valueBean;// all value

    private static final int INPUT_TYPE_STRING = 0;// default is string type
    private static final int INPUT_TYPE_PASSWORD = 1;// type password
    private static final int INPUT_TYPE_EMAIL = 2;//  email type
    private static final int INPUT_TYPE_NUMBER = 3;//  number type

    public ZzItemView(Context context) {
        super(context);
    }

    public ZzItemView(Context context,ItemBean valueBean) {
        this(context);
        initView(context,null);
        setItemValue(valueBean);
    }


    public ZzItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }


    /**
     * init some parameter for view
     * @param context
     * @param attrs
     */
    private void initView(Context context,AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.layout_zz_item,this,true);

        tv_name = findViewById(R.id.tv_name);
        et_name = findViewById(R.id.et_name);
        ll_root = findViewById(R.id.ll_root);
        line_view = findViewById(R.id.view_split_line);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ZzItemView);
        if(typedArray!=null && typedArray.length()>0){
            String text = typedArray.getString(R.styleable.ZzItemView_zz_item_text_name);
            String edit = typedArray.getString(R.styleable.ZzItemView_zz_item_edit_name);
            String hint = typedArray.getString(R.styleable.ZzItemView_zz_item_hint_name);
            Boolean editable = typedArray.getBoolean(R.styleable.ZzItemView_zz_item_editable,false);
            Boolean clickable = typedArray.getBoolean(R.styleable.ZzItemView_zz_item_clickable,false);
            Boolean showLine = typedArray.getBoolean(R.styleable.ZzItemView_zz_item_bottom_line,true);
            int inputType = typedArray.getInt(R.styleable.ZzItemView_zz_item_input_type,0);
            setInputType(inputType);
            int type = typedArray.getInt(R.styleable.ZzItemView_zz_item_type, 0);

            if(!TextUtils.isEmpty(text)){
                tv_name.setText(text);
            }
            if(!TextUtils.isEmpty(edit)){
                et_name.setText(edit);
            }
            if(!TextUtils.isEmpty(hint)){
                et_name.setHint(hint);
                editable = true;
            }
            if (editable){
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
            if(!showLine){
                line_view.setVisibility(View.INVISIBLE);
            }

        }

    }

    /**
     *  enable right input can be input
     *  default can not be input
     * @param editable true :can input content,and false is can't
     */
    public void setEditable(boolean editable){
        if(!editable) et_name.setTextColor(Color.GRAY);
        et_name.setClickable(editable);
        et_name.setFocusable(editable);
        et_name.setFocusableInTouchMode(editable);
        ll_root.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(editable){
                        et_name.requestFocus();
                        et_name.setFocusable(true);
                        Selection.setSelection(et_name.getText(),et_name.getText().toString().length());
                    }
                    ZzUtils.toggleSoftKey(et_name,editable);

                }
        });

    }


    public void setBottomLineVisiblity(int visibility){
        if(visibility == View.VISIBLE||visibility == View.GONE||visibility == View.INVISIBLE)
        line_view.setVisibility(visibility);
    }

    /**
     *  set right input value
     * @param text input value
     */
    public void setText(String text){
        if(et_name!=null){
            et_name.setText(text);
        }
    }

    /**
     * set for left text
     * @param name left text
     */
    public void setName(String name){
        tv_name.setText(name);
    }

    /**
     *
     * @return if input has content
     * true: nothing in input \ input content is zero
     * false: input has content
     */
    public boolean isEmpty(){
        if(TextUtils.isEmpty(et_name.getText().toString()))return true;
        if(TextUtils.equals(et_name.getText().toString(),"0")) return true;
        return false;
    }

    /**
     * get input value
     * @return input value ,default is empty character ""
     */
    public String getText(){
        if(et_name!=null){
            return et_name.getText().toString();
        }
        return "";
    }

    /**
     * set input type ,default is string
     * @param type number \ string \ password \ email
     */
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

    /**
     * using for item click interface
     */
    public interface OnItemClickListener{
        void onItemClick();
    }

    /**
     * set item click listener
     */
    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ItemBean getItemValue() {
        if(null==valueBean){
            valueBean = new ItemBean();
        }
        valueBean.setEditValue(et_name.getText().toString());
        return valueBean;
    }

    public void setItemValue(ItemBean valueBean) {
        this.valueBean = valueBean;
        initItemData();
    }

    private void initItemData(){
        if(valueBean == null) return;
        tv_name.setText(null==valueBean.getNameValue()?"":valueBean.getNameValue());
        et_name.setText(null==valueBean.getEditValue()?"":valueBean.getEditValue());
        this.setEditable(valueBean.isEditable());


    }
}
