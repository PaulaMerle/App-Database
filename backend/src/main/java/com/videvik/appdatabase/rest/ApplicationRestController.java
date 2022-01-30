package com.videvik.appdatabase.rest;

import com.videvik.appdatabase.dto.ApplicationDto;
import com.videvik.appdatabase.entity.ApplicationEntity;
import com.videvik.appdatabase.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationRestController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationRestController(ApplicationService theApplicationService) {
        this.applicationService = theApplicationService;
    }

    @GetMapping(value = "/applications", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApplicationEntity>> findAll() {
        List<ApplicationEntity> applications = applicationService.findAll();
        return ResponseEntity.ok(applications);
    }

   @PostMapping(
           value = "/applications",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationDto> addApplication(@RequestBody ApplicationDto applicationDto) {
        var application = applicationService.save(applicationDto);
        return ResponseEntity.ok(application);
    }
}
