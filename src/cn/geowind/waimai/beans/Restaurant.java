package cn.geowind.waimai.beans;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 外卖店JavaBean
 * 
 * @author 朱霜
 * @school University of South China
 * @date
 */
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 7383472021880665448L;
	/**
	 * 服务器端数据库中对应表中的字段
	 */
	public static final String CLASS_NAME = "Restaurant";
	public static final String OBJECT_ID = "objectId";
	public static final String NAME = "name";
	public static final String IMG_URL = "img";
	public static final String TEL1 = "tel1";
	public static final String TEL2 = "tel2";
	public static final String ADDRESS = "address";
	public static final String BUSINESS_TIME = "businessTime";
	public static final String KEYWORDS = "keywords";
	public static final String DETAILS = "details";
	public static final String OTHERS = "others";
	public static final String USRER_ID = "userId";

	private String objectId;
	private String name;
	private String img;
	private String tel1;
	private String tel2;
	private String address;
	private String businessTime;
	private String keywords;
	private String details;
	private String others;

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
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

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public static Restaurant fromJson(String json) throws JSONException {
		Restaurant restaurant = new Restaurant();
		JSONObject obj = new JSONObject(json);
	    restaurant.setObjectId(obj.getString(OBJECT_ID));
	    restaurant.setName(obj.getString(NAME));
	    restaurant.setAddress(obj.getString(ADDRESS));
	    restaurant.setKeywords(obj.getString(KEYWORDS));
	    restaurant.setTel1(obj.getString(TEL1));
	    restaurant.setTel2(obj.getString(TEL2));
	    restaurant.setDetails(obj.getString(DETAILS));
	    restaurant.setBusinessTime(obj.getString(BUSINESS_TIME));
	    restaurant.setOthers(obj.getString(OTHERS));
		return restaurant;
	}


}
