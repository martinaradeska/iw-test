package iw.test.task.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder
{
    public static List<Furniture> furnitures = new ArrayList<Furniture>();
}
