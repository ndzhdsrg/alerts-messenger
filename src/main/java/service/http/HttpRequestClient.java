package service.http;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpRequestClient {

    public static HttpRequest getHttpRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        url
                ))
                .header("User-Agent", "Mozilla/5.0")
                .GET()
                .build();
        return request;
    }
}
