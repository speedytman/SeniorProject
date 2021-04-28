import com.mathworks.engine.*;

import java.io.File;
import java.util.concurrent.ExecutionException;

import javafx.application.*;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class Main extends Application implements EventHandler<ActionEvent>{

	Stage stage;
	Scene Home, AddLicensePlate, RemoveLicensePlate;
	Button selectImage, runStuff;
	MenuItem sceneAddLicensePlate, sceneRemoveLicensePlate, sceneHome;
	Text outText, approvedText, inputImagePath;
	Rectangle approvalShow;
	ImageView plateImage, inputImage;
	TableView approvedPlates;
	File selectedFile;
	Image lpImage;
	VBox selectImageVBox;
	int windowHeight = 1000;
	int windowWidth = 2000;
	int xStart = 0;
	int xMid = windowWidth/2;
	int xEnd = windowWidth;
	int yStart = 0;
	int yMid = windowHeight/2;
	int yEnd = windowHeight;
	int fontSizeLarge = 100;
	int fontSizeMedium = 80;
	int fontSizeSmall = 20;
	int lineWeight = 5;
	
	public static void main(String[] args) throws Exception{
        launch(args);
	}
	
	public void addLicensePlate() {
		Group root = new Group();
		
		AddLicensePlate = new Scene(root, Color.ALICEBLUE);
		
		Text title = new Text();
		title.setText("Add License Plates");
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(Font.font("Times New Roman", fontSizeLarge));
		HBox TitleHBox = new HBox(title);
		TitleHBox.setAlignment(Pos.TOP_CENTER);
		TitleHBox.setLayoutX(xStart);
		TitleHBox.setLayoutY(yStart-(windowHeight*0.015));
		TitleHBox.setMinSize(windowWidth, windowHeight*0.15);
		root.getChildren().add(TitleHBox);
		
		approvedPlates = new TableView();
		approvedPlates.setLayoutX(xMid);
		approvedPlates.setLayoutY(yMid);
		TableColumn<LicensePlate, String> column1 = new TableColumn<>("Approved Plates");
		approvedPlates.getColumns().add(column1);
		root.getChildren().add(approvedPlates);
		LicensePlate lp = new LicensePlate();
		
		Button btn1 = new Button("Get Approved Plate");
		btn1.setOnAction(e -> {
			System.out.println(lp.getAllApprovedPlate());
		});
		btn1.setLayoutX(xMid-200);
		btn1.setLayoutY(yMid-100);
		root.getChildren().add(btn1);
		
		Button btn2 = new Button("Add Approved Plate");
		btn2.setOnAction(e -> {
			lp.addApprovedPlate("Hello");
		});
		btn2.setLayoutX(xMid-200);
		btn2.setLayoutY(yMid-200);
		root.getChildren().add(btn2);
	
		Button btn3 = new Button("Remove Approved Plate");
		btn3.setOnAction(e -> {
			lp.removeApprovedPlate("Hello");
		});
		btn3.setLayoutX(xMid-200);
		btn3.setLayoutY(yMid);
		root.getChildren().add(btn3);
		//draws lines on screen
		Line line1 = new Line();
		line1.setStartX(xStart);
		line1.setStartY(windowHeight*0.85);
		line1.setEndX(xEnd);
		line1.setEndY(windowHeight*0.85);
		line1.setStrokeWidth(lineWeight);
		root.getChildren().add(line1);
				
		Line line2 = new Line();
		line2.setStartX(xMid);
		line2.setStartY(windowHeight/10);
		line2.setEndX(xMid);
		line2.setEndY(windowHeight*0.85);
		line2.setStrokeWidth(lineWeight);
		root.getChildren().add(line2);
				
		Line line3 = new Line();
		line3.setStartX(xStart);
		line3.setStartY(windowHeight/10);
		line3.setEndX(xEnd);
		line3.setEndY(windowHeight/10);
		line3.setStrokeWidth(lineWeight);
		root.getChildren().add(line3);
		
		Menu menu1 = new Menu("Home");
		sceneHome = new MenuItem("Home");
		sceneHome.setOnAction(this);
		menu1.getItems().add(sceneHome);
		Menu menu2 = new Menu("Approved Plates");
		MenuItem menu2Item1 = new MenuItem("Source...");
		sceneAddLicensePlate = new MenuItem("Add Plates");
		sceneRemoveLicensePlate = new MenuItem("Remove Plates");
		sceneAddLicensePlate.setOnAction(this);
		sceneRemoveLicensePlate.setOnAction(this);
		menu2.getItems().add(menu2Item1);
		menu2.getItems().add(sceneAddLicensePlate);
		menu2.getItems().add(sceneRemoveLicensePlate);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2);
		root.getChildren().add(menuBar);
		
	}
	public void removeLicensePlate() {
		Group root = new Group();
		
		RemoveLicensePlate = new Scene(root, Color.LIGHTGREEN);
		
		Text title = new Text();
		title.setText("Remove License Plates");
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(Font.font("Times New Roman", fontSizeLarge));
		HBox TitleHBox = new HBox(title);
		TitleHBox.setAlignment(Pos.TOP_CENTER);
		TitleHBox.setLayoutX(xStart);
		TitleHBox.setLayoutY(yStart-(windowHeight*0.015));
		TitleHBox.setMinSize(windowWidth, windowHeight*0.15);
		root.getChildren().add(TitleHBox);
		
		//draws lines on screen
		Line line1 = new Line();
		line1.setStartX(xStart);
		line1.setStartY(windowHeight*0.85);
		line1.setEndX(xEnd);
		line1.setEndY(windowHeight*0.85);
		line1.setStrokeWidth(lineWeight);
		root.getChildren().add(line1);
				
		Line line2 = new Line();
		line2.setStartX(xMid);
		line2.setStartY(windowHeight/10);
		line2.setEndX(xMid);
		line2.setEndY(windowHeight*0.85);
		line2.setStrokeWidth(lineWeight);
		root.getChildren().add(line2);
				
		Line line3 = new Line();
		line3.setStartX(xStart);
		line3.setStartY(windowHeight/10);
		line3.setEndX(xEnd);
		line3.setEndY(windowHeight/10);
		line3.setStrokeWidth(lineWeight);
		root.getChildren().add(line3);	
		
		Menu menu1 = new Menu("Home");
		sceneHome = new MenuItem("Home");
		sceneHome.setOnAction(this);
		menu1.getItems().add(sceneHome);
		Menu menu2 = new Menu("Approved Plates");
		MenuItem menu2Item1 = new MenuItem("Source...");
		sceneAddLicensePlate = new MenuItem("Add Plates");
		sceneRemoveLicensePlate = new MenuItem("Remove Plates");
		sceneAddLicensePlate.setOnAction(this);
		sceneRemoveLicensePlate.setOnAction(this);
		menu2.getItems().add(menu2Item1);
		menu2.getItems().add(sceneAddLicensePlate);
		menu2.getItems().add(sceneRemoveLicensePlate);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2);
		root.getChildren().add(menuBar);
	}
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("CTS");//title for the window i.e. eclipse-workspace
		//if the primary resolution height is less than 1100px so 1080p and below the window size will scale down
		if(Screen.getPrimary().getBounds().getMaxX() < 1100) {
			windowHeight = 500;
			windowWidth = 1000;
			xMid = windowWidth/2;
			xEnd = windowWidth;
			yMid = windowHeight/2;
			yEnd = windowHeight;
			fontSizeLarge = 50;
			fontSizeMedium = 40;
			fontSizeSmall = 10;
			lineWeight = 2;
		}
		//this is where all of the objects are inserted
		Group root = new Group();
		//contains all of the UI containers(only root for current application)
		Home = new Scene(root,Color.DARKGRAY);
		//draws a rectangle with a base color the same as the background(this is changed later to show status of license plate)
		approvalShow = new Rectangle(xMid, windowHeight*0.65, xEnd-xMid, windowHeight/10);
		approvalShow.setFill(Color.DARKGRAY);
		root.getChildren().add(approvalShow);
		
		
		//creates blank image display(will be filled later)
		inputImage = new ImageView();
		inputImage.setLayoutX(xStart);
		inputImage.setLayoutY(windowHeight/10);
		inputImage.setFitHeight(windowHeight*0.75);
		inputImage.setFitWidth(windowWidth/2);
		root.getChildren().add(inputImage);
		
		//stylesheet (only used for buttons)
		Home.getStylesheets().add("stylesheet.css");
		
		//promt the user to select an image file
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JPG Files", "*.jpg")
				,new FileChooser.ExtensionFilter("PNG Files", "*.png")
				);
		//VBox and button for selecting image
		selectImageVBox = new VBox();
		selectImage = new Button();
		selectImage.setText("Select Image Path");
		//action if button is pressed
		selectImage.setOnAction(e -> {
			//opens a system explorer instance to choose an image file
			selectedFile = fileChooser.showOpenDialog(null);
			
			//sets image to be the image at the path of the selected file
			Image image = new Image(selectedFile.toURI().toString());
			
			//sets image to be the image shown in the left image display
			inputImage.setImage(image);
			
			//text to show the selected image path below the button
			inputImagePath = new Text();
			inputImagePath.setText(selectedFile.getPath());
			inputImagePath.setTextAlignment(TextAlignment.CENTER);
			inputImagePath.setFont(Font.font("Times New Roman", fontSizeSmall));
			selectImageVBox.getChildren().add(inputImagePath);
		});
		selectImageVBox.getChildren().add(selectImage);
		
		//VBox for run button
		selectImageVBox.setAlignment(Pos.TOP_CENTER);
		selectImageVBox.setLayoutX(xStart);
		selectImageVBox.setLayoutY(windowHeight*0.85);
		selectImageVBox.setMinSize(windowWidth/2, windowHeight/10);
		root.getChildren().add(selectImageVBox);
		
		//run button
		runStuff = new Button();
		//runStuff.setLayoutX(1900);
		//runStuff.setLayoutY(900);
		runStuff.setText("Run");
		//when clicked look in this class for a method to use
		runStuff.setOnAction(this);
		VBox runStuffVBox = new VBox(runStuff);
		runStuffVBox.setAlignment(Pos.TOP_CENTER);
		runStuffVBox.setLayoutX(xMid);
		runStuffVBox.setLayoutY(windowHeight*0.85);
		runStuffVBox.setMinSize(windowWidth/2, windowHeight/10);
		root.getChildren().add(runStuffVBox);
		
		//blank image display for right image(loaded later)
		plateImage = new ImageView();
		plateImage.setLayoutX(xMid);
		plateImage.setLayoutY(windowHeight/10);
		plateImage.setFitHeight(windowHeight*0.55);
		plateImage.setFitWidth(windowWidth/2);
		root.getChildren().add(plateImage);
		
		//Title text
		Text CTS = new Text();
		CTS.setText("Car Tag Scanner");
		CTS.setTextAlignment(TextAlignment.CENTER);
		CTS.setFont(Font.font("Times New Roman", fontSizeLarge));
		HBox CTSHBox = new HBox(CTS);
		CTSHBox.setAlignment(Pos.TOP_CENTER);
		CTSHBox.setLayoutX(xStart);
		CTSHBox.setLayoutY(yStart-(windowHeight*0.015));
		CTSHBox.setMinSize(windowWidth, windowHeight*0.15);
		root.getChildren().add(CTSHBox);
		
		//License Plate Text returned by the OCR
		outText = new Text();
		outText.setTextAlignment(TextAlignment.CENTER);
		outText.setFont(Font.font("Times New Roman", fontSizeMedium));
		HBox outTextHBox = new HBox(outText);
		outTextHBox.setAlignment(Pos.CENTER);
		outTextHBox.setLayoutX(xMid);
		outTextHBox.setLayoutY(windowHeight*0.75);
		outTextHBox.setMinSize(windowWidth/2, windowHeight/10);
		root.getChildren().add(outTextHBox);
		
		//text that appear if the license plate is aproved or not
		approvedText = new Text();
		approvedText.setTextAlignment(TextAlignment.CENTER);
		approvedText.setFont(Font.font("Times New Roman", fontSizeMedium));
		approvedText.setFill(Color.WHITE);
		HBox approvedTextHBox = new HBox(approvedText);
		approvedTextHBox.setAlignment(Pos.CENTER);
		approvedTextHBox.setLayoutX(xMid);
		approvedTextHBox.setLayoutY(windowHeight*0.65);
		approvedTextHBox.setMinSize(windowWidth/2, windowHeight/10);
		root.getChildren().add(approvedTextHBox);
		
		//draws lines on screen
		Line line1 = new Line();
		line1.setStartX(xStart);
		line1.setStartY(windowHeight*0.85);
		line1.setEndX(xEnd);
		line1.setEndY(windowHeight*0.85);
		line1.setStrokeWidth(lineWeight);
		root.getChildren().add(line1);
		
		Line line2 = new Line();
		line2.setStartX(xMid);
		line2.setStartY(windowHeight/10);
		line2.setEndX(xMid);
		line2.setEndY(windowHeight*0.85);
		line2.setStrokeWidth(lineWeight);
		root.getChildren().add(line2);
		
		Line line3 = new Line();
		line3.setStartX(xStart);
		line3.setStartY(windowHeight/10);
		line3.setEndX(xEnd);
		line3.setEndY(windowHeight/10);
		line3.setStrokeWidth(lineWeight);
		root.getChildren().add(line3);
		
		Line line4 = new Line();
		line4.setStartX(xMid);
		line4.setStartY(windowHeight*0.75);
		line4.setEndX(xEnd);
		line4.setEndY(windowHeight*0.75);
		line4.setStrokeWidth(lineWeight);
		root.getChildren().add(line4);
		
		Line line5 = new Line();
		line5.setStartX(xMid);
		line5.setStartY(windowHeight*0.65);
		line5.setEndX(xEnd);
		line5.setEndY(windowHeight*0.65);
		line5.setStrokeWidth(lineWeight);
		root.getChildren().add(line5);
		
		Menu menu1 = new Menu("Home");
		sceneHome = new MenuItem("Home");
		sceneHome.setOnAction(this);
		menu1.getItems().add(sceneHome);
		Menu menu2 = new Menu("Approved Plates");
		MenuItem menu2Item1 = new MenuItem("Source...");
		sceneAddLicensePlate = new MenuItem("Add Plates");
		sceneRemoveLicensePlate = new MenuItem("Remove Plates");
		sceneAddLicensePlate.setOnAction(this);
		sceneRemoveLicensePlate.setOnAction(this);
		menu2.getItems().add(menu2Item1);
		menu2.getItems().add(sceneAddLicensePlate);
		menu2.getItems().add(sceneRemoveLicensePlate);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2);
		root.getChildren().add(menuBar);
		
		//sets the icon
		Image icon = new Image("CTS_Logo.png");
		stage.getIcons().add(icon);//sets icon for application
		stage.setWidth(windowWidth);//width of window
		stage.setHeight(windowHeight);//height of window
		stage.setResizable(false);//allow resizing
		
		stage.setScene(Home);//sets the scene to the stage
		stage.show();//needs to be at end, displays the window on launch
	}
	public void handle(ActionEvent event){
		//if button pressed is runStuff
		if(event.getSource()==runStuff) {
			//if file path is not empty
			if(selectedFile.getPath() != null) {
				MatlabEngine eng;
				try {
					//start matlab engine, change directory
					eng = MatlabEngine.startMatlab();
					//dynamicly locate working directory
					String dir = System.getProperty("user.dir");
					eng.eval("cd '" + dir + "\\src'");
					String x = eng.feval("My_Func", selectedFile.getPath());
					// image for right image display
					lpImage = new Image(selectedFile.toURI().toString());
					//if the returned OCR text is null the text was unreadably by the OCR
					if(x == null) {
						x = "Image Text Unreadable";
					} else {
						x = x.replaceAll("[\\n\\t ]", "");//read text has two new lines at the end and contains spaces, this removes them
					}
					outText.setFill(Color.BLACK);
					outText.setText(x);//dispays the predicted license plate text
					eng.close();//closes the engine
					
					//adds image to right image display
					plateImage.setImage(lpImage);
					
					//in place of the database for now
					String[] licensePlates = new String[3];
					licensePlates[0] = "B21GSB";
					licensePlates[1] = "SB90TZI";
					licensePlates[2] = "C99BNX";
					boolean approved = false;
					//check if predicted plate is in the "database"
					for(int i = 0; i < licensePlates.length; i++) {
						if(licensePlates[i].equals(x.toString())) {
							approved = true;
							//sets text to approved and rectangle color to green
							approvedText.setText("APPROVED");
							approvedText.setFill(Color.WHITE);
							approvalShow.setFill(Color.LAWNGREEN);
						}
						System.out.println(licensePlates[i].equals(x.toString()) + ": " + i);
					}
					if(approved == false) {
						//sets test to not approved and rectangle color to red
						approvedText.setText("NOT APPROVED");
						approvalShow.setFill(Color.RED);
					}
				} catch (IllegalArgumentException | IllegalStateException | InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				//error
				approvalShow.setFill(Color.DARKORANGE);
				outText.setText("ERROR: No Image Selected");
				approvedText.setText("ERROR: No Image Selected");
				
			}
			
		}
		if(event.getSource() == sceneAddLicensePlate) {
			addLicensePlate();
			stage.setScene(AddLicensePlate);
		}
		if(event.getSource() == sceneRemoveLicensePlate) {
			removeLicensePlate();
			stage.setScene(RemoveLicensePlate);
		}
		if(event.getSource() == sceneHome) {
			System.out.println("Go Home");
			stage.setScene(Home);
		}
		
	}
}
