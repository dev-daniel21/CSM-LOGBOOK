package com.csm.csmlogbook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public
class LogBookEntry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_id")
    private String entryId;

    private String creator;

    private LocalDateTime createdAt;

    private Boolean replyNeeded;

    private String typeOfWorks;

    private String typeOfEntry;

    private String content;

    public LogBookEntry(String creator, Boolean replyNeeded, String typeOfWorks, String typeOfEntry, String content) {
        this.creator = creator;
        this.entryId = String.valueOf(UUID.randomUUID());
        this.createdAt = LocalDateTime.now();
        this.replyNeeded = replyNeeded;
        this.typeOfWorks = typeOfWorks;
        this.typeOfEntry = typeOfEntry;
        this.content = content;
    }

}
