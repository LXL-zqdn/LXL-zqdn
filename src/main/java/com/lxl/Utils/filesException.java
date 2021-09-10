package com.lxl.Utils;

/**
 * @LXL
 */

/**
 * 文本异常处理类
 */
public class filesException extends Exception {
    public filesException() {
        super();
    }

    public filesException(String message) {
        super(message);
    }

    public filesException(String message, Throwable cause) {
        super(message, cause);
    }

    public filesException(Throwable cause) {
        super(cause);
    }
}
