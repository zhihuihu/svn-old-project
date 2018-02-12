package com.hxkj.wechat.core.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DymDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
