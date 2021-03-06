package controller.request;

import controller.Controller;
import controller.table.Request;
import database_managers.request_managers.InfoAboutCustomersManager;
import database_managers.request_managers.InfoAboutSellerWorkManager;
import entities.Customer;
import entities.Entity;
import entities.Good;
import entities.TradePoint;
import entities.TradeType;
import init.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import utils.ChoiceUnit;
import utils.Navigation;
import utils.TableNames;

public class InfoAboutSellerWorkController extends Controller implements Initializable, Request {
    public static final String INFO_ABOUT_SELLER_WORK_WINDOW_FXML = "/window/request/InfoAboutSellerWork.fxml";

    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTo;

    @FXML
    private ChoiceBox<ChoiceUnit> tradePointType;

    @FXML
    private ChoiceBox<ChoiceUnit> tradePoint;

    @FXML
    private TableView resultTable;

    private final InfoAboutSellerWorkManager manager = new InfoAboutSellerWorkManager();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTradePoint().stream().map(e->new ChoiceUnit(e.getId(), ((TradePoint)e).getName())).forEach(tradePoint.getItems()::addAll);
        loadTradePointType().stream().map(e->new ChoiceUnit(e.getId(), ((TradeType)e).getName())).forEach(tradePointType.getItems()::addAll);

        TableColumn<Customer, String> columnId = new TableColumn<>("id");
        TableColumn<Customer, String> columnName = new TableColumn<>("name");
        TableColumn<Customer, String> columnAge = new TableColumn<>("age");

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age") );

        resultTable.getColumns().addAll(columnId, columnName, columnAge);

        tradePoint.setConverter(new StringConverter<ChoiceUnit>() {
            @Override
            public String toString(ChoiceUnit object) {
                return object.getDisplayedName();
            }

            @Override
            public ChoiceUnit fromString(String string) {
                return tradePoint.getItems().stream().filter(e -> e.getDisplayedName().equals(string)).findFirst().orElse(null);
            }
        });

        tradePointType.setConverter(new StringConverter<ChoiceUnit>() {
            @Override
            public String toString(ChoiceUnit object) {
                return object.getDisplayedName();
            }

            @Override
            public ChoiceUnit fromString(String string) {
                return tradePointType.getItems().stream().filter(e -> e.getDisplayedName().equals(string)).findFirst().orElse(null);
            }
        });
    }

    private ObservableList<Entity> loadGood(){
        return Main.getDatabaseManager().getTableManager(TableNames.GOODS).getTableRows();
    }

    private ObservableList<Entity> loadTradePointType(){
        return Main.getDatabaseManager().getTableManager(TableNames.TRADE_TYPE).getTableRows();
    }

    private ObservableList<Entity> loadTradePoint(){
        return Main.getDatabaseManager().getTableManager(TableNames.TRADE_POINTS).getTableRows();
    }

    @FXML
    public void clearTradePoint(){
        tradePoint.getItems().clear();
        tradePointType.getItems().clear();
    }

    @FXML
    public void clearDate(){
        dateFrom.setValue(null);
        dateTo.setValue(null);
    }

    @FXML
    public void query(){
    String query =
        "SELECT S2.NAME as seller_name, SUM(PC.RESULT_PRICE) as result_price, COUNT(*) as count"
            + " FROM SALES S"
            + " INNER JOIN SELLERS S2 on S2.ID = S.SELLER"
            + " INNER JOIN PURCHASE_COMPOSITIONS PC on PC.ID = S.PURCHASE_COMPOSITION"
            + " INNER JOIN GOODS G on G.ID = PC.GOOD"
            + " INNER JOIN TRADE_POINTS TP on TP.ID = S2.TRADE_POINT"
            + " INNER JOIN TRADE_TYPES TT on TT.ID = TP.TYPE"
            + " WHERE 1=1";

        try {
            checkCorrectness();
        } catch (Exception e) {
            return;
        }

        if(dateFrom.getValue()!=null){
            query+= " AND PC.PURCHASE_DATE > TO_DATE('" + dateFrom.getValue().toString() + "', 'YYYY-MM-DD')";
        }
        if(dateTo.getValue()!=null){
            query+= " AND PC.PURCHASE_DATE < TO_DATE('" + dateTo.getValue().toString() + "', 'YYYY-MM-DD')";
        }

        if(tradePoint.getValue()!=null && tradePointType.getValue()==null){
            query+= " AND TP.NAME='" + tradePoint.getValue().getDisplayedName() +"'";
        }else if(tradePoint.getValue()==null && tradePointType.getValue()!=null){
            query+= " AND TT.NAME='" + tradePointType.getValue().getDisplayedName() +"'";
        }

        query += " GROUP BY S2.NAME";

        System.out.println("Query: " + query);

        updateResultTable(manager.executeQuery(query));
    }

    @Override
    public void checkCorrectness() throws Exception {
        if(dateTo.getValue()==null && dateFrom.getValue()==null){
            Navigation.showAlert("???????? ???????????????????? ????????????", "?????????????? ????????.");
            throw new Exception();
        }

        if (tradePoint.getValue() != null && tradePointType.getValue() != null) {
            Navigation.showAlert(
                "???????? ???????????????????? ????????????",
                "???????????????? ???????????????? ??????????, ?????? ???????????????? ??????????, ???????? ???????????????? ?????? ???????????????? ??????????????");
            throw new Exception();
        }
    }

    private void clearResultTable(){
        resultTable.getItems().clear();
    }

    private void updateResultTable(ObservableList<Entity> result){
        clearResultTable();
        resultTable.getItems().addAll(result);
    }

}
