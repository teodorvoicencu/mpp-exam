package ro.ubb.movieapp.core.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Data
@Getter
@Setter
public abstract class BaseEntity<ID extends Serializable>
        implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigserial")
    private ID id;

}
