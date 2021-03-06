package com.three.coinexchange.aop;

import com.three.coinexchange.annotations.RequirePermission;
import com.three.coinexchange.exceptions.NoAuthException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
@Aspect
public class PermissionProxy {

    @Autowired
    private HttpSession session;

    @Around(value = "@annotation(com.three.coinexchange.annotations.RequirePermission)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        List<Integer> permissions = (List<Integer>) session.getAttribute("permissions");
        if (null == permissions || permissions.size() == 0) {
            throw new NoAuthException("无权限访问");
        }
        System.out.println(permissions);
        Object result = null;
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        RequirePermission requirePermission =
                methodSignature.getMethod().getDeclaredAnnotation(RequirePermission.class);
        if (!(permissions.contains(requirePermission.code()))) {
            throw new NoAuthException("无权限访问");
        }
        result = pjp.proceed();
        return result;
    }
}