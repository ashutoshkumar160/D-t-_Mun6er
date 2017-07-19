package com.stackroute.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.stackroute.reader.CsvReader;

public class MapIterator {

	public static void printMap() {
		Iterator<Map.Entry<Long, HashMap<String, String>>> parent = CsvReader.tableMap.entrySet().iterator();
		while (parent.hasNext()) {
			Map.Entry<Long, HashMap<String, String>> parentPair = parent.next();

			Iterator<Map.Entry<String, String>> child = (parentPair.getValue()).entrySet().iterator();
			while (child.hasNext()) {
				Map.Entry childPair = child.next();
				System.out.println("Key: " + childPair.getKey() + " Value: " + childPair.getValue());
			}
		}
	}
}
// select policyID,eq_site_limit,construction from sample where
// point_granularity>1 and construction = wood and fr_site_limit > 100000 or
// hu_site_limit>80000