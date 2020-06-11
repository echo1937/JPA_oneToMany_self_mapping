package com.example.area;

import com.example.area.entity.Area;
import com.example.area.entity.Category;
import com.example.area.repository.AreaRepository;
import com.example.area.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AreaApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private AreaRepository areaRepository;

    @Test
    public void addArea() {

        // 广东省 (顶级区域)
        Area guangdong = new Area();
        guangdong.setName("广东省");
        areaRepository.save(guangdong);

        //广东省 下面的 广州市(二级区域)
        Area guangzhou = new Area();
        guangzhou.setName("广州市");
        guangzhou.setParent(guangdong);
        areaRepository.save(guangzhou);

        //广州市 下面的 天河区(三级区域)
        Area tianhe = new Area();
        tianhe.setName("天河区");
        tianhe.setParent(guangzhou);
        areaRepository.save(tianhe);

        //广东省 下面的 湛江市(二级区域)
        Area zhanjiang = new Area();
        zhanjiang.setName("湛江市");
        zhanjiang.setParent(guangdong);
        areaRepository.save(zhanjiang);

        //湛江市 下面的 霞山区(三级区域)
        Area xiashan = new Area();
        xiashan.setName("霞山区");
        xiashan.setParent(zhanjiang);
        areaRepository.save(xiashan);
    }

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void addCategory() {

        //一个 家用电器分类(顶级分类)
        Category appliance = new Category();
        appliance.setName("家用电器");
        categoryRepository.save(appliance);

        //家用电器 下面的 电脑分类(二级分类)
        Category computer = new Category();
        computer.setName("电脑");
        computer.setParent(appliance);
        categoryRepository.save(computer);

        //电脑 下面的 笔记本电脑分类(三级分类)
        Category notebook = new Category();
        notebook.setName("笔记本电脑");
        notebook.setParent(computer);
        categoryRepository.save(notebook);

        //家用电器 下面的 手机分类(二级分类)
        Category mobile = new Category();
        mobile.setName("手机");
        mobile.setParent(appliance);
        categoryRepository.save(mobile);

        //手机 下面的 智能机 / 老人机(三级分类)
        Category smartPhone = new Category();
        smartPhone.setName("智能机");
        smartPhone.setParent(mobile);
        categoryRepository.save(smartPhone);

        Category oldPhone = new Category();
        oldPhone.setName("老人机");
        oldPhone.setParent(mobile);
        categoryRepository.save(oldPhone);
    }


}
