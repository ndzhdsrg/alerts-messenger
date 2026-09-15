package service.history;

import entity.HistoryLog;
import enums.DocumentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.HistoryLogRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HistoryLogService {
    private final HistoryLogRepository historyLogRepository;

    public void save(DocumentType documentType, Integer documentCount) {
        HistoryLog historyLog = new HistoryLog();
        historyLog.setDocumentType(documentType);
        historyLog.setDocumentCount(documentCount);
        historyLog.setCreationAt(LocalDateTime.now());
        historyLogRepository.save(historyLog);
    }

}
