package com.kuyfree.app.cache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class AppCacheManager implements CommandLineRunner {
	private final CacheManager cacheManager;

	public AppCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	public int getSize() {
		return (cacheManager != null && cacheManager.getCacheNames() != null) ? cacheManager.getCacheNames().size() : 0;
	}
}
