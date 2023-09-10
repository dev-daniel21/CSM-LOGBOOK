package com.csm.csmlogbook;

import lombok.Getter;

@Getter
public class AddNewLogbookEntryRequest {

    private Boolean replyNeeded;

    private String typeOfWorks;

    private String typeOfEntry;

    private String content;
}
