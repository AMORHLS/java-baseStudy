package com.zhang3;

import java.util.Scanner;

public class AutoLing {
	 public static void main(String[] args) { 
	        // TODO Auto-generated method stub 
		    //自动获取菱形
	        System.out.println("请输入三角形的行数："); 
	        Scanner input =new Scanner(System.in);
	         int n =input.nextInt();
	         //行数
	        for(int i = 0; i < n - 1; i++){ 
	        	//空白
	            for(int x = i + 1; x < n; x++){ 
	                System.out.print(" "); 
	            } 
	            //列数
	            for(int y = 0; y < (i + 1) * 2 - 1; y++){ 
	                System.out.print("*"); 
	            } 
	            System.out.println(); 
	        } 
	        for(int i = 0; i < n; i++){ 
	            for(int x = 0; x < i; x++){ 
	                System.out.print(" "); 
	            } 
	            for(int y = i; y < 2 * n - i - 1; y++){ 
	                System.out.print("*"); 
	            } 
	            System.out.println(); 
		}
	}
} 
	 

