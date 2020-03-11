package com.wpp.common.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * XSS 过滤器
 */
public class XSSFilter implements Filter {
    private List<String> exclusions;
    private final static String EXCLUSIONS = "exclusions";
    private final static String EXCLUSIONS_SEPARATOR = ",";
    private FilterConfig filterConfig;

    public List<String> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<String> exclusions) {
        this.exclusions = exclusions;
    }

    public XSSFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

        if (this.exclusions == null) {
            this.exclusions = new ArrayList<>();
        }

        String initParameter = this.filterConfig.getInitParameter(EXCLUSIONS);
        if (initParameter != null && !"".equals(initParameter.trim())) {
            String[] urls = initParameter.split(EXCLUSIONS_SEPARATOR);
            exclusions.addAll(Arrays.asList(urls));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            String path = req.getServletPath();
            if (exclusions != null && exclusions.contains(path)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(new XSSFilterHttpServletRequestWrapper(req), servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
