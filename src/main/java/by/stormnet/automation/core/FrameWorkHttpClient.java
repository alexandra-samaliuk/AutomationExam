package by.stormnet.automation.core;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class FrameWorkHttpClient {
    protected HttpClient httpClient;
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpPut httpPut;
    private HttpDelete httpDelete;

    public FrameWorkHttpClient() {
        httpClient = HttpClientBuilder.create().build();
    }

    public Response doGet(String url) {
        httpGet = new HttpGet(url);
        Response response = null;
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            response = new Response(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Response doPost(String url, String body) {
        httpPost = new HttpPost(url);
        httpPost.addHeader("content-type", "application/json");
        Response response = null;
        try {
            httpPost.setEntity(new StringEntity(body));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            response = new Response(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
