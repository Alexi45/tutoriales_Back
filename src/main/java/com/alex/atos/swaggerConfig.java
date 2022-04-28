package com.alex.atos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


// TODO: Auto-generated Javadoc
/**
 * The Class swaggerConfig.
 */
@Configuration
public class swaggerConfig {
	 
 	/**
 	 * Api.
 	 *
 	 * @return the docket
 	 */
 	@Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(
	                  RequestHandlerSelectors
	                  .basePackage("com.alex.atos"))
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
}
