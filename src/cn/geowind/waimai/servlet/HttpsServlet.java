package cn.geowind.waimai.servlet;

import static cn.geowind.waimai.util.ApiUtil.API_VERSION;
import static cn.geowind.waimai.util.ApiUtil.BASE_URL;
import static cn.geowind.waimai.util.ApiUtil.CLASSES;
import static cn.geowind.waimai.util.ApiUtil.LOGIN;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import cn.geowind.waimai.beans.Food;
import cn.geowind.waimai.beans.Restaurant;
import cn.geowind.waimai.beans.User;
import cn.geowind.waimai.util.HttpsUtil;

/**
 * 
 * 
 * @author ��˪
 * @school University of South China
 * @date
 */
public class HttpsServlet extends HttpServlet {

	private static final long serialVersionUID = -8753775108300167415L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI();
		System.out.println(" HttpsServlet process() uri:" + uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		if (action.equals("login")) {
			login(request, response);
		} else if (action.equals("edit")) {
			edit(request, response);
		} else if (action.equals("menu")) {
			menu(request, response);
		} else if (action.equals("detail")) {
			System.out.println(request.getRequestURL() + "foodItem"
					+ request.getParameter("foodItem"));
			String foodId = request.getParameter("foodId");
		} else if (action.equals("update")) {
			update(request, response);
		} else if (action.equals("add")) {
			add(request, response);
		} else if (action.equals("delete")) {
			delete(request, response);
		} else if (action.equals("info")) {
			info(request, response);
		} else if (action.equals("logout")) {
			logout(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userId = request.getParameter("userId");
		String restaurantName = request.getParameter("restaurantName");
		if (userId.equals(user.getUserId())) {
			session.removeAttribute("user");
			try {
				PrintWriter out = response.getWriter();
				out.println("status:1");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				PrintWriter out = response.getWriter();
				out.println("status:0");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

//		try {
//			response.sendRedirect("login.jsp");
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		// try {
		// request.getRequestDispatcher("login.jsp").forward(request, response);
		// } catch (ServletException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	private void info(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		String restaurantId = user.getRestaurantId();
		String url = BASE_URL + "/" + API_VERSION + CLASSES + "/"
				+ Restaurant.CLASS_NAME + "/" + restaurantId;
		try {
			String json = HttpsUtil.get(url, "utf-8");
			System.out.println("info json" + json);
			Restaurant restaurant = Restaurant.fromJson(json);
			request.setAttribute("shop", restaurant);
			request.getRequestDispatcher("info.jsp").forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		Food food = getFood(request);
		String data = "";
		try {
			data = food.toJson();
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		String url = BASE_URL + "/" + API_VERSION + CLASSES + "/"
				+ Food.CLASS_NAME;
		System.out.println("add.jsp url :" + data);
		try {
			String json = HttpsUtil.post(url, data);
			System.out.println("add.jsp json :" + json);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out
					.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("<script>alert(\"增加菜品成功\");" +
					"location.href='menu'</script>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Food getFood(HttpServletRequest request)
			throws NumberFormatException {
		Food food = new Food();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		User user = (User) request.getSession().getAttribute("user");
		food.setName(request.getParameter("name"));
		int price = Integer.parseInt(request.getParameter("price"));
		food.setPrice(price);
		food.setImg("http://pager.u.qiniudn.com/pager04.png");
		food.setCategory(request.getParameter("category"));
		food.setRestaurant(user.getRestaurantName());
		food.setRestaurantId(user.getRestaurantId());
		String rank = "0";
		if (price >= 1 && price < 7) {
			rank = "0";
		} else if (price >= 8 && price <= 10) {
			rank = "1";
		} else if (price >= 11 && price <= 15) {
			rank = "2";
		} else if (price >= 16) {
			rank = "3";
		}
		food.setRank(rank);
		// food.setDescription(request.getParameter("description"));
		food.setRestaurantTel("18975679179");
		return food;
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String foodId = (String) request.getParameter("foodId");
		String url = BASE_URL + "/" + API_VERSION + CLASSES + "/"
				+ Food.CLASS_NAME + "/" + foodId;
		String result = "";
		try {
			result = HttpsUtil.delete(url);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out
					.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <BODY>");
			out.println("<br/> <center><p>删除成功.<a href='menu'>点击返回</a></p></center>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String foodId = request.getParameter("foodId");
		String url = BASE_URL + "/" + API_VERSION + CLASSES + "/Food/" + foodId;
		try {
			String json = getFood(request).toJson();
			System.out.println("update food.tojson:" + json);
			String result = HttpsUtil.put(url, json);
			System.out.println("update result:" + result);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out
					.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("<script>alert(\"菜品资料更新成功\");" +
					"location.href='menu'</script>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} //catch (ServletException e) {
//			e.printStackTrace();
//		}
		
	}

	private void menu(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException, ServletException {
		User user = (User) request.getSession().getAttribute("user");
		String where = "?where={\"" + Food.RESTURANT_ID + "\":\""
				+ user.getRestaurantId() + "\"}";
		String url = BASE_URL + "/" + API_VERSION + CLASSES + "/Food" + where;
		String json = HttpsUtil.get(url, "utf-8");
		List<Food> list = new ArrayList<Food>();
		try {
			list = Food.fromJsonToList(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException, ServletException {
		String foodId = request.getParameter("foodId");
		String url = BASE_URL + "/" + API_VERSION + CLASSES + "/"
				+ Food.CLASS_NAME + "/" + foodId;
		String json = HttpsUtil.get(url, "utf-8");
		System.out.println("edit foodId" + foodId + "edit json " + json);
		try {
			Food food = Food.fromJson(json);
			request.setAttribute("food", food);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url = BASE_URL + "/" + API_VERSION + LOGIN + "?username="
				+ username + "&password=" + password;
		String json = HttpsUtil.get(url, "utf-8");
		User user = null;
		try {
			user = User.fromJson(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (user == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out
					.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("<script>alert(\"用户名或密码错误\");" +
					"history.back();</script>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			return;
		}
		request.getSession().setAttribute("user", user);
		// request.getRequestDispatcher("/").forward(request, response);
		System.out.println("contextPath:" + request.getContextPath());
		response.sendRedirect(request.getContextPath());
	}
}
