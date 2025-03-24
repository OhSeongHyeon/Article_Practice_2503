package nproj.article.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class ExampleModel {
    int id;
    String name;
    String description;
    String camelCase;
    Date regDate;
}
