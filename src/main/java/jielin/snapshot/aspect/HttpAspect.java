package jielin.snapshot.aspect;

import jielin.snapshot.common.SuperUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: jielin.wu wu.jielin@oe.21vianet.com
 * @CreateTime: 2018/4/27
 * Description:
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    private SuperUser superUser;

    @Before("execution(public * jielin.snapshot.controller.*.*(..))")
    public void visitBefore(JoinPoint joinPoint) {
        logger.info("site viewed:================================================="+superUser.siteCount++ +"times.");
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={} method={} args={}", request.getRequestURI(),
                request.getMethod(), joinPoint.getArgs());

        logger.info("ClassMethod={}", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
    }

    @After("execution(public * jielin.snapshot.controller.*.*(..))")
    public void visitAfter() {

    }

    @AfterReturning(returning = "object", pointcut =
            "execution(public * jielin.snapshot.controller.*.*(..))")
    public void afterReturn(Object object) {
        logger.info("response={}", object);
    }

//    // 以下代码和上述代码能产生一样的效果，并且优先执行
//    @Pointcut("execution(public * jielin.snapshot.controller.*.*(..))")
//    public void generalLog(){
//
//    }
//    @Before("generalLog()")
//    public void beforeLog(){
//        System.out.println("before2");
//    }
//    @Before("generalLog()")
//    public void afterLog(){
//        System.out.println("after2");
//    }
}
