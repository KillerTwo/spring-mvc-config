package org.lwt.config;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
/**
 * pro保存属性文件中的键值对的类
 * @author Administrator
 *
 */
public class PropertiesConfig extends PropertyPlaceholderConfigurer {

  private Properties props;

  @Override
  protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
      throws BeansException {

    super.processProperties(beanFactoryToProcess, props);
    /*setIgnoreResourceNotFound(true);
    setIgnoreUnresolvablePlaceholders(true);*/
    this.props = props;
  }
  

  @Override
  public void setIgnoreUnresolvablePlaceholders(boolean ignoreUnresolvablePlaceholders) {
    super.setIgnoreUnresolvablePlaceholders(ignoreUnresolvablePlaceholders);
  }

  @Override
  public void setLocation(Resource location) {
    
    super.setLocation(location);
  }

  @Override
  public void setIgnoreResourceNotFound(boolean ignoreResourceNotFound) {

    super.setIgnoreResourceNotFound(ignoreResourceNotFound);
  }

  public String getProperty(String key) {
    return this.props.getProperty(key);
  }

  public String getProperty(String key, String defaultValue) {
    return this.props.getProperty(key, defaultValue);
  }

  public Object setProperty(String key, String value) {
    return this.props.setProperty(key, value);
  }

}
