package utils.tableManagers;

import utils.Connection;

import java.util.List;
import java.util.Map;

public class PurchaseCompositionsTableManager extends TableManager {


    public PurchaseCompositionsTableManager(Connection connection) {
        super(connection);
    }

    @Override
    public String loadSelectionQuery() {
        return null;
    }

    @Override
    public String loadInsertionQuery() {
        return null;
    }

    @Override
    public String loadDeleteQuery() {
        return null;
    }

    @Override
    public String loadUpdateQuery() {
        return null;
    }

    @Override
    List<String> getColumnNames() {
        return null;
    }

    @Override
    public void insertRow(Map<String, String> row) {
        System.out.println(row.toString());
    }

}
