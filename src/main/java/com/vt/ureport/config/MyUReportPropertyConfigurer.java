package com.vt.ureport.config;

import com.bstek.ureport.UReportPropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

/**
 * 继承UReportPropertyPlaceholderConfigurer, 装载application.yml
 */
public class MyUReportPropertyConfigurer extends UReportPropertyPlaceholderConfigurer {

	public MyUReportPropertyConfigurer(String path) {
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource(path));
		this.setProperties(yaml.getObject());
	}
	
}
