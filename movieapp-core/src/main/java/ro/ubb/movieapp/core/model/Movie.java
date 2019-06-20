package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * author: radu
 */
@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NamedEntityGraph(name = "movieActors",
        attributeNodes = @NamedAttributeNode(value = "actors"))
@ToString
public class Movie extends BaseEntity<Long> {

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "year")
    private int year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private Set<Actor> actors;

}
