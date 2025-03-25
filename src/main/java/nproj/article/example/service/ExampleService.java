package nproj.article.example.service;

import lombok.AllArgsConstructor;
import nproj.article.example.mapper.ExampleMapper;
import nproj.article.example.model.ExampleModel;
import nproj.article.example.repository.IExampleRepository;
import nproj.article.example.repository.MemoryExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class ExampleService {

    private final ExampleMapper exampleMapper;
    private IExampleRepository exampleRepository;

    @Autowired
    public void setExampleRepository(MemoryExampleRepository exampleRepository) {this.exampleRepository = exampleRepository;}

    public List<ExampleModel> selectAllExample() {
        return exampleMapper.selectAll();
    }

    public List<ExampleModel> selectAllMemoryExample() {
        List<ExampleModel> list = exampleRepository.selectAll();
        Collections.reverse(list);
        return list;
    }
}
