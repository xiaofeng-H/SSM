package pers.xiaofeng.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @className: pers.xiaofeng.handler.DateTypeHandler
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-26 17:55
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {
    /*
    typeHandlers标签(类型转换器)
    具体做法:实现org.apache.ibatis.type.TypeHandler接口,或继承一个很便利的类org.apache.ibatis.type.BaseTypeHandler,然后
    可以选择性地将它映射到一个JDBC类型.

    开发步骤:
    1>定义转换类继承类BaseTypeHandler<T>
    2>覆盖四个未实现的方法，其中setNonNullParameter为java程序设置数据到数据库的回调方法，getNullableResult为查询时
    mysql的字符串类型转换成Java的Type类型的方法。
    3>在mybatis核心配置文件中进行注册
    4>测试转换是否正确
    */

    @Override
    // 将Java类型转换成数据库需要的类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i, time);
    }

    @Override
    // 将数据库中类型转换成Java类型
    // String参数：要转换的字段名称
    // ResultSet：查询出的结果集
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        // 获得结果集中需要的数据（long）转换成Date类型
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    // 将数据库中类型转换成Java类型
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        // 获得结果集中需要的数据（long）转换成Date类型
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    // 将数据库中类型转换成Java类型
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        // 获得结果集中需要的数据（long）转换成Date类型
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
