package com.crowdintelligence.demo.interceptor;

import com.crowdintelligence.demo.context.TenantContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class TenantInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // For MVP, read tenant from header. Later: extract from JWT or subdomain.
        String tenantId = request.getHeader("X-Tenant-Id");
        if (tenantId == null || tenantId.isBlank()) {
            // You can relax this for local dev if you want
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        TenantContext.setTenantId(tenantId);
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest re, HttpServletResponse res, Object handler, Exception ex) {
        TenantContext.clear();
    }
}
