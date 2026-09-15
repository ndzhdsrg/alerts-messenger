package entity;

import enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//она же jpa-сущность
@Entity
@Table(name = "history_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING) //позволяет сохранять значение enum как строку в БД
    private DocumentType documentType;
    private Integer documentCount;
    private LocalDateTime creationAt;

}
