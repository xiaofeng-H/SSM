package pers.xiaofeng.config;

import org.springframework.context.annotation.*;

/**
 * @className: pers.xiaofeng.config.SpringConfiguration
 * @description:
 * @author: xiaofeng
 * @create: 2021-02-01 15:22
 */
// 标志该类是Spring的核心配置类
@Configuration
//<context:component-scan base-package="pers.xiaofeng"/>
@ComponentScan("pers.xiaofeng")
//<import resource="applicationContext-user.xml"/>
@Import({DataSourceConfiguration.class}) // 数组格式
public class SpringConfiguration {

}
