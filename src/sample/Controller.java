package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller {
    ObservableList items = FXCollections.observableArrayList();
    ArrayList<Product> productArrayList = new ArrayList<>();
    @FXML
    private ListView<String> list;
    @FXML
    private ResourceBundle resources;
    @FXML
    private Button update;
    @FXML
    private TextField productName;
    @FXML
    private TextField quantity;
    @FXML
    private TextField oldPrice;
    @FXML
    private TextField newPrice;
    @FXML
    private Label desc;
    @FXML
    private ImageView picView;
    public void initialize() {
        setupInit();
    }
    public void setupInit(){
        productArrayList.add(new Product("Pfeffer","1 Stück","3,49","2,79","pfeffer.jpg","Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, besonders wenn er länger mitgekocht wird."));
        productArrayList.add(new Product("Schafmilchkäse","200 Gramm","2,59","1,99","cheese_salakis.jpg","Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt."));
        productArrayList.add(new Product("Vöslauer","1,5 Liter","0,75","0,49","voslauer.jpg","Spritziges Vöslauer Mineralwasser."));
        productArrayList.add(new Product("Zucker","500 Gramm","1,39","0,89","zucker.jpg","Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde."));
        items.addAll(productArrayList);
        /*items.addAll(new Product("Pfeffer","1 Stück",3.49,2.79,"pfeffer.jpg","Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, besonders wenn er länger mitgekocht wird."),
                new Product("Schafmilchkäse","200 Gramm",2.59,1.99,"cheese_salakis.jpg","Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt."),
                new Product("Vöslauer","1,5 Liter",0.75,0.49,"voslauer.jpg","Spritziges Vöslauer Mineralwasser."),
                new Product("Zucker","500 Gramm",1.39,0.89,"zucker.jpg","Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde.")
        );*/

        list.getItems().addAll(items);
    }
    public void loadItem() throws FileNotFoundException {
        File pic = new File(productArrayList.get((list.getSelectionModel().getSelectedIndex())).getImgPath());
        Image image = new Image(new FileInputStream(pic));
        System.out.println(productArrayList.get((list.getSelectionModel().getSelectedIndex())).getProductName());
        productName.setText(productArrayList.get((list.getSelectionModel().getSelectedIndex())).getProductName());
        quantity.setText(productArrayList.get((list.getSelectionModel().getSelectedIndex())).getQuantity());
        oldPrice.setText(productArrayList.get((list.getSelectionModel().getSelectedIndex())).getOldPrice());
        newPrice.setText(productArrayList.get((list.getSelectionModel().getSelectedIndex())).getNewPrice());
        desc.setText(productArrayList.get((list.getSelectionModel().getSelectedIndex())).getDescription());
        picView.setImage(image);
    }
    public void updatePrice(){
        productArrayList.get((list.getSelectionModel().getSelectedIndex())).setNewPrice(newPrice.getText());
        productArrayList.get((list.getSelectionModel().getSelectedIndex())).setOldPrice(oldPrice.getText());
        list.refresh();
    }
    public void printReport() throws IOException {
        String str;
        BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));
        for (int i = 0; i<productArrayList.size();i++){
            str= productArrayList.get(i).getProductName()+"\n"+productArrayList.get(i).getQuantity()+"\n"+productArrayList.get(i).getOldPrice()+"\n"+productArrayList.get(i).getNewPrice()+"\n";
            writer.write(str);
        }
        writer.close();
        System.out.println("file written");
    }
}
