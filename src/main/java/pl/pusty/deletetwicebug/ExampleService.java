package pl.pusty.deletetwicebug;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExampleService {

    private final ExampleRepository exampleRepository;

    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public void doSomething() {
        ExampleChildEntity exampleChildEntity = new ExampleChildEntity("Child 1");
        ExampleEntity exampleEntity = new ExampleEntity(exampleChildEntity);
        exampleChildEntity.setExampleEntity(exampleEntity);
        exampleRepository.saveAndFlush(exampleEntity);

        exampleEntity.setExampleChildEntity(null);
        exampleRepository.saveAndFlush(exampleEntity);

        exampleEntity.setExampleChildEntity(exampleChildEntity);
        exampleRepository.saveAndFlush(exampleEntity);

        exampleEntity.setExampleChildEntity(null);
        exampleRepository.saveAndFlush(exampleEntity);
    }

    public void presentResult() {
        List<ExampleEntity> all = exampleRepository.findAll();
        System.out.println(all);
    }
}
