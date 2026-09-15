package service.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpResponseClient {

    private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);

    public static HttpResponse<String> getStringHttpResponse(
            HttpClient client,
            HttpRequest request) throws IOException, InterruptedException {

        log.debug("Отправка http-запроса на uri: " + request.uri());

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        log.debug("Статус код: " + response.statusCode());

        return response;
    }
}
