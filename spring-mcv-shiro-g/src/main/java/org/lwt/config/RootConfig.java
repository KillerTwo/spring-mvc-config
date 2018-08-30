package org.lwt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * spring 根容器配置类
 * 
 * @author Administrator
 *
 */
@Configuration
// 扫描org.lwt包下的类将其注册为spring的Bean,并且不扫描包含@EnableWebMvc注解的类
@ComponentScan( basePackages={"org.lwt"}, 
               excludeFilters = { @Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)}
           )
public class RootConfig {

}
