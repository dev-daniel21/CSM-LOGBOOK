package com.csm.csmlogbook.web;


import com.csm.csmlogbook.AddNewLogbookEntryRequest;
import com.csm.csmlogbook.LogBookEntry;
import com.csm.csmlogbook.LogBookEntryRepository;
import com.csm.csmlogbook.RolesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogBookControllerService {

    private final LogBookEntryRepository logBookEntryRepository;
    private final RolesClient rolesClient;
    private final static String USER_NOT_AUTHORIZED = "User not authorized to create new entries to the logbook!";


    public void addNewEntry(String userId, AddNewLogbookEntryRequest request) {
        var entryCreator = validateWriteRole(userId);

        LogBookEntry logBookEntry = new LogBookEntry(
                String.join("_", entryCreator, userId),
                request.getReplyNeeded(),
                request.getTypeOfWorks(),
                request.getTypeOfEntry(),
                request.getContent()
        );

        logBookEntryRepository.save(logBookEntry);
    }

    public List<LogBookEntry> getAllEntries() {
        return logBookEntryRepository.findAll();
    }

    private String validateWriteRole(String userId) {
        var userRole = rolesClient.getUserRoles(userId);
        List<String> authorizedRole = List.of("INSPECTOR", "SITE_MANAGER", "INVESTOR");
        if (!authorizedRole.contains(userRole)) {
            throw new RuntimeException(USER_NOT_AUTHORIZED);
        }
        return userRole;
    }
}
