package jielin.snapshot.handle;

import jielin.snapshot.common.ResultEnum;

/**
 * spring只对RuntimeException进行事务回滚
 * 如果是Exception则不进行事务回滚
 */
public class VisualException extends RuntimeException{
    private int code;
    public  VisualException(Exception e){
        super(e);
    }
    public VisualException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
