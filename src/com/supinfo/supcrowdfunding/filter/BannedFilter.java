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
     
    import com.supinfo.supcrowdfunding.entity.User;
    import com.supinfo.supcrowdfunding.entity.UserDao;
     
    /**
     * Servlet Filter implementation class BannedFilter
     */
    @WebFilter("/*")
    public class BannedFilter implements Filter {
     
        /**
         * Default constructor.
         */
        public BannedFilter() {
            // TODO Auto-generated constructor stub
        }
     
            /**
             * @see Filter#destroy()
             */
            public void destroy() {
                    // TODO Auto-generated method stub
            }
     
            /**
             * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
             */
            public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
                    // TODO Auto-generated method stub
                    // place your code here
                   
                    if( ((HttpServletRequest)req).getRequestURL().toString().contains("/logout") || ((HttpServletRequest)req).getRequestURL().toString().contains("banned.jsp") || ((HttpServletRequest)req).getRequestURL().toString().matches(".*(css|jpg|png|gif|js)") ){
                        chain.doFilter(req, resp);
                        return;
                    }
                   
                    HttpServletRequest httpReq = (HttpServletRequest) req;
                    HttpServletResponse httpResp = (HttpServletResponse) resp;
                    User usr = UserDao.findUserByPseudo((String)httpReq.getSession().getAttribute("username") );
                   
                    if ( usr != null && usr.getRole() == 2) {
                            httpResp.sendRedirect(httpReq.getContextPath() + "/banned.jsp");
                            return;
                    }
                    // pass the request along the filter chain
                    chain.doFilter(req, resp);
     
            }
     
            /**
             * @see Filter#init(FilterConfig)
             */
            public void init(FilterConfig fConfig) throws ServletException {
                    // TODO Auto-generated method stub
            }
     
    }

