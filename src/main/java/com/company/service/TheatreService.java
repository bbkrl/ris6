package com.company.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.company.bean.Theatre;

import java.util.Date;
import java.util.List;

@WebService
public interface TheatreService {

    @WebMethod
    List<Theatre> findByName(String name);

    @WebMethod
    List<Theatre> findByDate(Date date);

    @WebMethod
    List<Theatre> getAllTheatre();
}