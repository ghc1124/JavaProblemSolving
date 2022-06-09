package test;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import javax.swing.*;

public class CurrencyDownloadThread extends Thread{
	
	private String currencyName;
	private double exchangeRate;
	private String dateString;
	
	String url;
	callback callback;
	
	
	public CurrencyDownloadThread(String url, callback obj) {
		this.url = url;
		this.callback = obj;
	}
	/*public static void updateCurrencyData(String currencyName, double exchangeRate) {
		er.put(currencyName, exchangeRate);
	}*/
	
	
	public void getLatestCurrency() {
		 String line = "";
		 int responseCode = 0;
		 
		 try {
			 URL currencyUrl = new URL(url);
			 HttpURLConnection httpConn = (HttpURLConnection)currencyUrl.openConnection();
			 httpConn.setRequestMethod("GET");
			 responseCode = httpConn.getResponseCode();
			 System.out.println("responseCode: " + responseCode);
			 if(responseCode == HttpURLConnection.HTTP_OK) {
				 InputStreamReader inReader = new 
						 InputStreamReader(httpConn.getInputStream(), "euc-kr");
				 BufferedReader reader = new BufferedReader(inReader);
				 while((line = reader.readLine()) != null) {
					 // 아래 문자열을 만나면 Html 문서를 파싱하기 시작
					 if(line.contains("<td class='nation'>")) {						 
						 String[] cd1 = line.split("</td>");
						 String cd11 = cd1[0];						 
						 String[] cd2 = cd11.split("/>");
						 String cd21 = cd2[1];
						 currencyName = cd21;
						 
						 String str = reader.readLine();
						 String []cd3 = str.split("</td>");
						 String cd31 = cd3[0];
						 String []cd4 = cd31.split(">");
						 String cd41 = cd4[1];
						 double exchangeRate = Double.parseDouble(cd41);
						 
						 callback.updateCurrencyData(currencyName, exchangeRate);
						 
						 //System.out.println(currencyName + exchangeRate);

						 
					 }
					 // 아래 문자열을 만나면 Html 파싱을 종료함
					 if(line.contains("<div class='date'>")) {
						 // 가장 최신에 업데이트 된 날짜를 저장
						 dateString = reader.readLine();
						 dateString = dateString.substring(3);
						 String[] d = dateString.split("</p>");
						 dateString = d[0];
						 callback.updateLatestDate(dateString);						 
						 break;
					 }
				 }
				 httpConn.disconnect();
				 inReader.close();
				 reader.close();
			 }
		 } catch (Exception e) {
		 		e.printStackTrace();
		 }
	}
	
	public void run() {
		while(true) {
			getLatestCurrency();
			try {
				Thread.sleep(60000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class callback {
	String url;
	CurrencyDownloadThread currencyDownloadThread;
	String date;
	static HashMap<String, Double> er = new HashMap<String, Double>();
	
	public callback(String url) {
		this.url = url;
		
		currencyDownloadThread = new CurrencyDownloadThread(url, this);
		currencyDownloadThread.start();
	}
	
	public void updateCurrencyData(String currencyName, Double exchangeRate) {
		if(currencyName.equals("1USD")) {
			currencyName = "미국 USD";
		}
		
		else if(currencyName.equals("100&yen;")) {
			currencyName = "일본 JPY(100 엔";
		}
		
		else if(currencyName.equals("1EUR")) {
			currencyName = "EU(EURO)";
		}
		
		else if(currencyName.equals("1CNY")) {
			currencyName = "중국 CNY";
		}
		er.put(currencyName, exchangeRate);
		System.out.println(er);
	}
	
	public void updateLatestDate(String dateString) {
		date = dateString;
		System.out.println(dateString);
	}
	
}


