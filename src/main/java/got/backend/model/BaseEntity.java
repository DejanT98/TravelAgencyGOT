package got.backend.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    public void setId(Integer id) { this.id = id; }

    public Integer getId() { return this.id;}
}
