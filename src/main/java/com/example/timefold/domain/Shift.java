package com.example.timefold.domain;

import java.time.LocalDateTime;

public class Shift {

    private Long id;
    private String role;
    private LocalDateTime start;
    private LocalDateTime end;

    public Shift() {}

    public Shift(Long id, String role, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.role = role;
        this.start = start;
        this.end = end;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getStart() { return start; }
    public void setStart(LocalDateTime start) { this.start = start; }

    public LocalDateTime getEnd() { return end; }
    public void setEnd(LocalDateTime end) { this.end = end; }
}
