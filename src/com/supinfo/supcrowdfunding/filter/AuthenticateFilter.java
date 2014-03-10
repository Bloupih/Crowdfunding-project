	

    package com.supinfo.supcrowdfunding.filter;
     
    import java.io.IOException;
     
    import javax.servlet.Filter;
    import javax.servlet.FilterChain;
    import javax.servlet.FilterConfig;
    import javax.servlet.ServletException;
    import javax.servlet.ServletRequest;
    import javax.servlet.ServletResponse;
    import javax.servlet.annotation.WebFilter;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
     
    @WebFilter(urlPatterns = "/auth/*")
    public class AuthenticateFilter implements Filter {
     
            @Override
            public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException,
                            ServletException {
     
                    HttpServletRequest httpReq = (HttpServletRequest) req;
                    HttpServletResponse httpResp = (HttpServletResponse) resp;
                    try{
                    int role = (int)httpReq.getSession().getAttribute("role");
                   
                    if (role != 0 && role != 1) {
                            httpResp.sendRedirect(httpReq.getContextPath() + "/login");
                            return;
                    }
     
                    filterChain.doFilter(req, resp);
                    }
                    catch(Exception ex)
                    {
                        httpResp.sendRedirect(httpReq.getContextPath() + "/Index");
                    }
            }
     
            @Override
            public void init(FilterConfig arg0) throws ServletException {
     
            }
     
            @Override
            public void destroy() {
     
            }
     
    }

