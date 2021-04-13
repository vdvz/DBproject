package controller.insertion;

import Entities.Entity;
import Entities.Good;
import init.Main;
import javafx.collections.ObservableList;
import utils.ChoiceUnit;
import utils.EnterItem;
import utils.SelectItem;
import utils.TableNames;
import utils.table_managers.SellersTableManager;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class SellersInsertionWindowController extends InsertionWindowController {


    private final SellersTableManager tableManager = (SellersTableManager) Main.getDatabaseManager().getTableManager(TableNames.SELLERS);
    private EnterItem countItem;
    private SelectItem goodItem;
    private EnterItem resultPriceItem;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);

        countItem = new EnterItem("count");
        goodItem = new SelectItem("good");
        resultPriceItem = new EnterItem("result_price");

        loadAvailableGoods().stream().map(e->new ChoiceUnit(((Good)e).getId(), ((Good)e).getName())).forEach(goodItem::addItemsToSelect);

        hBox.getChildren().addAll(countItem, goodItem, resultPriceItem);

    }

    @Override
    public void insertRow() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put(getIdItem().getColumnName(), getIdItem().getEnteredText());
        valuesMap.put(countItem.getColumnName(), countItem.getEnteredText());
        valuesMap.put(goodItem.getColumnName(), goodItem.getSelectedItem().getId());
        valuesMap.put(resultPriceItem.getColumnName(), resultPriceItem.getEnteredText());

        if (getMode().equals(MODE.INSERTING)) {
            tableManager.insertRow(valuesMap);
        } else {
            tableManager.updateRow(valuesMap);
        }
    }

    @Override
    public void initUpdating(Entity value) {

    }

    private ObservableList<Entity> loadAvailableGoods(){
        return Main.getDatabaseManager().getTableManager(TableNames.GOODS).getTableRows();
    }

}