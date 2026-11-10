package org.example.campusworkshopbookingsystem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WorkshopRequest(
        @NotBlank(message = "title must not be blank")
        @Size(max = 100, message = "must be at most {max} characters")
        String title,

        @NotBlank(message = "category must not be blank")
        @Size(max = 40, message = "must be at most {max} characters")
        String category,

        @NotBlank(message = "presenter must not be blank")
        @Size(max = 100, message = "must be at most {max} characters")
        String presenter,

        @NotNull(message = "durationMinutes is required")
        Integer durationMinutes,

        @NotNull(message = "capacity is required")
        Integer capacity
) {
}
