package com.wsb.crm_group.model.lead;

import com.wsb.crm_group.model.client.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Leads")
@Table(name = "leads")
@Getter
@Setter
public class Lead {

    @Id
    @SequenceGenerator(
            name = "leads_sequence",
            sequenceName = "leads_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "leads_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "client",
            nullable = false
    )
    @OneToMany
    private List<Client> client;

    @Column(
            name = "updateDate"
    )
    private LocalDateTime updateDate;

    @Column(
            name = "createDate"
    )
    private LocalDateTime createDate;

}
