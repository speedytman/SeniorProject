import com.mathworks.engine.*;

import java.io.File;
import java.util.concurrent.ExecutionException;

import java.sql.*;

import javafx.application.*;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javafx.scene.control.Button;
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

	Button selectImage;
	Button runStuff;
	Group root;
	Text outText;
	Text approvedText;
	Text inputImagePath;
	Rectangle approvalShow;
	ImageView plateImage;
	ImageView inputImage;
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
	public void start(Stage stage) throws Exception {
		stage.setTitle("CTS");//title for the window i.e. eclipse-workspace
		
		if(Screen.getPrimary().getBounds().getMaxX() < 1000) {
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
		
		root = new Group();
		Scene scene = new Scene(root,Color.DARKGRAY);
		
		approvalShow = new Rectangle(xMid, windowHeight*0.65, xEnd-xMid, windowHeight/10);
		approvalShow.setFill(Color.DARKGRAY);
		root.getChildren().add(approvalShow);
		
		
		
		inputImage = new ImageView();
		inputImage.setLayoutX(xStart);
		inputImage.setLayoutY(windowHeight/10);
		inputImage.setFitHeight(windowHeight*0.75);
		inputImage.setFitWidth(windowWidth/2);
		root.getChildren().add(inputImage);
		
		scene.getStylesheets().add("stylesheet.css");
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JPG Files", "*.jpg")
				,new FileChooser.ExtensionFilter("PNG Files", "*.png")
				);
		
		selectImageVBox = new VBox();
		selectImage = new Button();
		selectImage.setText("Select Image Path");
		selectImage.setOnAction(e -> {
			selectedFile = fileChooser.showOpenDialog(null);
			
			Image image = new Image(selectedFile.toURI().toString());
			
			inputImage.setImage(image);
			
			inputImagePath = new Text();
			inputImagePath.setText(selectedFile.getPath());
			inputImagePath.setTextAlignment(TextAlignment.CENTER);
			inputImagePath.setFont(Font.font("Times New Roman", fontSizeSmall));
			selectImageVBox.getChildren().add(inputImagePath);
		});
		selectImageVBox.getChildren().add(selectImage);
		
		selectImageVBox.setAlignment(Pos.TOP_CENTER);
		selectImageVBox.setLayoutX(xStart);
		selectImageVBox.setLayoutY(windowHeight*0.85);
		selectImageVBox.setMinSize(windowWidth/2, windowHeight/10);
		root.getChildren().add(selectImageVBox);
		
		runStuff = new Button();
		//runStuff.setLayoutX(1900);
		//runStuff.setLayoutY(900);
		runStuff.setText("Run");
		runStuff.setOnAction(this);
		VBox runStuffVBox = new VBox(runStuff);
		runStuffVBox.setAlignment(Pos.TOP_CENTER);
		runStuffVBox.setLayoutX(xMid);
		runStuffVBox.setLayoutY(windowHeight*0.85);
		runStuffVBox.setMinSize(windowWidth/2, windowHeight/10);
		root.getChildren().add(runStuffVBox);
		
		plateImage = new ImageView();
		plateImage.setLayoutX(xMid);
		plateImage.setLayoutY(windowHeight/10);
		plateImage.setFitHeight(windowHeight*0.55);
		plateImage.setFitWidth(windowWidth/2);
		root.getChildren().add(plateImage);
		
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
		
		
		outText = new Text();
		outText.setTextAlignment(TextAlignment.CENTER);
		outText.setFont(Font.font("Times New Roman", fontSizeMedium));
		HBox outTextHBox = new HBox(outText);
		outTextHBox.setAlignment(Pos.CENTER);
		outTextHBox.setLayoutX(xMid);
		outTextHBox.setLayoutY(windowHeight*0.75);
		outTextHBox.setMinSize(windowWidth/2, windowHeight/10);
		root.getChildren().add(outTextHBox);
		
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
		
		Image icon = new Image("CTS_Logo.png");
		stage.getIcons().add(icon);//sets icon for application
		stage.setWidth(windowWidth);//width of window
		stage.setHeight(windowHeight);//height of window
		stage.setResizable(false);//allow resizing
		
		stage.setScene(scene);//sets the scene to the stage
		stage.show();//needs to be at end, displays the window on launch
	}
	public void handle(ActionEvent event){
		if(event.getSource()==runStuff) {
			if(selectedFile.getPath() != null) {
				MatlabEngine eng;
				try {
					eng = MatlabEngine.startMatlab();
					eng.eval("cd 'C:/Users/treyc/eclipse-workspace/Senior_Project_Java/src'" );
					String x = eng.feval("My_Func", selectedFile.getPath());
					lpImage = new Image(selectedFile.toURI().toString());
					if(x == null) {
						x = "Image Text Unreadable";
					} else {
						x = x.replaceAll("[\\n\\t ]", "");
					}
					outText.setFill(Color.BLACK);
					outText.setText(x);
					System.out.println(x);
					eng.close();
					
					plateImage.setImage(lpImage);
					
					String[] licensePlates = new String[3];
					licensePlates[0] = "B21GSB";
					licensePlates[1] = "SB90TZI";
					licensePlates[2] = "C99BNX";
					boolean approved = false;
					for(int i = 0; i < licensePlates.length; i++) {
						if(licensePlates[i].equals(x.toString())) {
							approved = true;
							approvedText.setText("APPROVED");
							approvedText.setFill(Color.WHITE);
							approvalShow.setFill(Color.LAWNGREEN);
						}
						System.out.println(licensePlates[i].equals(x.toString()) + ": " + i);
					}
					if(approved == false) {
						approvedText.setText("NOT APPROVED");
						approvalShow.setFill(Color.RED);
					}
				} catch (IllegalArgumentException | IllegalStateException | InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				
				approvalShow.setFill(Color.DARKORANGE);
				outText.setText("ERROR: No Image Selected");
				approvedText.setText("ERROR: No Image Selected");
				
			}
		}
		
	}

}
