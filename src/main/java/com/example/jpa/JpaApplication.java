package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {

		List<Integer> inregerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		Map<Boolean,List<Integer>> integerMap = inregerList.stream().collect(Collectors.partitioningBy(a->a%2==0));
		for (Map.Entry<Boolean, List<Integer>> x :integerMap.entrySet()){
			if(x.getKey()){
				System.out.println("Even values are : " + x.getValue());
			}else{
				System.out.println("Odd values are : " + x.getValue());
			}
		}
		//SpringApplication.run(JpaApplication.class, args);
	}

}
