package org.nuk.db.models.dao.impl;

import org.nuk.db.models.dao.CategoryDao;
import org.nuk.db.models.entities.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDaoMySql implements CategoryDao {

    Connection connection;

    public CategoryDaoMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public Category findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String baseQuery = "SELECT * FROM category WHERE id = ?";

        try {
            statement = connection.prepareStatement(baseQuery);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Category> findAll() {
        return null;
    }
}
