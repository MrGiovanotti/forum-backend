package com.avalburo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${storage.file-path}")
    private String storageFilePath;

    public String getStorageFilePath() {
	return storageFilePath;
    }

}
