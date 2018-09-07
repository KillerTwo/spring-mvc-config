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
 * spring ������������
 * 
 * @author Administrator
 *
 */
@Configuration
// ɨ��org.lwt���µ��ཫ��ע��Ϊspring��Bean,���Ҳ�ɨ�����@EnableWebMvcע�����
@ComponentScan( basePackages={"org.lwt"}, 
               excludeFilters = { @Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)}
           )
public class RootConfig {

  
  /**
   * props����һ��Bean����ͨ��@Valueע���ȡָ�������ļ��е�ֵ���÷��������ļ��������������е�ŷָ
   * @return
   */
  /*@Bean
  public PropertiesFactoryBean prop() {
    String path = getClass().getClassLoader().getResource("dataSource.properties").getPath();
    path = path.substring(1, path.length());
    System.out.println("��Դ·����"+path);
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
   * props ����һ��Bean,�����洢ָ�������ļ��ļ�ֵ��
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

  // ����druid����Դ
  @Bean
  public DataSource druidDataSource(PropertiesConfig propertyConfigurer) {
    /*System.out.println("���ݿ��û���>>�� "+propertyConfigurer.getProperty("username"));
    System.out.println("���ݿ��û�����>>�� "+propertyConfigurer.getProperty("spring.datasource.password"));*/
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
    // 1.��������Դ
    sqlSessionFactoryBean.setDataSource(dataSource);
    // 2. ����mapper�����ļ���λ�ã� new ClassPathResource("/mapper/*.xml")��ʾ������·���µ�mapper�ļ����µ� .xml�ļ�
    sqlSessionFactoryBean.setMapperLocations(new Resource[] {new ClassPathResource("/mapper/DepartmentsMapper.xml")});
    // 3. ����ʵ����ı���
    sqlSessionFactoryBean.setTypeAliasesPackage("org.lwt.entity");
    // 4. ���mybatis pageHelper��ҳ���
    sqlSessionFactoryBean.setPlugins(new Interceptor[] {pageInterceptor()});
    
    return sqlSessionFactoryBean;
  }
  
}
