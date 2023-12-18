package org.nuk.db.models.dao;

import org.nuk.db.models.entities.Category;

import java.util.ArrayList;

public interface CategoryDao {
    void insert(Category category);
    void update(Category category);
    void deleteById(Integer id);
    void delete(Category category);
    Category findById(Integer id);

    ArrayList<Category> findAll();
}
