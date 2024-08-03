import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CountryFinderApp extends Application {

    private CountryFinder countryFinder;

    @Override
    public void start(Stage primaryStage) {
        countryFinder = new CountryFinder("countries.txt");

        primaryStage.setTitle("Country Finder");

        // Create UI components
        TextField searchField = new TextField();
        Button searchButton = new Button("Search");
        TableView<Country> countryTable = new TableView<>();

        // Set up the TableView columns
        TableColumn<Country, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        
        TableColumn<Country, String> capitalColumn = new TableColumn<>("Capital");
        capitalColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCapital()));
        
        TableColumn<Country, Integer> populationColumn = new TableColumn<>("Population");
        populationColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPopulation()).asObject());

        countryTable.getColumns().addAll(nameColumn, capitalColumn, populationColumn);

        // Set up the layout
        VBox vbox = new VBox();
        vbox.getChildren().addAll(searchField, searchButton, countryTable);

        // Set up the search button action
        searchButton.setOnAction(event -> {
            String searchText = searchField.getText();
            countryTable.getItems().clear();
            countryTable.getItems().addAll(countryFinder.s
