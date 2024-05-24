package com.wsb.cms_group.model.entry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Entries {

    @Id
    @GeneratedValue
    public Integer id;

    public String entry;
}
