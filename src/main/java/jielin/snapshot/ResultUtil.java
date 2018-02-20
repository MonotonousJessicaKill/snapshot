package jielin.snapshot;

import jielin.snapshot.common.Result;
import jielin.snapshot.common.ResultEnum;
import jielin.snapshot.handle.VisualException;

public class ResultUtil {
    public static Result success(Object data){
        Result result=new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setData(data);
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }
    public static Result notFund(){
        Result result=new Result();
        result.setCode(ResultEnum.PRIMARY_ERROR.getCode());
        result.setMsg(ResultEnum.PRIMARY_ERROR.getMsg());
        return result;
    }
    public static Result error(){
            Result result=new Result();
            result.setCode(ResultEnum.UnKNOW_ERROR.getCode());
            result.setMsg(ResultEnum.UnKNOW_ERROR.getMsg());
            return result;

    }
    public static Result error(String msg){
        Result result=new Result();
        result.setCode(ResultEnum.UNAUTHORIZED.getCode());
        result.setMsg(msg);
        return result;

    }
    public static Result error(VisualException e){
        Result result=new Result();
        result.setCode(e.getCode());
        result.setMsg(e.getMessage());
        return result;

    }

}
