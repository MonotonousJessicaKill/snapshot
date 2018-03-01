package jielin.snapshot.service.impl;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.dao.UserDao;
import jielin.snapshot.domain.UserEntity;
import jielin.snapshot.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserDao userDao;

    @Override
    public boolean verify(String username, String password) {
       UserEntity userEntity= userDao.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Predicate equal= criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("username"),username)
                        ,criteriaBuilder.equal(root.get("password"),password)
                );
                criteriaQuery.where(equal);
                return null;
            }
        });
       if(userEntity == null)return false;
        return true;
    }
    public Result findAll(){
        return ResultUtil.success(userDao.findAll());
    }
    @Transactional
    public void createNewUser(UserEntity userEntity){
        userDao.save(userEntity);
    }
}
