package com.videvik.appdatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Builder(toBuilder = true)
@Setter
@Getter
@Table(name = "app_services")
@AllArgsConstructor
@NoArgsConstructor
public class AppServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_code", nullable = false)
    private Integer serviceCode;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "sub_type", length = 30)
    private String subType;

    // should really use @Lob or @Column(columnDefinition="TEXT") here due to large size
    // but gives error "invalid input syntax for type oid" when INSERT
    @Column(name = "description", columnDefinition="TEXT", length = 20000)
    private String description;

    @Column(name = "last_modified")
    @CreationTimestamp
    public Timestamp lastModified;

    @ManyToOne
    @JsonIgnoreProperties(value = {"services", "handler","hibernateLazyInitializer"}, allowSetters = true)
    @JoinColumn(name = "app_code")
    private ApplicationEntity application;

    @PrePersist
    protected void onUpdate() {
        lastModified = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    protected void onCreate() {
        lastModified = Timestamp.valueOf(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Service [id=" + serviceCode + ", name=" + name + ", type=" + type +
                ", subtype=" + subType + ", description=" + ", last modified=" + lastModified + "]";
    }
}