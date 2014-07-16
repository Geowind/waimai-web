package cn.geowind.waimai.beans;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String restaurantName;
	private String restaurantId;

	public static User fromJson(String json) throws JSONException {
		JSONObject obj = new JSONObject(json);
		User user = new User();
		user.setUserId(obj.getString("objectId"));
		user.setRestaurantName(obj.getString("restaurantName"));
		user.setRestaurantId(obj.getString("restaurantId"));
		return user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

}
