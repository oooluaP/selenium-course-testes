package tech.ada.lms.controllers.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin("*")
public class TicketsController {

    private static List<String> TICKETS = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Map<Object, Object>> createTicket(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        TICKETS.add(message);
        return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.LOCATION, "/api/tickets/" + TICKETS.size()).body(Map.of("message", message, "success", true));
    }

}
