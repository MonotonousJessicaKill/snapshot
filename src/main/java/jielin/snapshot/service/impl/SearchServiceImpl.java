package jielin.snapshot.service.impl;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.dao.DeploymentDao;
import jielin.snapshot.domain.DeploymentDataProdEntity;
import jielin.snapshot.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private DeploymentDao deploymentDao;

    @Override
    public Result searchDeploymentByTitle(String key, int pageNo) {
        Page<DeploymentDataProdEntity> page;
          if ("all".equals(key)){
              page=deploymentDao.findAll(new PageRequest(pageNo, 10,
                      new Sort(Sort.Direction.DESC, "id")));
              return ResultUtil.success(page);
          }


         page = deploymentDao.findAll(new Specification<DeploymentDataProdEntity>() {
            @Override
            public Predicate toPredicate(Root<DeploymentDataProdEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                Predicate like = criteriaBuilder.like(root.get("title").as(String.class), "%" + key + "%");
                criteriaQuery.where(like);
                return null;
            }
        }, new PageRequest(pageNo, 10, new Sort(Sort.Direction.DESC, "id")));

        return ResultUtil.success(page);
    }
}
