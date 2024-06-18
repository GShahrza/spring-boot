package com.company.usertask.domain;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@Table(name = "profile")
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "profile")
    private ProfileDetail profileDetail;

}
