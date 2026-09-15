package repository;

import entity.HistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryLogRepository extends JpaRepository<HistoryLog, Long> {
}
