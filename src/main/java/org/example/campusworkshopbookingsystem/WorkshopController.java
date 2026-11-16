package org.example.campusworkshopbookingsystem;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/workshops")
public class WorkshopController {

    private final WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @GetMapping
    public ResponseEntity<List<WorkshopResponse>> getAll(
            @RequestParam(required = false) String category) {
        return ResponseEntity.ok(workshopService.findAll(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkshopResponse> getById(@PathVariable Long id) {
        return workshopService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<WorkshopResponse>> searchByTitle(
            @RequestParam String title) {
        return ResponseEntity.ok(workshopService.findByTitle(title));
    }

    @GetMapping("/by-presenter")
    public ResponseEntity<List<WorkshopResponse>> getByPresenter(
            @RequestParam String presenter) {
        return ResponseEntity.ok(workshopService.findByPresenter(presenter));
    }

    @PostMapping
    public ResponseEntity<WorkshopResponse> create(@Valid @RequestBody WorkshopRequest request) {
        WorkshopResponse created = workshopService.add(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkshopResponse> update(@PathVariable Long id,
                                                   @Valid @RequestBody WorkshopRequest request) {
        return workshopService.update(id, request)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (workshopService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
