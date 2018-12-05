package pl.pusty.deletetwicebug;

import javax.persistence.*;

@Entity
public class ExampleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "exampleEntity", orphanRemoval = true)
    private ExampleChildEntity exampleChildEntity;

    protected ExampleEntity() {
    }

    public ExampleEntity(ExampleChildEntity exampleChildEntity) {
        this.exampleChildEntity = exampleChildEntity;
    }

    public void setExampleChildEntity(ExampleChildEntity exampleChildEntity) {
        this.exampleChildEntity = exampleChildEntity;
    }

    @Override
    public String toString() {
        return "ExampleEntity{" +
                "id=" + id +
                ", exampleChildEntity=" + exampleChildEntity +
                '}';
    }
}
