package ru.yureva;

import ru.yureva.enums.DocumentType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.yureva.service.history.HistoryLogService;

import java.io.IOException;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final HistoryLogService historyLogService;

    public Main(HistoryLogService historyLogService) {
        this.historyLogService = historyLogService;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        historyLogService.save(
                DocumentType.PUBLICHNYE_SLUSHANIYA,
                205
        );
    }
}