package org.moviedata.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    private Integer movieID;
    private String movieTitle;
    private Integer movieYearReleased;
    private Integer movieTakings;

    private Integer movieDirectorID;
}

