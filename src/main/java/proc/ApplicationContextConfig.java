package proc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@Configuration
@ComponentScan(basePackages = "web")
@EnableWebMvc
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{

	@Bean(name = "viewResolver")
    TilesViewResolver viewResolver(){
        TilesViewResolver viewResolver = new TilesViewResolver();
        return viewResolver;
    }

	@Bean(name = "tilesConfigurer")
	TilesConfigurer tilesConfigurer(){
	     TilesConfigurer tilesConfigurer = new TilesConfigurer();
	     tilesConfigurer.setDefinitions("/WEB-INF/view/**/views.xml");
	         
	     tilesConfigurer.setPreparerFactoryClass(
	     org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
	     return tilesConfigurer;    
	}

	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
