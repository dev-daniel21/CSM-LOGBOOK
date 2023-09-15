package com.csm.csmlogbook.web;

import com.csm.csmlogbook.AddNewLogbookEntryRequest;
import com.csm.csmlogbook.LogBookEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logbook")
@RequiredArgsConstructor
public
class LogBookEntryController {

    private final LogBookControllerService logBookControllerService;

    @PostMapping("/new")
    void newEntry(@RequestHeader("user-id") String userId, @RequestBody AddNewLogbookEntryRequest addEntryRequest) {

        logBookControllerService.addNewEntry(userId, addEntryRequest);
    }

    @GetMapping("/all")
    List<LogBookEntry> getAllEntries(@RequestHeader("user-id") String userId) {
        return logBookControllerService.getAllEntries();
    }
}
