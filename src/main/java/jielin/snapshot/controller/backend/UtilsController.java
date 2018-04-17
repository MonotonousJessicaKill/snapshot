package jielin.snapshot.controller.backend;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.service.ScriptService;
import jielin.snapshot.service.impl.ScriptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Util;

@RestController
@RequestMapping(value = "/utils")
public class UtilsController {
    @Autowired
    private ScriptService scriptService;

    @PostMapping(value = "/run")
    public Result runLocalScripts(@Param("script")String script){
        if(script == null){
            return ResultUtil.notFund();
        }
        return scriptService.runScript(script);
    }
    @RequestMapping(value = "/servicestatus")
    public Result getServiceStatus(@Param("script")String script){
        return "PFGoldAutoTriage".equals(script)?ResultUtil.success(ScriptServiceImpl.PFGoldAutoTriage):
                ResultUtil.success(ScriptServiceImpl.WARMAutoReply);
    }
    @PostMapping(value = "/servicestart")
    public Result startScriptService(@Param("service")String service){
        if (service == null)return ResultUtil.notFund();

        return scriptService.startService(service);
    }

}
