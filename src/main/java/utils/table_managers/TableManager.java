package utils.table_managers;

import entities.Entity;
import javafx.collections.ObservableList;
import utils.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class TableManager {

    private final Connection connection;

    public final String selectionQuery;
    public final String insertionQuery;
    public final String deleteQuery;
    public final String updateQuery;

    public final PreparedStatement preparedInsertionStatement;
    public final PreparedStatement preparedDeleteStatement;
    public final PreparedStatement preparedUpdateStatement;

    private final String tableName;

    public TableManager(Connection connection, String tableName) throws SQLException {
        this.tableName = tableName;
        this.connection = connection;
        selectionQuery = loadSelectionQuery();
        insertionQuery = loadInsertionQuery();
        deleteQuery = loadDeleteQuery();
        updateQuery = loadUpdateQuery();

        preparedInsertionStatement = getConnection().prepareStatement(loadInsertionQuery());
        preparedDeleteStatement = getConnection().prepareStatement(loadDeleteQuery());
        preparedUpdateStatement = getConnection().prepareStatement(loadUpdateQuery());

    }

    public String loadSelectionQuery(){
        return "SELECT * FROM " + tableName;
    }
    public String loadInsertionQuery(){
        System.out.println(getColumns());
        return "INSERT INTO " + tableName + " (" + String.join(", ", getColumns().keySet()) + ") VALUES (" + getColumns().keySet().stream()
                .map(e->"?").collect(Collectors.joining(", ")) + ")";
    }
    public String loadDeleteQuery(){
        return "DELETE FROM " + tableName + " WHERE id=?" ;
    }
    public String loadUpdateQuery(){
        return "UPDATE " + tableName + " SET " + String.join("=?, ", getColumns().keySet()) + "=? WHERE id = ?";
    }

    public void insertRow(Map<String, String> row) throws SQLException{
        int index = 1;
        Map<String, Class> columns = getColumns();
        for(Map.Entry<String, Class> entry: columns.entrySet()){
            if(entry.getValue() == Integer.class){
                String val = row.get(entry.getKey());
                if( !Objects.equals(val,null) && !Objects.equals(val.trim(), "") && !Objects.equals(val, "NULL")){
                    preparedInsertionStatement.setInt(index, Integer.parseInt(val));
                }
            }
            if(entry.getValue() == String.class){
                String val = row.get(entry.getKey());
                if( !Objects.equals(val,null) && !Objects.equals(val.trim(), "") && !Objects.equals(val, "NULL")){
                    preparedInsertionStatement.setString(index, val);
                }
            }
            if(entry.getValue() == Date.class){
                String val = row.get(entry.getKey());
                if( !Objects.equals(val,null) && !Objects.equals(val.trim(), "") && !Objects.equals(val, "NULL")){
                    preparedInsertionStatement.setDate(index, Date.valueOf(val));
                }
            }
            index++;
        }
        preparedInsertionStatement.execute();
    }

    public abstract Map<String, Class> getColumns();

    public void updateRow(Map<String, String> row) throws SQLException {
        int index = 1;
        Map<String, Class> columns = getColumns();
        for(Map.Entry<String, Class> entry: columns.entrySet()){
            if(entry.getValue() == Integer.class){
                String val = row.get(entry.getKey());
                if( !Objects.equals(val,null) && !Objects.equals(val.trim(), "") && !Objects.equals(val, "NULL")){
                    preparedInsertionStatement.setInt(index, Integer.parseInt(val));
                } else {
                    preparedInsertionStatement.setObject(index, null);
                }
            }
            if(entry.getValue() == String.class){
                String val = row.get(entry.getKey());
                if( !Objects.equals(val,null) && !Objects.equals(val.trim(), "") && !Objects.equals(val, "NULL")){
                    preparedInsertionStatement.setString(index, val);
                } else {
                    preparedInsertionStatement.setObject(index, null);
                }
            }
            if(entry.getValue() == Date.class){
                String val = row.get(entry.getKey());
                if( !Objects.equals(val,null) && !Objects.equals(val.trim(), "") && !Objects.equals(val, "NULL")){
                    preparedInsertionStatement.setDate(index, Date.valueOf(val));
                } else {
                    preparedInsertionStatement.setObject(index, null);
                }
            }
            index++;
        }
        preparedUpdateStatement.setInt(index, Integer.parseInt(row.get("id")));
        preparedUpdateStatement.execute();
    }

    public void deleteRow(String rowId) throws SQLException {
        preparedDeleteStatement.setInt(1, Integer.parseInt(rowId));
        preparedDeleteStatement.execute();
    }

    public abstract ObservableList<Entity> getTableRows();

    public Connection getConnection() {
        return connection;
    }
}
