package com.spring.service;

import com.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zwb on 17/4/7.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    //1，添加事务注解
    //2，事务的传播行为，默认在原有的事务中执行Propagation.REQUIRED
    //当现在的事务方法被另外一个事务方法调用时，默认使用调用者的事务
    //3，REQUIRES_NEW 这个代表新开一个事务，调用者的事务暂时被挂起，等待此事务完成
    //4，isolation知道事务的隔离级别，最常用的取值为READ_COMMITTED
    //5，默认情况下，Spring声明式事务对所有运行时异常进行回滚rollbackFor,noRollbackFor
    //6,属性设置一般取默认值
    //timeout 设置事务回滚之前可以执行多长时间
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,readOnly = false,timeout = 30)
    @Override
    public void purchase(String username, String isbn) {
        //1,获取图书的价格
        int price = bookDao.getPriceByIsbn(isbn);
        //2，更新库存
        bookDao.updateStock(isbn);
        //3，更新余额
        bookDao.updateBalance(username, price);
    }
}
