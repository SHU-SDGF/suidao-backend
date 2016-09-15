package com.tunnel.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.tunnel.exception.AppAuthException;
import com.tunnel.model.User;
import com.tunnel.service.UserService;
import com.tunnel.vo.UserVo;

import java.util.Collections;
import java.util.List;

/**
 * Authenticates the user
 */
@Service
@Slf4j
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication auth) {
        try {
            UserVo userVo = userService.verifyToken(auth.getName(), auth.getCredentials().toString());

            List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("admin"));

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(auth.getName(),
                    auth.getCredentials().toString(), authorities);
            authToken.setDetails(userVo);
            return authToken;
        } catch (Exception ex) {
            log.error("Error occurred while trying to authenticate. \\n Error response body", ex);
            throw new AppAuthException(ex.getMessage(), ex);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}