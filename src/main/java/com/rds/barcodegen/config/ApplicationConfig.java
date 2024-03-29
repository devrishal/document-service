package com.rds.barcodegen.config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ITemplateResolver foTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.XML);
        templateResolver.setOrder(1);
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".fo");
        return templateResolver;
    }

    @Bean
    public ITemplateResolver xmlTemplateResolver() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setOrder(2);
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".xml");
        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode(TemplateMode.XML);
        return templateResolver;
    }

    @Bean
    public TemplateEngine templateProcessorEngine() {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addTemplateResolver(foTemplateResolver());
        templateEngine.addTemplateResolver(xmlTemplateResolver());
        return templateEngine;
    }
}
