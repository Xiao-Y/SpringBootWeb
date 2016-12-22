package com.billow;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

// 开启事务
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.billow.mapper")
public class Application extends SpringBootServletInitializer {
	private static Logger logger = Logger.getLogger(Application.class);

	// DataSource配置,表示将根据前缀“spring.datasource”从application.properties中匹配相关属性值。
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		// return new org.apache.tomcat.jdbc.pool.DataSource();
		return new DruidDataSource();
	}

	// 提供SqlSeesion
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		// 配置数据源
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		// 指定mapper xml目录
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		// 设置数据库类型
		properties.setProperty("dialect", "mysql");
		// 3.3.0版本可用 - 分页参数合理化，默认false禁用
		// 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
		// 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
		properties.setProperty("reasonable", "false");
		// 如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果
		properties.setProperty("pageSizeZero", "true");
		// 该参数默认为false，设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用，和startPage中的pageNum效果一样
		properties.setProperty("offsetAsPageNum", "true");
		// 该参数默认为false，设置为true时，使用RowBounds分页会进行count查询
		properties.setProperty("rowBoundsWithCount", "true");
		// 支持通过Mapper接口参数来传递分页参数
		properties.setProperty("supportMethodsArguments", "true");
		// always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page
		properties.setProperty("returnPageInfo", "true");
		pageHelper.setProperties(properties);
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { pageHelper });

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	/**
	 * 用于加载application.properties中的前缀和后缀
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * Main Start
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("============= SpringBoot Start Success =============");
	}

}
