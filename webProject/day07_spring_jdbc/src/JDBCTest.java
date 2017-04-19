import com.spring.bean.AccountInfo;
import com.spring.jdbc.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zwb on 17/4/6.
 */
public class JDBCTest {

    private ApplicationContext applicationContext;
    private JdbcTemplate jdbcTemplate;
    private AccountDao accountDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        applicationContext = new ClassPathXmlApplicationContext("beans-properties.xml");
        jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        accountDao = applicationContext.getBean(AccountDao.class);
        namedParameterJdbcTemplate = applicationContext.getBean(NamedParameterJdbcTemplate.class);
    }


    /**
     * 查询一个对象，注意：JdbcTemplate不支持级联属性的查询（一个对象中包含另外一个对象）
     */
    @Test
    public void testQuery() {
        String sql = "select * from account_info where id=?";
        RowMapper<AccountInfo> rowMapper = new BeanPropertyRowMapper<>(AccountInfo.class);
        AccountInfo accountInfo = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(accountInfo);
    }

    /**
     * 获取单个列的值，做统计
     */
    @Test
    public void testQuery2() {
        String sql = "select COUNT(id) from account_info";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    /**
     * 查询一组对象,不是用queryForList
     */
    @Test
    public void testQueryForList() {
        String sql = "select * from account_info where id>?";
        RowMapper<AccountInfo> rowMapper = new BeanPropertyRowMapper<>(AccountInfo.class);
        List<AccountInfo> accountInfo = jdbcTemplate.query(sql, rowMapper, 1);
        System.out.println(accountInfo);
    }

    @Test
    public void testUpdate() {
        String sql = "UPDATE account_info SET account = ? where id=?";
        jdbcTemplate.update(sql, "张三", 1);
    }

    /**
     * 批量更新，插入，删除
     */
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO account_info(account,amount) VALUES (?,?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"aa", "11"});
        list.add(new Object[]{"bb", "22"});
        list.add(new Object[]{"cc", "33"});
        jdbcTemplate.batchUpdate(sql, list);
    }

    @Test
    public void testAccountDao() {
        AccountInfo accountInfo = accountDao.get(1);
        System.out.println(accountInfo);
    }

    /**
     * 使用具名参数,可以为参数起名字
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "INSERT INTO account_info(account,amount) VALUES (:name,:price)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", "test");
        map.put("price", "888");
        namedParameterJdbcTemplate.update(sql, map);
    }

    /**
     * 使用具名参数,可以为参数起名字，并且可以直接传入一个对象,其中参数名必须与对象属性名一一对应
     */
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "INSERT INTO account_info(account,amount) VALUES (:account,:amount)";
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount("parameterSource");
        accountInfo.setAmount(666);
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(accountInfo);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }

}
