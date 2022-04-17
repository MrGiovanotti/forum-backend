package com.avalburo.test.utils;

import java.util.UUID;

public class Utils {

    private Utils() {

    }

    /**
     * Generates an unique id each time this function is executed
     *
     * @author Giovanny Granda Vera
     * @return
     */
    public static String generateUniqueId() {
	UUID uuid = UUID.randomUUID();
	return uuid.toString();
    }

}
