package ru.yureva;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import service.http.HttpRequestClient;
import service.http.HttpResponseClient;
import service.pageElements.PageElementService;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static config.PageElements.documentCountClassSelector;
import static config.PageElements.documentCountSelector;
import static service.pageElements.PageElementService.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequestClient.getHttpRequest("https://aidarovskoe36.gosuslugi.ru/ofitsialno/dokumenty/publichnye-slushaniya/?cur_cc=1646&curPos=200");

        HttpResponse<String> response = HttpResponseClient.getStringHttpResponse(client, request);

        PageElementService.isContainsElement(response, documentCountSelector);

        Document document = PageElementService.parsePage(response);

        Element countElement =
                PageElementService.findElement(
                        document,
                        documentCountClassSelector
                );
        if (checkExistingDocuments(countElement)) return;

        String text = getTextFromPageElement(countElement);

        int currentCount = getDocumentCount(text);



    }




}