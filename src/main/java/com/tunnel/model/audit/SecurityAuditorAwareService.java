package com.tunnel.model.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.tunnel.util.AuthUtil;

@Component
public class SecurityAuditorAwareService implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        String userName = AuthUtil.getUserName();
        return (userName!=null)?userName.toLowerCase():"system";
    }
}