package org.example.campusworkshopbookingsystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
