package jielin.snapshot.controller.backend;

import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.common.SuperUser;
import jielin.snapshot.domain.UserEntity;
import jielin.snapshot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class UserManController {

    @Autowired
    private SuperUser superUser;
    @Autowired
    private UserService userService;
    @PostMapping(value = "/login")
    public Result login(@Param("username")String username,@Param("password")String password,HttpSession session){

        if ((superUser.getUsername().equals(username) && superUser.getPassword().equals(password))
                || userService.verify(username,password)){

            session.setAttribute("logged",true);
            session.setAttribute("username",username);
            session.setMaxInactiveInterval(1000*60*30);
            return ResultUtil.success("login successfully");
        } else {
            session.setAttribute("logged",false);
            return ResultUtil.notFund();
        }

    }
    @GetMapping(value = "/users")
    public Result getAllUsers(HttpSession session){

        return userService.findAll();
    }

    @PostMapping(value = "/add")
    public Result addUser(@Param("username")String username,
                          @Param("password")String password,@Param("role")String role,HttpSession session){
        String currentUser=(String) session.getAttribute("username");
        if(!superUser.getUsername().equals(currentUser)){
            return ResultUtil.error("not allowed.super user can new user.");
        }
        UserEntity user=new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userService.createNewUser(user);
        return ResultUtil.success("success");
    }

}
