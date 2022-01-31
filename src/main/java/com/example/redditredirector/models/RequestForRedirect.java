package com.example.redditredirector.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@Table
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RequestForRedirect implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String linkGot;

    @Column
    private String linkGenerated;

    @Column
    private String dateOfGenerating;

    @Column
    private boolean isActive=false;

    @Column
    private Integer numberOfUsages=0;

    public RequestForRedirect(String linkGot, String linkGenerated, String dateOfGenerating, boolean isActive, Integer numberOfUsages) {
        this.linkGot = linkGot;
        this.linkGenerated = linkGenerated;
        this.dateOfGenerating = dateOfGenerating;
        this.isActive = isActive;
        this.numberOfUsages = numberOfUsages;
    }
}
