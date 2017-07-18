package com.stackroute.query;

import com.stackroute.main.MainApplication;

public class QueryExecutor {

	public static String[] colNames = null;
	public static String[] tokens = null;

	public void queryExec() {

		String baseQuery = MainApplication.inputQuery.split("where ")[0].trim();
		String selectQuery = baseQuery.split("from")[0].trim();
		String fromQuery = baseQuery.split("from")[1].trim();
		String selectCol = selectQuery.split("select")[1].trim();
		colNames = selectCol.split(",");

		String whereQuery = MainApplication.inputQuery.split("where ")[1].trim();
		tokens = whereQuery.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equalsIgnoreCase("and")) {
				tokens[i] = "&&";
			} else if (tokens[i].equalsIgnoreCase("or")) {
				tokens[i] = "||";
			} else if (tokens[i].equalsIgnoreCase("=")) {
				tokens[i] = "==";
			}
		}
	}
}
