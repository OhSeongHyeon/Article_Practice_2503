package nproj.article.example;

import lombok.AllArgsConstructor;
import nproj.article.example.model.ExampleModel;
import nproj.article.example.service.ExampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/example/")
public class ExampleController {

    private final ExampleService exampleService;

    @RequestMapping(value = "select-all", method = RequestMethod.GET)
    public List<ExampleModel> selectAllExample() {
        return exampleService.selectAllExample();
    }
}
