package org.nuk;

import org.nuk.db.MariaDBConnection;
import org.nuk.db.models.dao.impl.CategoryDaoMySql;

public class BookTest {
    public static void main(String[] args) {
        var connection = MariaDBConnection.getInstance().getConnection();
        var categoryDao = new CategoryDaoMySql(connection);

        System.out.println(categoryDao.findById(1));

    }
}
