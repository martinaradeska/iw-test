package iw.test.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furniture {
    private String type;
    private Integer wood;
    private Integer glass;
    private Integer plastic;

    public Furniture(String type, Integer wood) {
        this.type = type;
        this.wood = wood;
    }

    public Furniture(String type, Integer wood, Integer glass) {
        this.type = type;
        this.wood = wood;
        this.glass = glass;
    }
}
