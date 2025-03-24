package nproj.article.example.mapper;

import nproj.article.example.model.ExampleModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExampleMapper {

    List<ExampleModel> selectAll();

}
