package jielin.snapshot.service.impl;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.handle.VisualException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

@Service
public class ScriptServiceImpl implements jielin.snapshot.service.ScriptService{
    public static int PFGoldAutoTriage=0;
    public static int WARMAutoReply=0;

    @Override
    public Result runScript(String scriptName) {
        String command = "powershell.exe D:/ScriptsUtils/" + scriptName+".ps1";
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
    @Override
    public Result startService(String scriptName){
        if (("PFGoldAutoTriage".equals(scriptName)?PFGoldAutoTriage:WARMAutoReply)
                ==1)
            return ResultUtil.success("Already Started By Other Person!");
        String command = "powershell.exe E:/ScriptsUtils/" + scriptName+".ps1";
        Process process=null;
        Result result=null;
        try {
            Runtime.getRuntime().exec(command);
            result = ResultUtil.success(scriptName+" started success");
            if ("PFGoldAutoTriage".equals(scriptName)) PFGoldAutoTriage = 1;
            else WARMAutoReply = 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.HOURS.sleep(8);
                        if ("PFGoldAutoTriage".equals(scriptName)) PFGoldAutoTriage = 0;
                        else WARMAutoReply = 0;
                        process.destroy();
                    } catch (InterruptedException e) {
                        // nothing
                    }
                }
            }).start();
        } catch (IOException e) {
             result = ResultUtil.error();
            throw new VisualException(e);
        }
        finally {
            return result;
        }
    }
}
