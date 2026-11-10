package org.example.campusworkshopbookingsystem;

import jakarta.persistence.*;

@Entity
@Table(name = "workshop")
public class Workshop {

    public Workshop() {}

    public Workshop(String title, String category, String presenter, Integer durationMinutes, Integer capacity) {
        this.title = title;
        this.category = category;
        this.presenter = presenter;
        this.durationMinutes = durationMinutes;
        this.capacity = capacity;
    }

    public void changeDetails(String title, String category, String presenter, Integer durationMinutes, Integer capacity) {
        this.title = title;
        this.category = category;
        this.presenter = presenter;
        this.durationMinutes = durationMinutes;
        this.capacity = capacity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String presenter;

    @Column(nullable = false, name = "duration_minutes")
    private Integer durationMinutes;

    @Column(nullable = false)
    private  Integer capacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
