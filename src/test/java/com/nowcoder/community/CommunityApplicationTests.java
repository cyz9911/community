package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
//TODO @ContextConfiguration在测试代码中使用启动类CommunityApplication作为配置类，就能使用启动类中的东西
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Override
	// todo ！！！一个类实现了ApplicationContextAware接口的方法setApplicationContext，Spring容器会调用这个类的setApplicationContext方法，
	//  		将自身ApplicationContext传进来，从而让这个类得到IoC容器
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO IoC容器（ApplicationContext）被传进来，我们用this.applicationContext保存这个Ioc容器，在其他地方就可以使用IoC容器
		this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext(){	// 在这个地方使用IoC容器
		// TODO 获取装配到IoC中的Bean：根据Bean的类型挑选IoC内的Bean
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());	// todo 调用这个Bean中的select()
		// todo 根据Bean的名字来挑选Ioc内的Bean
		alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBeanManagement() {
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}
}
