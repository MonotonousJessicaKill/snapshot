package jielin.snapshot.service.impl;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import org.springframework.stereotype.Service;

@Service
public class ScriptServiceImpl implements jielin.snapshot.service.ScriptService{
    @Override
    public Result runScript(String scriptName) {
        String command = "powershell.exe E:/ScriptsUtils/" + scriptName+".ps1";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            int code=process.waitFor();
            if(code != 0){
                return ResultUtil.success("Script execution Failed! it may caused by script internal error.");
            }
            return ResultUtil.success("Execution Success!");
        }catch (Exception e){

            return ResultUtil.notFund();
        }finally {
            process.destroy();
        }
    }
}
