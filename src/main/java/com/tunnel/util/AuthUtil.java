package com.tunnel.util;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;

import com.tunnel.model.User;

import java.nio.charset.Charset;
import com.tunnel.vo.UserVo;

/**
 * Created by Wayne Cao on 2/15/2016.
 */
public class AuthUtil {

    private AuthUtil() {
    }

    public static String getUserName() {
        return (auth() != null) ? auth().getName().toLowerCase() : null;
    }

    public static String getPrincipal() {
        return (auth() != null) ? auth().getPrincipal().toString().toLowerCase() : null;
    }


    public static Authentication auth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static SecurityContext securityContext() {
        return SecurityContextHolder.getContext();
    }

    public static <T> T cred() {
        return (T) auth().getCredentials();
    }

    public static void setUserDetailsInSession() {

        /***************************************
         * TODO:use Spring security to maintain
         **************************************/

        UsernamePasswordAuthenticationToken principal = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        User userDetail = (User) principal.getDetails();
        WebUtils.session().setAttribute(AppConstants.USER_SESSION, userDetail);
    }

    public static void setUserDetailsInSession(User User) {

        /***************************************
         * TODO:use Spring security to maintain
         **************************************/

        UsernamePasswordAuthenticationToken principal = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        User userDetail = (User) principal.getDetails();
        WebUtils.session().setAttribute(AppConstants.USER_SESSION, userDetail);
    }

    public static UserVo getUserDetails() {
        UsernamePasswordAuthenticationToken principal = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        if (principal == null) {
            //being accessed from thread
            return (UserVo) WebUtils.session().getAttribute(AppConstants.USER_SESSION);
        }
        return (UserVo) principal.getDetails();
    }

    /**
     * Builds the authentication
     *
     * @param userName
     * @param pwd
     * @return
     */
    public static HttpHeaders buildAuthHeaders(String userName, String pwd) {

        HttpHeaders headers = new HttpHeaders();
        String auth = userName + ":" + pwd;
        byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.add("Authorization", authHeader);

        return headers;
    }

    public static HttpHeaders buildAuthHeaders() {
        UserVo User = getUserDetails();
        return buildAuthHeaders(User.getLoginId(), User.getPassword());
    }

}
