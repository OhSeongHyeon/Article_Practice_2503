package nproj.article.example.service;

import lombok.AllArgsConstructor;
import nproj.article.example.mapper.ExampleMapper;
import nproj.article.example.model.ExampleModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class ExampleService {

    private final ExampleMapper exampleMapper;

    public List<ExampleModel> selectAllExample() {
        return exampleMapper.selectAll();
    }
}
