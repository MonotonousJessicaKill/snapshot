package jielin.snapshot.controller;

import jielin.snapshot.common.Result;
import jielin.snapshot.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchDeploymentController {

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/search/{key}/{page}")
    public Result searchDeployment(@PathVariable("key")String key, @PathVariable("page")int page){
        return searchService.searchDeploymentByTitle(key.toUpperCase(),page);
    }
}
