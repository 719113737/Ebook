package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * SpringSecurity配置文件
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法级别的权限认证
public class SecurityCofigure extends WebSecurityConfigurerAdapter {


    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    MyInvocationSecurityMetadataSourceService myInvocationSecurityMetadataSourceService;

    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;

    //过滤器配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 登录路由：/login
         * 登录失败跳转路由：/login?error
         * 登录成功路由：默认/login?logout，现在改为/login_success
         * 拒绝访问路由:/error
         */
        http
                .authorizeRequests()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                        o.setSecurityMetadataSource(myInvocationSecurityMetadataSourceService);
//                        o.setAccessDecisionManager(myAccessDecisionManager);
//                        return o;
//                    };
//                })
                .antMatchers("/", "/img/**", "/css/**", "/js/**", "/pdf/**", "/pdfjs/**", "/abstract", "/preview", "/register", "/preview_file").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login").defaultSuccessUrl("/login_success.do")
                    .permitAll()
                    .and()
                .logout()
                     .logoutUrl("/logout")
                     .invalidateHttpSession(true)
                     .clearAuthentication(true)
                     .deleteCookies("JSESSIONID");
        // 允许加载iframe
        http.headers().frameOptions().disable();
    }


    //Authentication配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("ljl").password("123456").roles("ADMIN");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoderImpl();
    }
}
