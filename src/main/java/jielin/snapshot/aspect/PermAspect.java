package jielin.snapshot.aspect;

import jielin.snapshot.common.ResultEnum;
import jielin.snapshot.common.SuperUser;
import jielin.snapshot.handle.VisualException;
import org.apache.catalina.manager.util.SessionUtils;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class PermAspect {
    private final static Logger logger = LoggerFactory.getLogger(PermAspect.class);
    @Autowired
    SuperUser superUser;
    @Pointcut("execution(! public * jielin.snapshot.controller.backend.UserManController.login(..))")
    public void loggingIn() {

    }
    @Before(value = "loggingIn()")
    public void isLoggedIn(){
       HttpSession session= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
                .getRequest().getSession();
        boolean logged=(boolean)session.getAttribute("logged");
        if (logged){
            logger.info(session.getAttribute("username")+"already in.");
            return;
        }
        throw new VisualException(ResultEnum.PRIMARY_ERROR);

    }
}
