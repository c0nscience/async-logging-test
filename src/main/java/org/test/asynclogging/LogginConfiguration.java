package org.test.asynclogging;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.springframework.web.logging.LoggingFilter;

/**
 * User: bherzig
 * Date: 22/09/15
 * Time: 15:49
 */
@Configuration
public class LogginConfiguration {

    @Bean
    public FilterRegistrationBean loggingFilter() {
        final LoggingFilter filter = new LoggingFilter();
        final FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        registration.addUrlPatterns("/api/*");
        registration.setOrder(filter.getOrder());
        return registration;
    }
}
