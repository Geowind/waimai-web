package cn.geowind.waimai.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Food实体类
 * 
 * @author 朱霜
 * @school University of South China
 * @date 2013.12
 */
public class Food implements Serializable {
	private static final long serialVersionUID = -1752889128847122862L;

	private String foodId;
	private String name;
	private String img;
	private int price;
	private int oldPrice;
	private String rank;
	private boolean specilty;
	private String description;
	private String category;
	private String restaurantId;
	private String restaurant;
	private String restaurantTel;

	/**
	 * 服务器端数据库中对应表中的列名
	 */
	public static final String CLASS_NAME = "Food";
	public static final String OBJECT_ID = "objectId";
	public static final String NAME = "name";
	public static final String IMG_URL = "img";
	public static final String PRICE = "price";
	public static final String OLD_PRICE = "oldPrice";
	public static final String RANK = "rank";
	public static final String SPECILTY = "specilty";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String RESTURANT = "restaurant";
	public static final String RESTURANT_ID = "restaurantId";
	public static final String RESTURANT_TEL = "restaurantTel";

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public boolean isSpecilty() {
		return specilty;
	}

	public void setSpecilty(boolean specilty) {
		this.specilty = specilty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getRestaurantTel() {
		return restaurantTel;
	}

	public void setRestaurantTel(String restaurantTel) {
		this.restaurantTel = restaurantTel;
	}

	public static List<Food> fromJsonToList(String json) throws JSONException {
		List<Food> list = new ArrayList<Food>();
		JSONObject jsonObject = new JSONObject(json);
		JSONArray result = jsonObject.getJSONArray("results");
		int len = result.length();
		for (int i = 0; i < len; i++) {
			// System.out.println("result item json" + result.getString(i));
			// JSONObject obj = result.getJSONObject(i);
			list.add(fromJson(result.getString(i)));
		}
		return list;
	}

	public static Food fromJson(String json) throws JSONException {
		Food food = new Food();
		JSONObject obj = new JSONObject(json);
		food.setFoodId(obj.getString("objectId"));
		food.setName(obj.getString(NAME));
		food.setImg(obj.getString(IMG_URL));
		food.setPrice(obj.getInt(PRICE));
		food.setRestaurant(obj.getString(RESTURANT));
		food.setRestaurantId(obj.getString(RESTURANT_ID));
		food.setRestaurantTel(obj.getString(RESTURANT_TEL));
		food.setRank(obj.getString(RANK));
		food.setCategory(obj.getString(CATEGORY));
		return food;
	}

	public String toJson() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put(NAME, name);
		obj.put(PRICE, price);
		obj.put(IMG_URL, img);
		obj.put(CATEGORY, category);
		obj.put(RESTURANT, restaurant);
		obj.put(RESTURANT_ID, restaurantId);
		obj.put(RESTURANT_TEL, restaurantTel);
		obj.put(RANK, rank);
//		obj.put(DESCRIPTION, description);
		return obj.toString();
	}

}
