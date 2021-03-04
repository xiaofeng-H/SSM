package pers.xiaofeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.xiaofeng.dao.AccountDao;
import pers.xiaofeng.service.AccountService;

import javax.annotation.Resource;

/**
 * @className: pers.xiaofeng.service.impl.AccountServiceImpl
 * @description: 目标对象 内部的方法就是切点
 * @author: xiaofeng
 * @create: 2021-03-03 14:25
 */
@Service("accountService")
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)    // 代表当前类下所有的方法都用这个事务控制
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    /*<!--配置aop的事务织入-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="transfer" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false"/>
            <tx:method name="save" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false"/>
            <tx:method name="findAll" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="true"/>
            <tx:method name="update*" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="true"/>
            <tx:method name="*"/>
        </tx:attributes>
    </tx:advice>
    <aop:config>
        <aop:advisor advice-ref="txAdvice" pointcut="execution(* pers.xiaofeng.service.impl.*.*(..))"/>
    </aop:config>
    */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)    // 当前方法以这个事务控制为主
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        int i = 1 / 0;
        accountDao.in(inMan, money);
    }
}
