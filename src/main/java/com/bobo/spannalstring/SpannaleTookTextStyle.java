package com.bobo.spannalstring;

import android.text.Spanned;
import android.view.View;

public class SpannaleTookTextStyle {
    private String chooseString;
    private int foregroudColor = -1;
    private int backgroundColor = -1;
    private SpannableTool.LineType lineType = SpannableTool.LineType.NO_LINE;
    private boolean isCick;
    private String url;
    private int textSizeDp = -1;
    private int flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    private View.OnClickListener listener;

    public SpannaleTookTextStyle() {
    }

    public SpannaleTookTextStyle(String chooseString, int foregroudColor, int backgroundColor, SpannableTool.LineType lineType,
                                 boolean isCick, String url, int textSizeDp, int flags, View.OnClickListener listener) {
        this.chooseString = chooseString;
        this.foregroudColor = foregroudColor;
        this.backgroundColor = backgroundColor;
        this.lineType = lineType;
        this.isCick = isCick;
        this.url = url;
        this.textSizeDp = textSizeDp;
        this.flags = textSizeDp;
        this.listener = listener;
    }

    public void setChooseString(String chooseString) {
        this.chooseString = chooseString;
    }

    public void setForegroudColor(int foregroudColor) {
        this.foregroudColor = foregroudColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setLineType(SpannableTool.LineType lineType) {
        this.lineType = lineType;
    }

    public void setCick(boolean cick) {
        isCick = cick;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTextSizeDp(int textSizeDp) {
        this.textSizeDp = textSizeDp;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getChooseString() {
        return chooseString;
    }

    public int getForegroudColor() {
        return foregroudColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public SpannableTool.LineType getLineType() {
        return lineType;
    }

    public boolean isCick() {
        return isCick;
    }

    public String getUrl() {
        return url;
    }

    public int getTextSizeDp() {
        return textSizeDp;
    }
}
