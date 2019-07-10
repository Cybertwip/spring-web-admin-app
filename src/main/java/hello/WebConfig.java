package hello;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebConfig {

    /**
     * Configures the /webjars path to pick files from the right place
     * @return
     */
    @Bean
    WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry
                        .addResourceHandler("/webjars/**")
                        .addResourceLocations("/webjars/")
                        .resourceChain(false);
            }
        };
    }

    @Bean
    LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}