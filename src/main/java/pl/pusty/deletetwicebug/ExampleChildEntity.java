package pl.pusty.deletetwicebug;

import javax.persistence.*;

@Entity
public class ExampleChildEntity {

    @OneToOne(optional = false)
    private ExampleEntity exampleEntity;

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    protected ExampleChildEntity() {
    }

    public ExampleChildEntity(String name) {
        this.name = name;
    }

    public void setExampleEntity(ExampleEntity exampleEntity) {
        this.exampleEntity = exampleEntity;
    }

    @Override
    public String toString() {
        return "ExampleChildEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
