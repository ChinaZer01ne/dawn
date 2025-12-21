package com.dawn.chaos.exception;
/**
 * 通用异常
 *
 * @author peach
 * @since 2025/12/21 22:50
 */
public class ServerException extends RuntimeException {

    private Integer code;

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public ServerException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
