package com.ecom.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;
import com.ecom.util.AppConstant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String email = request.getParameter("username");
		UserDtls userDtls = userRepository.findByEmail(email);

		if (userDtls.getIsEnable()) {

			if (userDtls.getAccountNonLocked()) {

				if (userDtls.getFailedAttempt() < AppConstant.ATTEPT_TIME) {
					userService.increaseFailedAttempt(userDtls);
				} else {
					userService.userAccountLock(userDtls);
					exception = new LockedException("your Account is Locked  !! failes attempt 3");
				}

			} else {

				if (userService.unLockAccountTimeExpired(userDtls)) {
					exception = new LockedException("your Account is Unlocked !! please Try Again");
				} else {

					exception = new LockedException("your Account is Locked !! Please Try After Sometime");

				}
			}

		} else {
			exception = new LockedException("your Account is inactive");
		}

		super.setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}

}