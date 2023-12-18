package org.nuk;

import org.nuk.db.MariaDBConnection;

public class BookTest {
    public static void main(String[] args) {
        MariaDBConnection.getInstance().getConnection();
        MariaDBConnection.getInstance().closeConnection();
    }
}
