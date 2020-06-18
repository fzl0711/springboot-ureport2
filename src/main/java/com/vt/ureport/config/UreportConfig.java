package com.vt.ureport.config;

import com.bstek.ureport.console.UReportServlet;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import javax.servlet.Servlet;

/**
 * Ureport2 配置类
 */
@Configuration
@ImportResource("classpath:ureport-console-context.xml")
public class UreportConfig implements EnvironmentAware {

	private Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Bean
	public MyUReportPropertyConfigurer propertyrConfigurer(){
		String activeProfile = environment.getProperty("spring.profiles.active");
		if(StringUtils.isNotBlank(activeProfile)){
			activeProfile = "-" + activeProfile;
		}
		return new MyUReportPropertyConfigurer("application" + activeProfile + ".yml");
	}


	@Bean
	public ServletRegistrationBean<Servlet> buildUreportServlet(){
		return new ServletRegistrationBean<Servlet>(new UReportServlet(), "/ureport/*");
	}

}


