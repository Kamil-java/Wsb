package com.wsb.crm_group.model.reports;

import jakarta.persistence.*;

import java.net.URL;

@Entity(name = "Reports")
@Table(
        name = "reports",
        uniqueConstraints = {
                @UniqueConstraint(name = "task_task_name_unique", columnNames = "task_name")
        }
)
public class Reports {

        @Id
        @SequenceGenerator(
                name = "task_sequence",
                sequenceName = "task_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "task_sequence"
        )
        @Column(
                name = "id",
                updatable = false
        )
        private Long id;

        @Column(
                name = "task_name",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String taskName;

        @Column(
                name = "description",
                columnDefinition = "TEXT"
        )
        private String description;

        @Column(
                name = "ready_to_be_checked",
                nullable = false,
                columnDefinition = "BOOLEAN"
        )
        private Boolean readyToBeChecked = false;

        @Column(
                name = "is_completed",
                nullable = false,
                columnDefinition = "BOOLEAN"
        )
        private Boolean isCompleted = true;

        @Column(
                name = "url_to_project",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private URL workEffectRepository;
}
