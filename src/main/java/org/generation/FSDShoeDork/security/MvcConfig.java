package org.generation.FSDShoeDork.security;

//https://docs.google.com/document/d/1yhP4mo_KcNdLCTC9tooUjJ8mkkvTXJzY/edit - adjust once frontend is complete

//This Class will implement the WebMvcConfigurer interface provided by Spring Boot
// Framework
//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/WebMvcConfigurer.html

//This Class is to perform action on URL Routing and mapping when a HTTP request comes in
//E.g. if user key in localhost:8080 in the browser, browser will send a HTTP GET
// request to the server (back-end). The back-end will need to handle which HTML to
// response back to the browser (client) - index.html


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.beans.factory.annotation.Value;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Value("${image.folder}")
    private String imageFolder; //now imageFolder variable the value = productimages


    public void addViewControllers(ViewControllerRegistry registry) {
        //Map the browser's URL to a specific View (HTML) inside resources/templates directory
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/aboutus").setViewName("aboutus");
        registry.addViewController("/product").setViewName("product");
        registry.addViewController("/productform").setViewName("productform");
        registry.addViewController("/cart").setViewName("cart");
        registry.addViewController("/shop").setViewName("shop");
        registry.addViewController("/upload").setViewName("upload");
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/test2").setViewName("test2");

        //registry.addViewController("/login").setViewName("login");
        //registry.addViewController("/logout").setViewName("index");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);

        Path uploadDir = Paths.get(imageFolder);
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/" + imageFolder + "/**")
                .addResourceLocations("file:" + uploadPath + "/")
                .setCachePeriod(0);



    }

}
