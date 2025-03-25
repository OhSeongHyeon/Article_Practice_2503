package nproj.article.example.repository;

import nproj.article.example.model.ExampleModel;
import nproj.article.example.service.ExampleService;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MemoryExampleRepository implements IExampleRepository {

    private final List<ExampleModel> store = new ArrayList<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public List<ExampleModel> selectAll() {
        ExampleModel m = ExampleModel.builder()
                .id(seq.incrementAndGet())
                .name("example" + seq.get())
                .camelCase("??" + seq.get())
                .description("example" + seq.get())
                .regDate(Date.valueOf(LocalDate.now()))
                .build();
        store.add(m);
        return store;
    }

}
