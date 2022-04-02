package com.test.demo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PermissionTransfer {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/testdb?user=root";
    Connection con = DriverManager.getConnection(url,"root","4goyaxiabsj");
    
    String sql1 = "insert into sink values(1,'interfaceinvoke','<android.content.SharedPreferences$Editor: android.content.SharedPreferences$Editor putString(java.lang.String,java.lang.String)>(\"imei\", $r4)','<edu.mit.event_context_shared_pref_listener.MainActivity: void onCreate(android.os.Bundle)>')";
    String sql2 = "insert into source values(1,'virtualinvoke','<android.telephony.TelephonyManager: java.lang.String getDeviceId()>()','<edu.mit.event_context_shared_pref_listener.MainActivity: void onCreate(android.os.Bundle)>')";
    Statement stm = con.createStatement();
    int count = stm.executeUpdate(sql1);
    count = stm.executeUpdate(sql2);
    System.out.println(count);
    stm.close();
    con.close();
}
}
