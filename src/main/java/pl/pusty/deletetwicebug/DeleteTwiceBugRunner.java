package pl.pusty.deletetwicebug;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteTwiceBugRunner implements CommandLineRunner {

    private final ExampleService exampleService;

    public DeleteTwiceBugRunner(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @Override
    public void run(String... args) throws Exception {
        exampleService.doSomething();
        exampleService.presentResult();
    }
}
