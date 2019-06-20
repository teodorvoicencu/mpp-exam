package ro.ubb.movieapp.core.model;

import lombok.*;

import javax.persistence.*;

/**
 * author: radu
 */

@Entity
@Table(name = "actors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Actor extends BaseEntity<Long> {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "rating")
    private int rating;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

}
