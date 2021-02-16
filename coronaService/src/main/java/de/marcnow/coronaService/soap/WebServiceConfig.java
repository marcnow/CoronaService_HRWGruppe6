package de.marcnow.coronaService.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;

@EnableWs
@Configuration
public class WebServiceConfig {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/soap/*");
	}
		
	@Bean(name = "covidkeyindicators")
	public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema covidKeyIndicatorsSchema) {
		
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("CovidKeyIndicatorsPort");
		definition.setTargetNamespace("coronaservice-grp6");
		definition.setLocationUri("/soap");
		definition.setSchema(covidKeyIndicatorsSchema);
		return definition;
	}
	
	@Bean
	public XsdSchema covidKeyIndicatorsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("covidkeyindicators.xsd"));
	}
}
