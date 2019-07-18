package com.demo.ss.services.domains;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SampleDomain {

    private Integer id;

    private String name;
}
