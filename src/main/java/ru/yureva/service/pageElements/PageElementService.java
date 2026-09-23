package ru.yureva.service.pageElements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpResponse;

public class PageElementService {
    private static final Logger log = LoggerFactory.getLogger(PageElementService.class);

    public static boolean isContainsElement(HttpResponse<String> response, String pageElement) {
        Boolean isContains = response.body().contains(pageElement);
        log.debug("Поиск элемента '{}':{}",
                pageElement,
                isContains ? "найден" : "не найден"
        );
        return  isContains;
    }

    public static Document parsePage(HttpResponse<String> response) {
        log.debug("Парсинг HTML-страницы");
        return Jsoup.parse(response.body());
    }

    public static Element findElement(Document document, String selector) {
        Element element = document.selectFirst(selector);
        log.debug(
                "Поиск элемента '{}': {}",
                selector,
                element != null ? "найден" : "не найден"
        );
        return element;
    }

    public static boolean checkExistingDocuments(Element countElement) {
        if (countElement == null) {
           log.debug("Элемент не найден");
            return true;
        }
        return false;
    }

    public static String getTextFromPageElement(Element countElement) {
        String text = countElement.text();
        log.debug("Найден текст в элементе: " + text);
        return text;
    }

    public static int getDocumentCount(String text) {
        return Integer.parseInt(text.replaceAll("\\D+", "")); //D означает - любой символ, который НЕ является цифрой
    }
}
