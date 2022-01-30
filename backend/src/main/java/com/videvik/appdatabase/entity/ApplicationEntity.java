package com.videvik.appdatabase.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder(toBuilder = true)
@Setter
@Getter
@Table(name = "applications")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_code", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "app_group", length = 100)
    private String appGroup;

    @Column(name = "app_type", length = 30)
    private String appType;

    // should really use @Lob or @Column(columnDefinition="TEXT") here due to large size
    // but gives error "invalid input syntax for type oid" when INSERT
    @Column(name = "description", nullable = false, columnDefinition="TEXT", length = 20000)
    private String description;

    @Column(name = "app_cost")
    private Integer appCost;

    @Column(name = "last_modified")
    @CreationTimestamp
    public Timestamp lastModified;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
    private List<AppServiceEntity> services = new ArrayList<>();

    @PrePersist
    protected void onUpdate() {
        lastModified = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    protected void onCreate() {
        lastModified = Timestamp.valueOf(LocalDateTime.now());
    }

    public ApplicationEntity() {
    }

    public void assignToServices() {
        if(services != null) services.forEach(service -> service.setApplication(this));
    }

    @Override
    public String toString() {
        return "Application [id=" + id + ", name=" + name + ", app-group= " + appGroup + ", app-type=" + appType +
                ", description=" + description + ", app cost=" + appCost + ", last modified=" + lastModified + "]";
    }
}