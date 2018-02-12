package jielin.snapshot.handle;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {
    private Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        if (e instanceof VisualException)
        return ResultUtil.error(((VisualException) e));
        else {
            logger.error("系统异常{}",e);
            return ResultUtil.error();

        }
    }
}
