package nproj.article.example;

import lombok.AllArgsConstructor;
import nproj.article.example.model.ExampleModel;
import nproj.article.example.service.ExampleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @RequestMapping(value = "select-all2", method = RequestMethod.GET)
    public List<ExampleModel> selectAllExample2() {
        return exampleService.selectAllMemoryExample();
    }

    @RequestMapping(value = "submit-post", method = RequestMethod.POST)
    public void submitPost(@RequestBody HashMap<String, String> model) {
        System.out.println(model.get("title"));
    }
}
