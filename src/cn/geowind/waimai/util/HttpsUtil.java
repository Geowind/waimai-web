package cn.geowind.waimai.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * 
 * 
 * @author ÖìËª
 * @school University of South China
 * @date
 */
public class HttpsUtil {

	public static byte[] get(String urlString) throws IOException {
		byte[] data = null;
		HttpsURLConnection conn = getConnection(urlString);
		conn.setRequestMethod("GET");
		if (conn.getResponseCode() == 200) {
			InputStream is = conn.getInputStream();
			data = readInputStream(is);
		} else {
			data = conn.getResponseMessage().getBytes();
		}
		return data;
	}

	private static HttpsURLConnection getConnection(String urlString)
			throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(urlString);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		// conn.setRequestMethod("GET");
		conn.setDoInput(true);
		conn.setReadTimeout(5000);
		conn.addRequestProperty(ApiUtil.HEAD_APP_ID, ApiUtil.APP_ID);
		conn.addRequestProperty(ApiUtil.HEAD_APP_KEY, ApiUtil.APP_KEY);
		X509TrustManager xtm = new X509TrustManager() {

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {

			}

			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {

			}
		};
		TrustManager[] tm = { xtm };
		try {
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, tm, null);
			conn.setSSLSocketFactory(sslContext.getSocketFactory());
			conn.setHostnameVerifier(new HostnameVerifier() {

				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static String get(String urlString, String charset)
			throws UnsupportedEncodingException, IOException {
		return new String(get(urlString), charset);
	}

	public static String put(String url,String data) throws MalformedURLException,
			ProtocolException, IOException {
		byte[] d = null;
		String str = "";
		HttpsURLConnection conn = getConnection(url);
		conn.setRequestMethod("PUT");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		OutputStream out = conn.getOutputStream();
		out.write(data.getBytes("utf-8"));
		out.flush();
		out.close();
		if (conn.getResponseCode() == 200) {
			d = readInputStream(conn.getInputStream());
			return new String(d, "utf-8");
		} else {
			return conn.getResponseMessage();
		}
	}

	public static String delete(String url) throws MalformedURLException,
			IOException {
		HttpsURLConnection conn = getConnection(url);
		conn.setRequestMethod("DELETE");
		if(conn.getResponseCode() == 200){
			return new String(readInputStream(conn.getInputStream()),"utf-8");
		}else {
			return conn.getResponseMessage();
		}
	}

	public static byte[] readInputStream(InputStream is) throws IOException {
		byte[] buff = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		while ((len = is.read(buff)) != -1) {
			baos.write(buff, 0, len);
		}
		baos.flush();
		baos.close();
		is.close();
		return baos.toByteArray();
	}

	public static String post(String url, String data)
			throws MalformedURLException, IOException {
		byte[] d = null;
		HttpsURLConnection conn = getConnection(url);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Content-Length", data.length() + "");
		OutputStream out = conn.getOutputStream();
		out.write(data.getBytes("utf-8"));
		out.flush();
		out.close();
		if (conn.getResponseCode() == 200) {
			d = readInputStream(conn.getInputStream());
			return new String(d, "utf-8");
		} else {
			return conn.getResponseMessage();
		}
	}

}
