package com.bobo.spannalstring.util;

import android.text.TextUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ZJB on 2017/11/27.
 *
 * @ copyright: iwhere chengdu technology
 */

public class CommonUtil {

    public static boolean isObjNoNull(Object obj){
        if (obj == null)
            return false;


        if (obj instanceof CharSequence)
            return !TextUtils.isEmpty((CharSequence)(obj));

        if (obj instanceof Collection)
            return !((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return !((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return false;
            }
            boolean empty = false;
            for (Object anObject : object) {
                if (isObjNoNull(anObject)) {
                    empty = true;
                    break;
                }
            }
            return empty;
        }
        return true;
    }

    public static boolean isContained(String parentString,String sonString) {
        return parentString.contains(sonString);
    }

}
