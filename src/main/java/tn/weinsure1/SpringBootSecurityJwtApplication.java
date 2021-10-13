package tn.weinsure1;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;




//@EnableAutoConfiguration
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )
public class SpringBootSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
    }

	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
	FacesServlet servlet = new FacesServlet();
	return new ServletRegistrationBean<FacesServlet>(servlet,"*.jsf"); }

}



