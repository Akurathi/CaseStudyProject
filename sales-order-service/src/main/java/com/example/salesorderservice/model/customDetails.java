package com.example.salesorderservice.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class customDetails {
    private String description;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;

    private String email;

    private List<String> itemNames;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.setDate();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate() {
        LocalDateTime currentTime = LocalDateTime.now();
        this.date = currentTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }
}
