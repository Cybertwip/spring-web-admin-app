package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;

import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;

@SpringBootApplication(scanBasePackages = { "hello" })
public class Application {

    @Autowired
    private ThymeleafProperties properties;

    @Value("${spring.thymeleaf.templates_root:}")
    private String templatesRoot;


    public static void main(String[] args){

        SpringApplication.run(Application.class, args);

    }

    @Bean
    public ITemplateResolver defaultTemplateResolver() {
        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setSuffix(properties.getSuffix());
        resolver.setPrefix(templatesRoot);
        resolver.setTemplateMode(properties.getMode());
        resolver.setCacheable(properties.isCache());
        return resolver;
    }
}
