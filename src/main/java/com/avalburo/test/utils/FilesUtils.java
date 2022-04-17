package com.avalburo.test.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilesUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilesUtils.class);

    private FilesUtils() {
    }

    /**
     * Writes a file replacing the last content
     *
     * @author Giovanny Granda Vera
     * @param file
     * @param content *
     */
    public static void writeFile(File file, String content) {
	try (FileWriter fileWriter = new FileWriter(file, false);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
	    printWriter.print(content);
	} catch (IOException e) {
	    LOGGER.error(e.getMessage());
	}
    }

    /**
     * Writes a file replacing the last content
     * 
     * @author Giovanny Granda Vera
     * @param filePath
     * @param content
     */
    public static void writeFile(String filePath, String content) {
	try (FileWriter fileWriter = new FileWriter(filePath, false);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
	    printWriter.print(content);
	} catch (IOException e) {
	    LOGGER.error(e.getMessage());
	}
    }

    /**
     * Reads a file
     * 
     * @author Giovanny Granda Vera
     * @param file
     * @return
     */
    public static String readFile(File file) {
	StringBuilder sb = new StringBuilder();
	try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

	    String line;
	    while ((line = br.readLine()) != null) {
		sb.append(line);
	    }
	} catch (IOException e) {
	    LOGGER.error(e.getMessage());
	}
	return sb.toString();
    }

    /**
     * Reads a file
     * 
     * @author Giovanny Granda Vera
     * @param filePath
     * @return
     */
    public static String readFile(String filePath) {
	StringBuilder sb = new StringBuilder();
	try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr);) {

	    String line;
	    while ((line = br.readLine()) != null) {
		sb.append(line);
	    }
	} catch (IOException e) {
	    LOGGER.error(e.getMessage());
	}
	return sb.toString();
    }

}
