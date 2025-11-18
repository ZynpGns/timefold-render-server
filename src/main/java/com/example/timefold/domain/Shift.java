package com.example.timefold.domain;

import java.time.LocalDateTime;

public class Shift {

    private Long id;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    /** Bu vardiya için gerekli skill (örn: "NURSE") */
    private String requiredSkill;

    public Shift() {
    }

    public Shift(Long id, String title, LocalDateTime start, LocalDateTime end, String requiredSkill) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.requiredSkill = requiredSkill;
    }

    // ---- yardımcı ----

    public boolean overlaps(Shift other) {
        // zaman aralıkları çakışıyor mu?
        return !this.end.isBefore(other.start) && !this.start.isAfter(other.end);
    }

    // ---- getters / setters ----

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

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
}
