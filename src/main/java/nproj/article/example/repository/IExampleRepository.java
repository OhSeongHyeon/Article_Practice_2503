package nproj.article.example.repository;

import nproj.article.example.model.ExampleModel;

import java.util.List;

public interface IExampleRepository {
    List<ExampleModel> selectAll();
}
