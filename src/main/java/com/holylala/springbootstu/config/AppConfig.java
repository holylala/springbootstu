package com.holylala.springbootstu.config;
import java.util.Properties;

import javax.sql.DataSource;

import com.holylala.springbootstu.model.DataBaseProperties;
import io.lettuce.core.dynamic.annotation.Value;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = {"com.holylala.springbootstu"})
public class AppConfig {

	@Autowired
	private DataBaseProperties dataBaseProperties;

	//@Bean 定义了其配置项name为"dataSource" spring把返回的对象用名称"dataSource"保存在IOC容器中
	@Bean(name = "dataSource")
	@Profile("dev") //dev 环境使用这个
	public DataSource getDevDataSource() {
		Properties props = new Properties();
		props.setProperty("driver", dataBaseProperties.getDriverName());
		props.setProperty("url", "");
		props.setProperty("username", "");
		props.setProperty("password", "");
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean(name = "dataSource")
	@Profile("test") //test 环境使用这个
	public DataSource getTestDataSource() {
		Properties props = new Properties();
		props.setProperty("driver", dataBaseProperties.getDriverName());
		props.setProperty("url", "");
		props.setProperty("username", "");
		props.setProperty("password", "");
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	

}