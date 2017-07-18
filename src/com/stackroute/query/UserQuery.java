package com.stackroute.query;

import java.util.Scanner;

public class UserQuery {

	Scanner sc = new Scanner(System.in);

	String inputQuery;

	public UserQuery() {
		getInputQuery();
	}

	public String getInputQuery() {
		System.out.println("enter the query");
		inputQuery = sc.nextLine();
		return inputQuery;
	}
}
