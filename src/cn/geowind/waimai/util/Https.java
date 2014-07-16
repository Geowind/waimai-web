package cn.geowind.waimai.util;

//import java.net.*;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.io.*;
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLSession;
//import sun.misc.BASE64Encoder;

/**
 * Demonstrates usage of the REST Binding API with HTTPS. Creates a project
 * according to a given XML file.
 */
//public class Https {
//	package test;

import static cn.geowind.waimai.util.ApiUtil.API_VERSION;
import static cn.geowind.waimai.util.ApiUtil.BASE_URL;
import static cn.geowind.waimai.util.ApiUtil.CLASSES;

import java.io.InputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import cn.geowind.waimai.beans.Restaurant;

public class Https {

	public static void main(String[] args) {
		new Https().doMain();
		System.out.println("DONE");
	}

	public void doMain() {
		String hsUrl = "https://localhost:8443/testApp/hel.jsp";
		hsUrl = "https://google.com";
		hsUrl = "https://vip1.icbc.com.cn/icbc/perbank/index.jsp";
		URL url;
		String strUrl = BASE_URL + "/" + API_VERSION + CLASSES + "/"
				+ Restaurant.CLASS_NAME;

		try {
			url = new URL(strUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			X509TrustManager xtm = new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkServerTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {

				}

				public void checkClientTrusted(X509Certificate[] arg0,
						String arg1) throws CertificateException {

				}
			};

			TrustManager[] tm = { xtm };

			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, tm, null);

			con.setSSLSocketFactory(ctx.getSocketFactory());
			con.setHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setReadTimeout(5000);
			con.addRequestProperty(ApiUtil.HEAD_APP_ID, ApiUtil.APP_ID);
			con.addRequestProperty(ApiUtil.HEAD_APP_KEY, ApiUtil.APP_KEY);
			if (con.getResponseCode() == 200) {
				InputStream is = con.getInputStream();
				String data = new String(HttpsUtil.readInputStream(is));
				System.out.println("data" + data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
