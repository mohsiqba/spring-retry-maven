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
public interface IBarService {
    String print(String message);
    void out(String message);
}
