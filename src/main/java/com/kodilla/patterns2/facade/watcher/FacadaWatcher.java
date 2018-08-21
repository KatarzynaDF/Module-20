package com.kodillapatterns2a.facade.watcher;

import com.kodillapatterns2a.facade.dto.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadaWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodillapatterns2a.facade.watcher.FacadaWatcher.class);


    @Before("execution(* com.kodillapatterns2a.facade.dto.OrderFacade.processOrder(..))" +
            "&& args(orderDto,id)")
    public void logEventOrder(OrderDto orderDto, long id) {
        LOGGER.info("Logging the event");
        LOGGER.info("Args: " + orderDto + " " + id );
    }

    @Around("execution(* com.kodillapatterns2a.facade.dto.OrderFacade.processOrder(..))")
    public Object measureTimeOrder(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.nanoTime();
            result = proceedingJoinPoint.proceed();
            long end = System.nanoTime();
            LOGGER.info("Time consumed by processOrder " + (end-begin) + " [ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return  result;
    }
}