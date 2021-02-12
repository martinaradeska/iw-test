package iw.test.task.service;
import iw.test.task.model.Furniture;
import java.util.List;

public interface FurnitureService
{
    Integer findMax(Integer x, Integer y, Integer z);
    Integer sumCupboard(List<Furniture> furnitures);
    Integer sumChair(List<Furniture> furnitures);
    Integer sumTable(List<Furniture> furnitures);
    String mostExspensive(List<Furniture> furnitureList);

}
