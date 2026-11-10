package org.example.campusworkshopbookingsystem;

public record WorkshopResponse(Long id, String title, String category, String presenter, Integer durationMinutes, Integer capacity) {

    public static WorkshopResponse fromWorkshop(Workshop workshop) {
        return new WorkshopResponse(
                workshop.getId(),
                workshop.getTitle(),
                workshop.getCategory(),
                workshop.getPresenter(),
                workshop.getDurationMinutes(),
                workshop.getCapacity()
        );
    }
}
