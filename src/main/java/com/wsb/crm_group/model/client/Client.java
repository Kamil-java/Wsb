package com.wsb.crm_group.model.client;

import com.wsb.crm_group.model.lead.Lead;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Client")
@Table(name = "client")
@Getter
@Setter
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "phone_number",
            columnDefinition = "TEXT"
    )
    private String phoneNumber;

    @Column(
            name = "email",
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "update_date"
    )
    private LocalDateTime updateDate;

    @Column(
            name = "create_date"
    )
    private LocalDateTime createDate;
}
