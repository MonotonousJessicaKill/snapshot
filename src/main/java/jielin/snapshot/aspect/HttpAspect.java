package jielin.snapshot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    private int requestCount=0;
    @Before("execution(public * jielin.snapshot.controller.*.*(..))")
    public void visitBefore(JoinPoint joinPoint) {
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

        logger.info("handle request successful :"+requestCount+" times");
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
