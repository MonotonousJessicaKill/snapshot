package jielin.snapshot.aspect;

import jielin.snapshot.common.ResultEnum;
import jielin.snapshot.common.SuperUser;
import jielin.snapshot.handle.VisualException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Pointcut("(execution(public * jielin.snapshot.controller.backend.UserManController.*User*(..))) " +
            "|| (execution(public * jielin.snapshot.controller.backend.NoteController.*Note*(..)))")
    public void loggingIn() {

    }
    @Before(value = "loggingIn()")
    public void isLoggedIn(){
       HttpSession session= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
                .getRequest().getSession();
        Object obj=session.getAttribute("logged");
        if(obj!=null) {
            boolean logged = (boolean) obj;
            if (logged) {
                logger.info(session.getAttribute("username") + "already in.");
                logger.info("site viewed:================================================="+superUser.siteCount++ +"times.");
                return;
            }
        }

        throw new VisualException(ResultEnum.UNAUTHORIZED);

    }
}
