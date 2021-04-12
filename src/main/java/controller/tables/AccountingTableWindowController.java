package controller.tables;

import TableRows.ProviderTableRow;
import controller.Entities.Account;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountingTableWindowController extends TableWindowController {


    public AccountingTableWindowController() {
        super("ACCOUNTING");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        TableColumn<Account, String> columnId = new TableColumn<>("id");
        TableColumn<Account, String> columnTradePoint = new TableColumn<>("trade_point");
        TableColumn<Account, String> columnGood = new TableColumn<>("good");
        TableColumn<Account, String> columnCount = new TableColumn<>("count");
        TableColumn<Account, String> columnPrice = new TableColumn<>("price");

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnTradePoint.setCellValueFactory(new PropertyValueFactory<>("tradePoint"));
        columnGood.setCellValueFactory(new PropertyValueFactory<>("good"));
        columnCount.setCellValueFactory(new PropertyValueFactory<>("count"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(columnId, columnTradePoint, columnGood, columnCount, columnPrice);
    }

    @Override
    public void createNewRow() {

    }

}
