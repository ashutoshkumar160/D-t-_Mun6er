package com.stackroute.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.stackroute.main.MainApplication;
import com.stackroute.query.QueryExecutor;

public class CsvReader {

	static String csvFile = "/home/ashutosh/csv/Emp.csv";

	private static long rowid = 1;

	BufferedReader br = null;

	public static Map<Long, HashMap<String, String>> tableMap = new HashMap<Long, HashMap<String, String>>();

	String header = " ";
	String[] headerArray;

	String line;
	String[] lineArray;

	// removed String csvFile parameter from readCsvFile()
	public void readCsvFile() throws FileNotFoundException {
		br = new BufferedReader(new FileReader(csvFile));
		getHeader();
		getBody();

	}

	public String[] getHeader() {
		try {
			header = br.readLine();
			headerArray = header.split("\\s*,\\s*");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return headerArray;
	}

	public void getBody() {

		try {
			while ((line = br.readLine()) != null) {
				lineArray = line.split("\\s*,\\s*");
				HashMap<String, String> rowMap = new HashMap<String, String>();
				for (int i = 0; i < headerArray.length; i++) {
					rowMap.put(headerArray[i], lineArray[i]);
				}
				tableMap.put(rowid, rowMap);
				rowid++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
