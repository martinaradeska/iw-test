package iw.test.task.controller;

import iw.test.task.model.Furniture;
import iw.test.task.service.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("furnitures")
public class FurnitureRestController {
    @Autowired
    private FurnitureServiceImpl furnitureServiceImpl;

    public FurnitureRestController(FurnitureServiceImpl furnitureServiceImpl) {
        this.furnitureServiceImpl = furnitureServiceImpl;
    }

    @PostMapping("/mostexpensive")
    public String mostExpensive(@RequestBody Furniture[] furnitures) {
        List<Furniture> furnitureList = Arrays.asList(furnitures);
        return this.furnitureServiceImpl.mostExspensive(furnitureList);
    }
}
