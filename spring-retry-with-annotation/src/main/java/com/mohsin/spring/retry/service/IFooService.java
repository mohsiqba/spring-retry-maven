package com.mohsin.spring.retry.service;

import com.mohsin.spring.retry.exception.CustomException;
import com.mohsin.spring.retry.exception.NoResultException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

/**
 * @author : Mohsin Iqbal
 * Date : 30-Oct-2020
 * Description :
 */
public interface IFooService {

    @Retryable(include = NoResultException.class, backoff = @Backoff(delay = 100, maxDelay = 101), maxAttempts = 5)
    String print(String message);

    @Retryable(include = NoResultException.class, backoff = @Backoff(delay = 100, maxDelay = 101), maxAttempts = 5)
    void out(String message);

    @Recover
    String recover(NoResultException e, String message);

    @Recover
    String recover(CustomException e, String message);

    @Recover
    void recover(NoResultException e);

    @Recover
    void recover(CustomException e);
}
