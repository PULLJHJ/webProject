package com.web.project.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.web.project.user.service.UserInfoService;



@Configuration
public class SecurityBeanConfig {
	@Autowired
	private UserInfoService userInfoService;
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return web -> {
			web.ignoring()
			.antMatchers("/css/**", "/js/**", "/imgs/**", "/resources/**", "/react/**");
		};
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity hs) throws Exception {

		hs.authorizeRequests(req->req
				.antMatchers("/", "/login","/join","/html/join", 
						"/board-infos", "/html/board/board-list",
						"/count-deal-info-by-di-stat", 
						"/chat/countNewMessageChatRoom", "/count-new-message-chat-room")
				.permitAll()
				.antMatchers("/html/admin/**").hasRole("ADMIN")
				.antMatchers("/html/user/**").hasRole("USER")
				.anyRequest().authenticated())
		.formLogin(formLogin->formLogin
				.loginPage("/html/login")
				.usernameParameter("uiId")
				.passwordParameter("uiPwd")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
				.failureUrl("/html/login?error=true")
				.permitAll())

		.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")) // 로그아웃하면 메인 페이지로
		.csrf(csrf->csrf.disable())
		.exceptionHandling(handling -> handling.accessDeniedPage("/html/denied"))
		.userDetailsService(userInfoService);

		return hs.build();
	}
}
