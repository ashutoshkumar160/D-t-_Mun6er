package com.stackroute.main;

import java.io.FileNotFoundException;

import javax.script.ScriptException;

import com.stackroute.query.JavaScriptRunner;
import com.stackroute.query.QueryExecutor;
import com.stackroute.reader.CsvReader;

public class MainApplication {

	public static String csvFile = "/home/ashutosh/csv/Emp.csv";
	public static String inputQuery = "select EmpName,EmpSalary,EmpAddress from Emp where EmpSalary > 40000 and EmpDesignation = tester and EmpAddress = btm or EmpAddress = bellandur";

	public static void main(String[] args) throws FileNotFoundException, ScriptException {

		CsvReader reader = new CsvReader();
		reader.readCsvFile();

		QueryExecutor executor = new QueryExecutor();
		executor.queryExec();

		JavaScriptRunner runner = new JavaScriptRunner();
		runner.queryRun();

		MapIterator.printMap();

	}
}
