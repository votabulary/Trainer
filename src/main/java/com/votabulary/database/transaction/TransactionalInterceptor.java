package com.votabulary.database.transaction;

import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TransactionalInterceptor implements MethodInterceptor {

    @Inject
    TransactionManager transactionManager;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Transactional transactional = invocation.getMethod().getAnnotation(Transactional.class);
        try (CloseableTransaction transaction = transactionManager.beginTransaction(transactional.value())) {
            Object result = invocation.proceed();
            transaction.commit();
            return result;
        }
    }
}
