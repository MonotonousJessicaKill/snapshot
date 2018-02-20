package jielin.snapshot.service;

import jielin.snapshot.common.Result;
import jielin.snapshot.domain.UserEntity;

public interface UserService {
    boolean verify(String username,String password);
    Result findAll();
    void createNewUser(UserEntity userEntity);
}
