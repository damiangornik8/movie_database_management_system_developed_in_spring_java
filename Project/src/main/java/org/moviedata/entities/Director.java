package org.moviedata.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Director {
    private Integer directorId;
    private String firstName;
    private String lastName;
    private Integer isActive;



}

