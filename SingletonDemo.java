package com.ques;

import java.time.*;

class SingletonTest {
	private static volatile SingletonTest instance;

	private final LocalDate localDate;
	private final LocalDateTime localDateTime;
	private final ZonedDateTime zonedDateTime;
	private final ZoneId zoneId;

	private SingletonTest(ZoneId zone) {
		this.zoneId = zone;
		this.localDate = LocalDate.now(zone);
		this.localDateTime = LocalDateTime.now(zone);
		this.zonedDateTime = ZonedDateTime.now(zone);
	}

	public static SingletonTest getInstance() {
		return getInstance(ZoneId.of("Asia/Kolkata"));
	}

	public static SingletonTest getInstance(ZoneId zone) {
		if (instance == null) {
			synchronized (SingletonTest.class) {
				if (instance == null) {
					instance = new SingletonTest(zone);
				}
			}
		}
		return instance;
	}
	
	public LocalDate getLocalDate() {
		return localDate;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public ZonedDateTime getZonedDateTime() {
		return zonedDateTime;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}
}

public class SingletonDemo {
	public static void main(String[] args) {
		SingletonTest s = SingletonTest.getInstance();

		System.out.println("LocalDate: " + s.getLocalDate());
		System.out.println("LocalDateTime: " + s.getLocalDateTime());
		System.out.println("ZonedDateTime (" + s.getZoneId() + "): " + s.getZonedDateTime());
	}
}
