package org.example.campusworkshopbookingsystem;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class WorkshopService {
    private final WorkshopRepository repository;

    public WorkshopService(WorkshopRepository repository) {
        this.repository = repository;
    }

    public List<WorkshopResponse> findAll(String category) {
        List<Workshop> workshops = (category == null)
                ? repository.findAllByOrderByIdAsc()
                : repository.findByCategoryIgnoreCaseOrderByIdAsc(category);
        return toWorkshopResponses(workshops);
    }

    public Optional<WorkshopResponse> findById(Long id) {
        return repository.findById(id).map(WorkshopResponse::fromWorkshop);
    }

    public List<WorkshopResponse> findByTitle(String keyword) {
        return toWorkshopResponses(repository.
                findByTitleContainingIgnoreCaseOrderByIdAsc(keyword));
    }

    public List<WorkshopResponse> findByPresenter(String presenter) {
        return toWorkshopResponses(repository.
                findByPresenterIgnoreCaseOrderByIdAsc(presenter));
    }

    @Transactional
    public WorkshopResponse add(WorkshopRequest request) {
        Workshop workshop = new Workshop(
                request.title(),
                request.category(),
                request.presenter(),
                request.durationMinutes(),
                request.capacity());

        return WorkshopResponse.fromWorkshop(workshop);
    }

    @Transactional
    public Optional<WorkshopResponse> update(Long id, WorkshopRequest request) {
        return repository.findById(id)
            .map(existing -> {
                existing.changeDetails(
                        request.title(),
                        request.category(),
                        request.presenter(),
                        request.durationMinutes(),
                        request.capacity());

                return WorkshopResponse.fromWorkshop(existing);
        });
    }

    @Transactional
    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    private List<WorkshopResponse> toWorkshopResponses(List<Workshop> workshops) {
        return workshops.stream()
                .map(WorkshopResponse::fromWorkshop)
                .toList();
    }
}
