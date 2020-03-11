package com.wpp.common.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * xss实际处理器
 */
public class XSSFilterHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public XSSFilterHttpServletRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values == null) {
            return null;
        }
        String[] safeValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            safeValues[i] = conveterXSS(values[i]);
        }
        return safeValues;
    }

    @Override
    public String getParameter(String name) {
        return conveterXSS(super.getParameter(name));
    }

    @Override
    public String getHeader(String name) {
        return conveterXSS(super.getHeader(name));
    }

    public String conveterXSS(String value) {
        if (value == null) {
            return null;
        }

        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");

        value = value.replaceAll("\\(", "& #40;")
                .replaceAll("\\)", "& #41;");

        value = value.replaceAll("'", "& #39;");

        value = value.replaceAll("eval\\((.*)\\)", "");

        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

        value = value.replaceAll("script", "");

        return value;
    }

}
