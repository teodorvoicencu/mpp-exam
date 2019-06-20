package ro.ubb.movieapp.web.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MovieDto extends BaseDto {
    private String title;
    private int year;
    private Set<ActorDto> actors = new HashSet<>();
}
