package org.lwt.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;

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

  
  /**
   * props创建一个Bean可以通过@Value注解读取指定属性文件中的值，该方法属性文件的属性名不能有点号分割。
   * @return
   */
  /*@Bean
  public PropertiesFactoryBean prop() {
    String path = getClass().getClassLoader().getResource("dataSource.properties").getPath();
    path = path.substring(1, path.length());
    System.out.println("资源路径："+path);
    PropertiesFactoryBean props = new PropertiesFactoryBean();
    Resource resource;
    try {
      resource = new InputStreamResource(new FileInputStream(new File(path)));
      props.setLocation(resource);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return props;
  }*/
  /**
   * props 创建一个Bean,用来存储指定属性文件的键值对
   * @return
   */
  @Bean
  public PropertiesConfig propertyConfigurer() {
    String path = getClass().getClassLoader().getResource("dataSource.properties").getPath();
    path = path.substring(1, path.length());
    PropertiesConfig config = new PropertiesConfig();
    config.setIgnoreResourceNotFound(true);
    config.setIgnoreUnresolvablePlaceholders(true);
    try {
      config.setLocation(new InputStreamResource(new FileInputStream(new File(path))));
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return config;
  }

  // 配置druid数据源
  @Bean
  public DataSource druidDataSource(PropertiesConfig propertyConfigurer) {
    /*System.out.println("数据库用户名>>： "+propertyConfigurer.getProperty("username"));
    System.out.println("数据库用户密码>>： "+propertyConfigurer.getProperty("spring.datasource.password"));*/
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(propertyConfigurer.getProperty("spring.datasource.driverClassName"));
    dataSource.setUrl(propertyConfigurer.getProperty("spring.datasource.url"));
    dataSource.setUsername(propertyConfigurer.getProperty("spring.datasource.username"));
    dataSource.setPassword(propertyConfigurer.getProperty("spring.datasource.password"));
    return dataSource;
  }
  @Bean
  public PageInterceptor pageInterceptor() {
    PageInterceptor interceptor = new PageInterceptor();
    Properties props = new Properties();
    props.setProperty("helperDialect", "mysql");
    props.setProperty("reasonable", "true");
    props.setProperty("supportMethodsArguments", "mysql");
    props.setProperty("autoRuntimeDialect", "true");
    
    interceptor.setProperties(props);
    return interceptor;
  }
  
  @Bean
  public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
    
    ClassPathResource cpr = new ClassPathResource("/spring/applicationContext.xml");
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    // 1.设置数据源
    sqlSessionFactoryBean.setDataSource(dataSource);
    // 2. 设置mapper配置文件的位置， new ClassPathResource("/mapper/*.xml")表示加载类路径下的mapper文件夹下的 .xml文件
    sqlSessionFactoryBean.setMapperLocations(new Resource[] {new ClassPathResource("/mapper/DepartmentsMapper.xml")});
    // 3. 设置实体类的别名
    sqlSessionFactoryBean.setTypeAliasesPackage("org.lwt.entity");
    // 4. 添加mybatis pageHelper分页插件
    sqlSessionFactoryBean.setPlugins(new Interceptor[] {pageInterceptor()});
    
    return sqlSessionFactoryBean;
  }
  
}
