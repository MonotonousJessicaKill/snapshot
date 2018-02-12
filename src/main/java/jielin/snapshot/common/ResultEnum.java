package jielin.snapshot.common;

public enum ResultEnum {

    UnKNOW_ERROR(-1,"未知错误"),
    PRIMARY_ERROR(404,"未搜索到资源"),
    SUCCESS(200,"success");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
