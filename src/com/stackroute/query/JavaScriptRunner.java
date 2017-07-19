package com.stackroute.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.stackroute.reader.CsvReader;

public class JavaScriptRunner {

	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");
	public static String expression = "";
	String[] queryList = new String[QueryExecutor.tokens.length];

	public boolean isAlphaNumeric(String s) {
		String pattern = "^[a-zA-Z0-9]*$";
		return s.matches(pattern);
	}

	public void queryRun() throws ScriptException {

		Iterator<Map.Entry<Long, HashMap<String, String>>> parent = CsvReader.tableMap.entrySet().iterator();
		while (parent.hasNext()) {
			Map.Entry<Long, HashMap<String, String>> parentPair = parent.next();

			for (int i = 0; i < QueryExecutor.tokens.length; i++) {
				queryList[i] = QueryExecutor.tokens[i];
			}

			Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
			expression = "";
			while (child.hasNext()) {
				Map.Entry childPair = child.next();
				for (int i = 0; i < queryList.length; i++) {
					if (queryList[i].equalsIgnoreCase((String) childPair.getKey())) {
						queryList[i] = (String) childPair.getValue();
					}
				}
			}
			for (int i = 0; i < queryList.length; i++) {
				if (isAlphaNumeric(queryList[i])) {
					queryList[i] = "'" + queryList[i] + "'";
				}
			}
			for (String s : queryList) {
				expression = expression + s;
			}
			Boolean res = (Boolean) engine.eval(expression);
			if (res == true) {
				continue;
			}
			parent.remove();
		}
	}
}
