package com.mohsin.spring.retry.service.impl;


import com.mohsin.spring.retry.exception.CustomException;
import com.mohsin.spring.retry.exception.NoResultException;
import com.mohsin.spring.retry.service.IFooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : Mohsin Iqbal
 * Date : 30-Oct-2020
 * Description :
 */
@Slf4j
@Service
public class FooService implements IFooService {

    @Override
    public String print(String message) {
        log.info(message);
        if (message.equals("foo")) {
            throw new NoResultException("foo throws NoResultException");
        } else {
            throw new CustomException("bar throws CustomException");
        }
    }

    @Override
    public void out(String message) {
        log.info(message);
        if (message.equals("foo")) {
            throw new NoResultException("foo throws NoResultException");
        } else {
            throw new CustomException("bar throws CustomException");
        }
    }

    @Override
    public String recover(NoResultException e, String message) {
        log.info("Recover from NoResultException({}):{}", message, e.getMessage());
        return "Recover from NoResultException";
    }

    @Override
    public String recover(CustomException e, String message) {
        log.info("Recover from CustomException({}):{}", message, e.getMessage());
        throw e;
    }

    @Override
    public void recover(NoResultException e) {
        log.info("Recover from NoResultException:{}", e.getMessage());
    }

    @Override
    public void recover(CustomException e) {
        log.info("Recover from CustomException:{}", e.getMessage());
        throw e;
    }
}
