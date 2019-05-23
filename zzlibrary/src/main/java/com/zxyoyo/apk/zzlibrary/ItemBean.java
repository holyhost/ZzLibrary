package com.zxyoyo.apk.zzlibrary;

public class ItemBean {
    //item left showing name key
    private String nameKey="";
    // item right showing editView key
    private String editKey="";
    // item left showing text value
    private String nameValue="";
    // item right editView text value
    private String editValue="";
    // item can be edit or not
    private boolean editable = false;
    private int inputType=0;

    public ItemBean() {

    }

    public ItemBean(String nameValue, String editValue) {
        this.nameValue = nameValue;
        this.editValue = editValue;
    }

    public ItemBean(String nameValue, String editValue, boolean editable) {
        this.nameValue = nameValue;
        this.editValue = editValue;
        this.editable = editable;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public String getEditKey() {
        return editKey;
    }

    public void setEditKey(String editKey) {
        this.editKey = editKey;
    }

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public String getEditValue() {
        return editValue;
    }

    public void setEditValue(String editValue) {
        this.editValue = editValue;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getInputType() {
        return inputType;
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
    }
}
