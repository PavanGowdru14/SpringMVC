package helper;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.text.View;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"controler","dto","dao","service"})
public class MyConfigaration {

	@Bean 
public EntityManager getEMF()
{
	return Persistence.createEntityManagerFactory("dev").createEntityManager();
}
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver view=new InternalResourceViewResolver();
		view.setSuffix(".jsp");
		return view;
	}
}
