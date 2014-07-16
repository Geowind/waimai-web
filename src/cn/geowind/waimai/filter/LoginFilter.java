package cn.geowind.waimai.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// String uri = config.getInitParameter("abortFilterUri");
		String uri = req.getRequestURI();
		String path = req.getServletPath();
		System.out.println("uri:" + uri);
		System.out.println("path:" + path);
		if (!(path.equals("/login.jsp") || path.equals("/login"))) {
			if (req.getSession().getAttribute("user") == null) {
				// if (uri.endsWith("login.jsp")) {
				System.out.println("doFilter");
				// req.getRequestDispatcher("login.jsp")
				// .forward(request, response);
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect("login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

}
