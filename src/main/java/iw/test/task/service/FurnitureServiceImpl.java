package iw.test.task.service;

import iw.test.task.model.DataHolder;
import iw.test.task.model.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    public Integer findMax(Integer x, Integer y, Integer z) {
        Integer max = Math.max(Math.max(x, y), z);
        return max;
    }

    public Integer sumCupboard(List<Furniture> furnitures) {
        int sum = 0;
        for (int i = 0; i < furnitures.size(); i++) {
            sum += furnitures.get(i).getWood();
        }
        return sum;
    }

    public Integer sumChair(List<Furniture> furnitures) {
        int sum = 0;
        for (int i = 0; i < furnitures.size(); i++) {
            sum = sum + (furnitures.get(i).getWood() + furnitures.get(i).getGlass());
        }
        return sum;

    }

    public Integer sumTable(List<Furniture> furnitures) {
        int sum = 0;
        for (int i = 0; i < furnitures.size(); i++) {
            sum = sum + (furnitures.get(i).getWood() + furnitures.get(i).getGlass() + furnitures.get(i).getPlastic());
        }
        return sum;
    }

    public String mostExspensive(List<Furniture> furnitureList) {
        Integer sumCupboards = 0;
        Integer sumChairs = 0;
        Integer sumTables = 0;
        DataHolder.furnitures.addAll(furnitureList);
        DataHolder.furnitures.removeIf(r -> (r.getType().equals("cupboard") && (r.getGlass() != null || r.getPlastic() != null)));
        DataHolder.furnitures.removeIf(r -> (r.getType().equals("chair") && r.getPlastic() != null));
        List<Furniture> cupboards = DataHolder.furnitures.stream().filter(r -> r.getType().equals("cupboards")).
                collect(Collectors.toList());
        List<Furniture> chairs = DataHolder.furnitures.stream().filter(r -> r.getType().equals("chair")).
                collect(Collectors.toList());
        List<Furniture> tables = DataHolder.furnitures.stream().filter(r -> r.getType().equals("table")).
                collect(Collectors.toList());

        if (cupboards.size() != 0) {
            sumCupboards = sumCupboard(cupboards);
        }
        if (chairs.size() != 0) {
            sumChairs = sumChair(chairs);
        }
        if (tables.size() != 0) {
            sumTables = sumTable(tables);
        }
        Integer max = findMax(sumCupboards, sumChairs, sumTables);
        if (max == sumCupboards) {
            return "cupboard";
        } else if (max == sumChairs) {
            return "chair";
        } else return "table";
    }
}
