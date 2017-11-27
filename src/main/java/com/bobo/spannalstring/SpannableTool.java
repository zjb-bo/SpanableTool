package com.bobo.spannalstring;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.View;

import static com.bobo.spannalstring.SpannableTool.LineType.NO_LINE;
import static com.bobo.spannalstring.util.CommonUtil.isContained;
import static com.bobo.spannalstring.util.CommonUtil.isObjNoNull;

/**
 * Created by ZJB on 2017/11/27.
 *
 * @ copyright: iwhere chengdu technology
 */

public class SpannableTool {
    private static int NO_SET = -1;
    private SpannableStringBuilder mSpannaleBuider;

    private SpannableTool(SpannableStringBuilder mSpannaleBuider) {
        this.mSpannaleBuider = mSpannaleBuider;
    }

    public CharSequence getSpannaleString(){
        return mSpannaleBuider;
    }

    public static class SpannableToolBuilder {
        private String originalString;
        private SpannableStringBuilder mSpannaleBuider;

        public SpannableToolBuilder(String originalString) {
            this.mSpannaleBuider = new SpannableStringBuilder();
            this.mSpannaleBuider.clear();
            this.mSpannaleBuider.append(originalString);
            this.originalString = originalString;

        }

        public SpannableToolBuilder addOriginalString(String originalString) {
            mSpannaleBuider.append(originalString);
            this.originalString += originalString;
            return this;
        }

        public SpannableToolBuilder setSingleChooseString(final SpannaleTookTextStyle textStyle) {
            if(isObjNoNull(textStyle)){
                String chooseString = textStyle.getChooseString();
                if(!isObjNoNull(chooseString)){
                    throw new NullPointerException("SpannableTool->getChooseString:不能为空");
                }
                if(!isContained(this.originalString, chooseString)){
                    throw new NullPointerException("SpannableTool->isContained:chooseString不在原始数据串内，" +
                            "chooseString"+ chooseString +" originalString："+   originalString);
                }
                int indexStart = this.originalString.indexOf(chooseString);
                int indexEnd = this.originalString.indexOf(chooseString)+chooseString.length();

                if(textStyle.getForegroudColor() != NO_SET){
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(textStyle.getForegroudColor());
                    mSpannaleBuider.setSpan(foregroundColorSpan,indexStart,indexEnd,textStyle.getFlags() );
                }
                if(textStyle.getBackgroundColor() != NO_SET){
                    BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(textStyle.getBackgroundColor());
                    mSpannaleBuider.setSpan(backgroundColorSpan,indexStart,indexEnd,textStyle.getFlags());
                }
                if(textStyle.isCick()){
                    ClickableSpan clickableSpan = new ClickableSpan() {

                        @Override
                        public void updateDrawState(TextPaint ds) {
//                            super.updateDrawState(ds);
                        }

                        @Override
                        public void onClick(View widget) {
                            if(textStyle.getListener() != null){
                                textStyle.getListener().onClick(widget);
                            }
                        }
                    };
                    mSpannaleBuider.setSpan(clickableSpan,indexStart,indexEnd,textStyle.getFlags());
                }
                if(textStyle.getTextSizeDp() != NO_SET){
                    RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(textStyle.getTextSizeDp());
                    mSpannaleBuider.setSpan(relativeSizeSpan,indexStart,indexEnd,textStyle.getFlags());
                }
                if(textStyle.getLineType() != NO_LINE){
                    switch (textStyle.getLineType()){
                        case DELET_LINE:
                            StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                            mSpannaleBuider.setSpan(strikethroughSpan,indexStart,indexEnd,textStyle.getFlags());
                            break;
                        case UNDER_LINE:
                            UnderlineSpan underlineSpan = new UnderlineSpan();
                            mSpannaleBuider.setSpan(underlineSpan,indexStart,indexEnd,textStyle.getFlags());
                            break;
                    }
                }

            }else {
                throw new NullPointerException("SpannableTool->样式设置不能为空");
            }

            return this;
        }


        public SpannableTool createSpannableTool() {
            return new SpannableTool(mSpannaleBuider);
        }
    }

    public enum LineType{
        DELET_LINE,
        UNDER_LINE,
        NO_LINE;
    }

}
