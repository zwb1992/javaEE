package com.zwb.mybatis;

import com.zwb.mybatis.bean.Account;
import com.zwb.mybatis.dao.AccountMapper;
import com.zwb.mybatis.dao.AccountMapperAnnotation;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    /**
     * sqlSessionFactory.openSession()---》不会自动提交
     * sqlSessionFactory.openSession(true)---》会自动提交
     * @return
     * @throws IOException
     */
    private  SqlSession getSqlSession() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }


    @org.junit.Test
    public void testMybatis01() throws IOException{
        SqlSession session = getSqlSession();
        try {
            Account account = session.selectOne("com.zwb.mybatis.dao.AccountMapper.getAccountById", 1);
            System.out.println("account--->"+account.toString());
        } finally {
            session.close();
        }
    }

    @org.junit.Test
    public void testMybatis02() throws IOException{
        SqlSession session = getSqlSession();
        try {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Account account = accountMapper.getAccountById(1);
            System.out.println("account--->"+account.toString());
        } finally {
            session.close();
        }
    }

    @org.junit.Test
    public void testMybatis03() throws IOException{
        SqlSession session = getSqlSession();
        try {
            AccountMapperAnnotation accountMapper = session.getMapper(AccountMapperAnnotation.class);
            Account account = accountMapper.getAccountById(1);
            System.out.println("account--->"+account.toString());
        } finally {
            session.close();
        }
    }

    @org.junit.Test
    public void testMybatis04() throws IOException{
        SqlSession session = getSqlSession();
        try {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Account account = new Account(1,"zwb",999);
            long id = accountMapper.addAccount(account);
            System.out.println("id--->"+id);
            System.out.println("id--->"+account.toString());
//            boolean flag = accountMapper.updateAccount(new Account(5,"zwb1",1999));
//            System.out.println("flag--->"+flag);
//            accountMapper.deleteAccountById(5);
            session.commit();//一定得提交
        } finally {
            session.close();
        }
    }

    @org.junit.Test
    public void testMybatis05() throws IOException{
        SqlSession session = getSqlSession();
        try {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Account account = accountMapper.getAccountByIdAndName(1,"aaa");
            System.out.println("account--->"+account.toString());
        } finally {
            session.close();
        }
    }

    @org.junit.Test
    public void testMybatis06() throws IOException{
        SqlSession session = getSqlSession();
        try {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Account account = accountMapper.getAccountByIdAndName1(1,"aaa");
            System.out.println("account--->"+account.toString());
        } finally {
            session.close();
        }
    }

    @org.junit.Test
    public void testMybatis07() throws IOException{
        SqlSession session = getSqlSession();
        try {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Map<String,Object> map = new HashMap();
            map.put("id",1);
            map.put("name","aaa");
            Account account = accountMapper.getAccountByMap(map);
            System.out.println("account--->"+account.toString());
        } finally {
            session.close();
        }
    }
}
