//GST generator
package com.wintest;

import java.security.SecureRandom;
import java.util.*; 

public class GST { 
	public static final String SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String SOURCE1 = "0123456789";
	static SecureRandom secureRnd = new SecureRandom();
	public static void main(String[] args) {
		String s=null;
	String[] GST;
	GST = new String[50];
	for(int i=0; i<50; i++)
	{
		Random t = new Random();
		//number
		String s1= (String.format("%02d", t.nextInt(37)));
		//alphabet
		String alpha1 = randomString(5);
		//number
		String alpha =randomString1(4);
		//alphabet
		String alpha2 = randomString(1);
		//number
		String s2= (String.format("%01d", t.nextInt(10)));
		//alphabet
		String alpha3 = randomString(1);
		//number
		String s3= (String.format("%01d", t.nextInt(10)));
		s= s1+alpha1+alpha+alpha2+s2+alpha3+s3;
			
		if(s!=GST[i])
		{
			if(GST[i]==null)
			{
				GST[i]=s;
			}
		}
	}
		
	for(int i=0;i<GST.length; i++)
	{
		String seq=null;
		seq=String.format("%02d",i+1);
		System.out.println(seq);
			
		System.out.println(GST[i]);
	}    
	}
	public static String randomString(int length) {
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++)
	      sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
	    return sb.toString();
	}
	public static String randomString1(int length) {
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++)
	      sb.append(SOURCE1.charAt(secureRnd.nextInt(SOURCE1.length())));
	    return sb.toString();
	}
} 