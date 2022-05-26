package com.test.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ResultExtractor {
				
	
	public static apkBean extractAPKinfo(String fileToCope) {
		
		String path = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\toolResults\\";		
		String fileName = path+fileToCope;
	
		
		
		apkBean a = new apkBean();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
		a.setStartTime(date);
		a.setApkID(MyDAO.get_apk_count()+1);
		
		
		try (Scanner sc = new Scanner(new FileReader(fileName))) { //try-with-resources
		      while (sc.hasNextLine()) {  //按行读取字符串
		         String line = sc.nextLine();
		         extract(line,a);
		        // System.out.println(line);		        		         
		      }
		     		      
//		      MyDAO md = new MyDAO();
//		         ArrayList<apkBean> array = md.select_all_apk();
//		         for(apkBean a: array) {
//		        	 System.out.println(a.toString()); }		      		      		         
		} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return a;				
	}
	
public static ArrayList<permissionBean> extractPermission(String fileToCope, int apkid) {
		
		String path = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\toolResults\\";		
		String fileName = path+fileToCope;
	
		ArrayList<permissionBean> plist = new ArrayList<>();
				
		
		try (Scanner sc = new Scanner(new FileReader(fileName))) { //try-with-resources
		      while (sc.hasNextLine()) {  //按行读取字符串
		         String line = sc.nextLine();
		         extract(line,plist,apkid);
		        // System.out.println(line);		        		         
		      }
		     		      		      		      		         
		} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return plist;				
	}

public static ArrayList<apiBean> extractAPI(String fileToCope, int apkid) {
	
	String path = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\toolResults\\";		
	String fileName = path+fileToCope;

	ArrayList<apiBean> alist = new ArrayList<>();
			
	
	try (Scanner sc = new Scanner(new FileReader(fileName))) { //try-with-resources
	      while (sc.hasNextLine()) {  //按行读取字符串
	         String line = sc.nextLine();
	         extract_api(line,alist,apkid);
	        // System.out.println(line);		        		         
	      }
	     		      		      		      		         
	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	return alist;				
}
	
	
	public static void extract(String line, apkBean a) {
		if(line.startsWith("Analyse")) {
			a.setApkName(line.substring(line.indexOf("upload")+7, line.indexOf('>')));
		}else if(line.startsWith("Permission")) {
			a.setPermission(a.getPermission()+1);
		}else if(line.startsWith("Totally")) {
			a.setAnalysedClass(Integer.parseInt(line.substring(line.indexOf("analysis:")+9, line.indexOf("Classes")-1)));
			a.setAnalysedMethod(Integer.parseInt(line.substring(line.indexOf("Classes")+9, line.indexOf("Methods")-1)));
			a.setAnalysedStatement(Integer.parseInt(line.substring(line.indexOf("Methods")+9, line.indexOf("Statements")-1)));
		}else if(line.startsWith("Apk Size")) {
			a.setApkSize(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("code size")) {
			a.setCodeSize(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("CFG")) {
			a.setCFGTime(Float.parseFloat(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("Fastdroid")) {
			a.setFastDroidTime(Float.parseFloat(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("TaintFlow totally")){
			a.setTaintFlow(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("MayTaintFlow")) {
			a.setMayTaintFlow(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}
						
	}
	
	public static void extract(String line, ArrayList<permissionBean> plist, int apkid) {	
				
		Set<String> dangerous = new HashSet<>();
		Set<String> normal = new HashSet<>();
		Set<String> signature = new HashSet<>();
		Collections.addAll(dangerous, "ACCEPT_HANDOVER","ACCESS_BACKGROUND_LOCATION","ACCESS_COARSE_LOCATION","ACCESS_FINE_LOCATION","ACCESS_MEDIA_LOCATION","ACTIVITY_RECOGNITION","ADD_VOICEMAIL","ANSWER_PHONE_CALLS","BLUETOOTH_ADVERTISE","BLUETOOTH_CONNECT","BLUETOOTH_SCAN","BODY_SENSORS","BODY_SENSORS_BACKGROUND","CALL_PHONE","CAMERA","GET_ACCOUNTS","NEARBY_WIFI_DEVICES","POST_NOTIFICATIONS","PROCESS_OUTGOING_CALLS","READ_CALENDAR","READ_CALL_LOG","READ_CONTACTS","READ_EXTERNAL_STORAGE","READ_MEDIA_AUDIO","READ_MEDIA_IMAGE","READ_MEDIA_VIDEO","READ_PHONE_NUMBERS","READ_PHONE_STATE","READ_SMS","READ_SYNC_SETTINGS","RECEIVE_MMS","RECEIVE_SMS","RECEIVE_WAP_PUSH","RECORD_AUDIO","SEND_SMS","USE_SIP","UWB_RANGING","WRITE_CALENDAR","WRITE_CALL_LOG","WRITE_CONTACTS","WRITE_EXTERNAL_STORAGE");
		Collections.addAll(normal, "ACCESS_LOCATION_EXTRA_COMMANDS","ACCESS_NETWORK_STATE","ACCESS_NOTIFICATION_POLICY","ACCESS_WIFI_STATE","BLUETOOTH","BLUETOOTH_ADMIN","BROADCAST_STICKY","CALL_COMPANION_APP","CHANGE_NETWORK_STATE","CHANGE_WIFI_MULTICAST_STATE","CHANGE_WIFI_STATE","DISABLE_KEYGUARD","EXPAND_STATUS_BAR","FOREGROUND_SERVICE","GET_PACKAGE_SIZE","INSTALL_SHORTCUT","INTERNET","KILL_BACKGROUND_PROCESSES","MANAGE_OWN_CALLS","MODIFY_AUDIO_SETTINGS","NFC","NFC_PREFERRED_PAYMENT_INFO","NFC_TRANSACTION_EVENT","QUERY_ALL_PACKAGES","READ_SYNC_STATS","RECEIVE_BOOT_COMPLETED","REORDER_TASKS","REQUEST_COMPANION_PROFILE_WATCH","REQUEST_COMPANION_RUN_IN_BACKGROUND","REQUEST_COMPANION_START_FOREGROUND_SERVICES_FROM_BACKGROUND","REQUEST_COMPANION_USE_DATA_IN_BACKGROUND","REQUEST_DELETE_PACKAGES","REQUEST_IGNORE_BATTERY_OPTIMIZATIONS","REQUEST_PASSWORD_COMPLEXITY","SET_ALARM","SET_WALLPAPER","SET_WALLPAPER_HINTS","TRANSMIT_IR","UPDATE_PACKAGES_WITHOUT_USER_ACTION","USE_BIOMETRIC","USE_FINGERPRINT","USE_FULL_SCREEN_INTENT","VIBRATE","WAKE_LOCK","WRITE_SYNC_SETTINGS");
		Collections.addAll(signature, "BATTERY_STATS","BIND_ACCESSIBILITY_SERVICE","BIND_AUTOFILL_SERVICE","BIND_CALL_REDIRECTION_SERVICE","BIND_CARRIER_MESSAGING_CLIENT_SERVICE","BIND_CARRIER_SERVICES","BIND_CHOOSER_TARGET_SERVICE","BIND_CONDITION_PROVIDER_SERVICE","BIND_DEVICE_ADMIN","BIND_DREAM_SERVICE","BIND_INCALL_SERVICE","BIND_INPUT_METHOD","BIND_MIDI_DEVICE_SERVICE","BIND_NFC_SERVICE","BIND_NOTIFICATION_LISTENER_SERVICE","BIND_PRINT_SERVICE","BIND_QUICK_ACCESS_WALLET_SERVICE","BIND_REMOTEVIEWS","BIND_SCREENING_SERVICE","BIND_TELECOM_CONNECTION_SERVICE","BIND_TEXT_SERVICE","BIND_TV_INPUT","BIND_TV_INTERACTIVE_APP","BIND_VISUAL_VOICEMAIL_SERVICE","BIND_VOICE_INTERACTION","BIND_VPN_SERVICE","BIND_VR_LISTENER_SERVICE","BIND_WALLPAPER","CHANGE_CONFIGURATION","CLEAR_APP_CACHE","DELETE_CACHE_FILES","GET_ACCOUNTS_PRIVILEGED","GLOBAL_SEARCH","HIGH_SAMPLING_RATE_SENSORS","INSTANT_APP_FOREGROUND_SERVICE","LOADER_USAGE_STATS","MANAGE_EXTERNAL_STORAGE","MANAGE_MEDIA","MANAGE_ONGOING_CALLS","PACKAGE_USAGE_STATS","READ_VOICEMAIL","REQUEST_INSTALL_PACKAGES","START_VIEW_APP_FEATURES","START_VIEW_PERMISSION_USAGE","SYSTEM_ALERT_WINDOW","USE_ICC_AUTH_WITH_DEVICE_IDENTIFIER","WRITE_SETTINGS","WRITE_VOICEMAIL");
		
		
		if(line.startsWith("Permission")) {
			permissionBean pb = new permissionBean();
			pb.setPid(MyDAO.get_permission_count()+plist.size()+1);
			pb.setApkid(apkid);
			String pName = line.substring(line.indexOf("permission")+11, line.indexOf('>'));
			pb.setPname(pName);
			if(dangerous.contains(pName)) {
				pb.setPlevel("dangerous");
			}else if(normal.contains(pName)) {
				pb.setPlevel("normal");
			}else if(signature.contains(pName)) {
				pb.setPlevel("signature");
			}else {
				pb.setPlevel("others");
			}
			
			plist.add(pb);
			System.out.println(pb.toString()+"permission提取成功");
		}
	}
	
		
		public static void extract_api(String line, ArrayList<apiBean> alist, int apkid) {	
			
			
			if(line.startsWith("Source")) {
				
				apiBean ab = new apiBean();
				ab.setAid(MyDAO.get_api_count()+alist.size()+1);
				ab.setApkid(apkid);
				ab.setAname(line.substring(line.indexOf("<")+1,line.indexOf(")>(")+1));
				ab.setCaller(line.substring(line.indexOf("SL [")+4,line.indexOf(", No.")));
				ab.setRouteType("Source");
				alist.add(ab);
				System.out.println(ab.toString()+"API提取成功");
			}else if(line.startsWith("Sink")) {
				apiBean ab = new apiBean();
				ab.setAid(MyDAO.get_api_count()+alist.size()+1);
				ab.setApkid(apkid);
				ab.setAname(line.substring(line.indexOf("<")+1,line.indexOf(")>")+1));
				ab.setCaller(line.substring(line.indexOf("SL [")+4,line.indexOf(", No.")));
				ab.setRouteType("Sink");
				alist.add(ab);
				System.out.println(ab.toString()+"API提取成功");
			}
		
	}
	
	



}
