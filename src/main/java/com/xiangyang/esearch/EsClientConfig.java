package com.xiangyang.esearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsClientConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(EsClientConfig.class);

	@Bean
	public RestHighLevelClient client(){
		RestHighLevelClient client = null;
		try {
			client=new RestHighLevelClient(
					RestClient.builder(
							new HttpHost("121.41.56.97", 9200, "http")));
			LOGGER.info("es连接成功");
		} catch (Exception e) {
			LOGGER.info("es连接失败,{}",e.getMessage());
		}
		return client;
//		client.close();
	}

}

