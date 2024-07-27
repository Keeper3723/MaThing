package by.leha.myspringapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("by.leha.myspringapp")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

private final ApplicationContext applicationContext;

@Autowired
public SpringConfig(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
}


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
    var templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("classpath:/templates/views/");
    templateResolver.setSuffix(".html");
    return templateResolver;
}
@Bean
    public SpringTemplateEngine templateEngine() {
    var templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver());
    templateEngine.setEnableSpringELCompiler(true);
    return templateEngine;
}

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        registry.viewResolver(viewResolver);

    }





}