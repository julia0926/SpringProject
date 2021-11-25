package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.Category;
import net.skhu.mapper.CategoryMapper;

@Service
public class CategoryService {

    @Autowired
    public CategoryMapper CategoryMapper;

    public List<Category> findAll() {
        return CategoryMapper.findAll();
    }

}

