package com.huskar.util;

import com.alibaba.appengine.api.store.StoreService;
import com.alibaba.appengine.api.store.StoreServiceFactory;

public class ALiyunUtil {
	public static final String STORE_SPACENAME = "kael";

	
	//storeService.saveBinaryFile(byte[] content, String path);
	public static void save(byte[] content, String path){
		StoreService storeService = StoreServiceFactory.getStoreService(STORE_SPACENAME);
		storeService.saveBinaryFile(content, path);
	}
	
	public static byte[] get(String path){
		StoreService storeService = StoreServiceFactory.getStoreService(STORE_SPACENAME);
		return storeService.getBinaryFile(path);
	}
}
