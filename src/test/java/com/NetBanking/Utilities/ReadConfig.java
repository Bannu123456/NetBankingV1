package com.NetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
Properties pro;
public ReadConfig()
{
	File src = new File("./Configurations\\config.properties");
	try
	{
		FileInputStream fis = new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Exception is  "+e.getMessage());
	}
}
public String getApplicationURL()
{
String url=pro.getProperty("baseURL");
return url;
}
public String getUsername()
{
String uid=pro.getProperty("Userid");
return uid;
}
public String getPassword()
{
String pwd=pro.getProperty("Password");
return pwd;
}
public String getInvalidUsername()
{
String Iuid=pro.getProperty("InvalidUid");
return Iuid;
}
public String getInvalidPassword()
{
String Ipwd=pro.getProperty("InvalidPwd");
return Ipwd;
}
public String getChromePath()
{
String cpath=pro.getProperty("ChromePath");
return cpath;
}
public String getFirefoxPath()
{
String fpath=pro.getProperty("FireFox");
return fpath;
}
}
