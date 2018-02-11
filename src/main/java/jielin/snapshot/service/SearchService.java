package jielin.snapshot.service;

import jielin.snapshot.common.Result;

public interface SearchService {
    Result searchDeploymentByTitle(String key,int page);
}
