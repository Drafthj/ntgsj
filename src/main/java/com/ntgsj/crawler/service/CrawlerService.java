package com.ntgsj.crawler.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by huojia02 on 17/5/9.
 */
public class CrawlerService {
    private static final String LOGIN_URL = "http://www.ntgsj.gov.cn:9005/onlineRegNew-web/userManage/net_user_login.jsp";

    private static SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();

    private static RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000).build();
    private BasicCookieStore cookieStore;

    private CloseableHttpClient httpClient;

    public CrawlerService() {
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    }
    private void init() throws IOException {
        HttpGet httpGet = new HttpGet(LOGIN_URL);
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(response.getStatusLine());
    }
    public static void main(String[] args) throws IOException {
        CrawlerService service = new CrawlerService();
        service.init();

    }
}
