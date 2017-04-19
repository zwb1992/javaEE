package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zwb on 17/4/7.
 */
@Service("cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns){
            bookService.purchase(username,isbn);
        }
    }
}
