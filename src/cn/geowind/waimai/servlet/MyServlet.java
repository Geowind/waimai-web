package cn.geowind.waimai.servlet;

import static cn.geowind.waimai.util.ApiUtil.API_VERSION;
import static cn.geowind.waimai.util.ApiUtil.BASE_URL;
import static cn.geowind.waimai.util.ApiUtil.CLASSES;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.geowind.waimai.beans.Restaurant;
import cn.geowind.waimai.util.HttpsUtil;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 4381852768116951094L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// CloseableHttpClient httpClient = HttpClients.createDefault();
		// URI uri = null;
		// String json = "";
		// try {
		// uri = new URIBuilder().setScheme("https").setHost(
		// "cn.avoscloud.com").setPath("/1/login").setParameter(
		// "username", "11111111111").setParameter("password", "1")
		// .build();
		// HttpGet httpGet = new HttpGet(uri);
		// httpGet.setHeader(HEAD_APP_ID, APP_ID);
		// httpGet.setHeader(HEAD_APP_KEY, APP_KEY);
		// CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		// HttpEntity httpEntity = httpResponse.getEntity();
		// json = new
		// String(HttpsUtil.readInputStreawm(httpEntity.getContent()),"utf-8");
		// } catch (URISyntaxException e) {
		// e.printStackTrace();
		// }
		// String uri = req.getRequestURI();
		System.out.println("MyServlet");
		// resp.setCharacterEncoding("utf-8");
		// resp.setHeader("content-type","text/html;charset=UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String url = BASE_URL + "/" + API_VERSION + CLASSES + "/"
				+ Restaurant.CLASS_NAME;
		// String url = "https://pager.u.qiniudn.com/shuoming.html";
		// String url = BASE_URL + "/" +API_VERSION + ApiUtil.LOGIN +
		// "?username=11111111111&password=1";
		writer.println("<html><head><title>Restaurant</title>" + "</head>"
				+ "<body><h1>Welcome to my restaurant! :)这是我的外卖店</h1>");
		String json = new String(HttpsUtil.get(url), "utf-8");
		writer.println("<h2>网址：" + url + "<h2>");
		writer.println("<p>" + json + "<p>");
		writer.println("</body></html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doDelete(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPut(req, resp);
	}

}
