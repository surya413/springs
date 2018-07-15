package com.spring;

import java.lang.String;
import java.lang.System;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 class Test {
	
	
		
		private Integer id;
		private String name;
		private String course;
		public Test(int id, String name, String course) {
			super();
			this.id = id;
			this.name = name;
			this.course = course;
		}
		@Override
		public int hashCode() {

			return id.hashCode()+name.hashCode()+course.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			/*if(obj instanceof Test) {*/
				
				Test test1= (Test) obj;
				if (this.id.equals(test1.id)&&this.name.equals(test1.name)&&this.course.equals(test1.course))
				{
					return true;
					
				}else
					return false;
				
			}/*else
				return false;
		}*/
 		@Override
		public String toString() {
		return "id ="+id + " name="+name+ " course="+course;
		}
 }
 
	
 public class TestEquals{
	 
		public static void main(String[] args) {
			
			Test t1=new Test(10,"suresh","java");
			Test t2=new Test(10,"suresh","java");
			Test t3=new Test(10,"prasad","java");
			
			Set hs=new HashSet();
			hs.add(t1);
			hs.add(t2);
			hs.add(t3);
			System.out.println(hs);
			
			
		}
	
	}
	
	

