package com.lama.mse.restaurants.modification.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logs {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private static String dateInfo() {
		return formatter.format(new Date()) + " | ";
	}

	public static void info(String msg) {
		System.out.print("[INFO|" + dateInfo() + msg + "]");
	}

	public static void debug(String msg) {
		System.out.print("[DEBUG|" + dateInfo() + msg + "]");
	}

	public static void error(String msg) {
		System.out.print("[ERROR|" + dateInfo() + msg + "]");
	}

	public static void infoln(String msg) {
		System.out.println("[INFO|" + dateInfo() + msg + "]");
	}

	public static void infoln(String msg, int sleepms) {
		try {
			Thread.sleep(sleepms);
			System.out.println("[INFO|" + dateInfo() + msg + "]");
		} catch (InterruptedException e) {
		}
	}

	public static void debugln(String msg) {
		System.out.println("[DEBUG|" + dateInfo() + msg + "]");
	}

	public static void errorln(String msg) {
		System.out.println("[ERROR|" + dateInfo() + msg + "]");
	}

}