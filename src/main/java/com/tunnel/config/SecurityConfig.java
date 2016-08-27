package com.tunnel.config;


import com.tunnel.exception.AppAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authProvider;

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Configuration
    @Order(1)
    public static class ApiConfigurationAdapter extends WebSecurityConfigurerAdapter {
    	
//    	@Override
//	    public void configure(WebSecurity web) throws Exception {
//	        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//	    }

        protected void configure(HttpSecurity http) throws Exception {


            http.csrf().disable();

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

            http.authorizeRequests()
                    .antMatchers("/user/register/**","/login", "/index.html").permitAll()
                    .antMatchers("/**")
                    .authenticated()
                    .and()
                    .httpBasic()
                    .authenticationEntryPoint(new RestAuthEntryPoint())
                    .and()
                    /*.formLogin()
                    .usernameParameter("username")
                    .passwordParameter("pwd")*/
                    //.failureHandler(new AuthFailureHandler())
                    /*.successHandler(new AuthenticationSuccessHandler() {
                        private ObjectMapper mapper = new ObjectMapper();

                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                            Authentication authentication) throws IOException,
                                ServletException {
                            response.setStatus(HttpServletResponse.SC_OK);
                            response.getOutputStream().println(mapper.writeValueAsString(AuthUtil.getUserDetails()));

                        }
                    })*/
                    //.and()
                    .logout()
                    .invalidateHttpSession(true)
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(new MyLogoutSuccessHandler());
//            http.exceptionHandling();


        }
    }

    private static class MyLogoutSuccessHandler implements LogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {
            authentication.setAuthenticated(false);
        }
    }

    private static class RestAuthEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authException) throws IOException, ServletException {
        	if(HttpMethod.OPTIONS.matches(request.getMethod())){
                response.setStatus(HttpServletResponse.SC_OK);
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, request.getHeader(HttpHeaders.ORIGIN));
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS));
                response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD)); 
                return;
            }
        	
            response.setHeader("WWW-Authenticate", "FormBased");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            final String msgFormat = "{ \"message\": \"";
            if (authException instanceof AppAuthException) {
            	response.getWriter().println(msgFormat + ((AppAuthException) authException).getMsg() + "\" }");
            } else {
            	response.getWriter().println(msgFormat + authException.getMessage() + "\" }");
            }
        }
    }

    private static class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                            AuthenticationException exception) throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("{ \"message\": \"" + exception.getMessage() + "\" }");
        }
    }
}