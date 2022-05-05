package com.fp.common.core.util;

import com.fp.common.core.exception.MethodArgumentIsNullException;

public class ValidUtil {

    public static void checkNotNull(Object... objects) {
        for (Object object : objects) {
            if (object == null) throw new MethodArgumentIsNullException();
        }
    }

}
