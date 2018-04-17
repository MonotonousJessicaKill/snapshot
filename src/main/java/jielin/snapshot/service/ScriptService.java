package jielin.snapshot.service;


import jielin.snapshot.common.Result;

public interface ScriptService {
    Result runScript(String name);
    Result startService(String scriptName);
}
