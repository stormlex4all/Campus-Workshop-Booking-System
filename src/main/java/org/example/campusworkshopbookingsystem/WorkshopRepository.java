package org.example.campusworkshopbookingsystem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
    List<Workshop> findAllByOrderByIdAsc();

    List<Workshop> findByTitleContainingIgnoreCaseOrderByIdAsc(String category);

    List<Workshop> findByCategoryIgnoreCaseOrderByIdAsc(String category);

    List<Workshop> findByPresenterIgnoreCaseOrderByIdAsc(String presenter);
}
