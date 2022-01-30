package com.videvik.appdatabase.rest;

import com.videvik.appdatabase.dto.ServiceDto;
import com.videvik.appdatabase.service.AppServiceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppServiceRestController {

    private final AppServiceService appService;

    public AppServiceRestController(AppServiceService appService) {
        this.appService = appService;
    }

    // activating findall(), GET response turns to array, otherwise JPA response gives HATEOAS that is currently working with frontend
/*   @GetMapping(value = "/services", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppServiceEntity>> findAll() {
        List<AppServiceEntity> services = appService.findAll();
        return ResponseEntity.ok(services);
    }*/

    @PostMapping(
            value = "/services",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceDto> addService(@RequestBody ServiceDto serviceDto) {
        var service  = appService.save(serviceDto);
        return ResponseEntity.ok(service);
    }


}
