package com.bnpp.runner;

import java.io.FileInputStream;
import java.util.Properties;

import com.bnpp.mTANResources.MobileTan;

public class Test {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//		String abc="12345678";
//		String cd=abc.replace("4", "4 ");
//		System.out.println(cd);
//		
		String a="122,73";
		double i=Double.parseDouble(a.replace(",", "."));
		i=(double) (i+Math.random()*1);
		double f=Math.round(i*100.0)/100.0;
		String valueToInput=String.valueOf(f);
		valueToInput=valueToInput.replace(".", ",");
		System.out.println(valueToInput);
		
		

}
}
