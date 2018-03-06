package jielin.snapshot.controller.backend;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/utils")
public class UtilsController {
    @Autowired
    private ScriptService scriptService;

    @PostMapping(value = "/run")
    public Result runLocalScripts(@Param("script")String script){
        System.out.println(script);
        if(script == null){
            return ResultUtil.notFund();
        }
        return scriptService.runScript(script);
    }
}
