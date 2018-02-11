package jielin.snapshot;

import jielin.snapshot.common.Result;
import jielin.snapshot.common.ResultEnum;

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

}
