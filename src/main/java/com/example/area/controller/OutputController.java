package com.example.area.controller;

import com.example.area.entity.Area;
import com.example.area.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutputController {
    @Autowired
    private AreaRepository areaRepository;

    @GetMapping("area")
    public Area getArea() {
        List<Area> areas = areaRepository.findAll();
        return areas.get(0);
    }

    @GetMapping("areas")
    public List<Area> getAreas() {
        return areaRepository.findAll();
    }
}
