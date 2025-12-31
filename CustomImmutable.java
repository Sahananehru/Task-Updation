package com.dtm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TestImmutable{
	private final String msg = "heelooooo";
	private final List<String> names = Arrays.asList("King","Queen");
	
	public TestImmutable() {
		
	}

	public String getMsg() {
		return msg;
	}

	public List<String> getNames() {
		return names;
	}
	
	public List<String> getListNames()
	{
		return Collections.unmodifiableList(names);
	}
} 

public class CustomImmutable {
	public static void main(String[] args) {
		
		TestImmutable obj = new TestImmutable();
		System.out.println(obj.getListNames());
	}

}
