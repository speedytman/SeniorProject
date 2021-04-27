import com.mathworks.engine.*;

import java.io.File;
import java.util.concurrent.ExecutionException;

import java.sql.*;

import javafx.application.*;
import javafx.stage.FileChooser;
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
	File selectedFile;
	Image lpImage;
	VBox selectImageVBox;
	
	public static void main(String[] args) throws Exception{
        launch(args);
	}
	public void start(Stage stage) throws Exception {
		stage.setTitle("CTS");//title for the window i.e. eclipse-workspace
		
		root = new Group();
		Scene scene = new Scene(root,Color.DARKGRAY);
		
		approvalShow = new Rectangle(1002, 649, 1000, 98);
		approvalShow.setFill(Color.DARKGRAY);
		root.getChildren().add(approvalShow);
		
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
			
			ImageView imageView = new ImageView(image);
			imageView.setLayoutX(0);
			imageView.setLayoutY(100);
			imageView.setFitHeight(750);
			imageView.setFitWidth(1000);
			root.getChildren().add(imageView);
			
			inputImagePath = new Text();
			inputImagePath.setText(selectedFile.getPath());
			inputImagePath.setTextAlignment(TextAlignment.CENTER);
			inputImagePath.setFont(Font.font("Times New Roman", 20));
			selectImageVBox.getChildren().add(inputImagePath);
		});
		selectImageVBox.getChildren().add(selectImage);
		
		selectImageVBox.setAlignment(Pos.TOP_CENTER);
		selectImageVBox.setLayoutX(0);
		selectImageVBox.setLayoutY(855);
		selectImageVBox.setMinSize(1000, 100);
		root.getChildren().add(selectImageVBox);
		
		runStuff = new Button();
		runStuff.setLayoutX(1900);
		runStuff.setLayoutY(900);
		runStuff.setText("Run");
		runStuff.setOnAction(this);
		VBox runStuffVBox = new VBox(runStuff);
		runStuffVBox.setAlignment(Pos.TOP_CENTER);
		runStuffVBox.setLayoutX(1001);
		runStuffVBox.setLayoutY(855);
		runStuffVBox.setMinSize(1000, 100);
		root.getChildren().add(runStuffVBox);
		
		plateImage = new ImageView();
		plateImage.setLayoutX(1000);
		plateImage.setLayoutY(100);
		plateImage.setFitHeight(550);
		plateImage.setFitWidth(1000);
		root.getChildren().add(plateImage);
		
		Text CTS = new Text();
		CTS.setText("Car Tag Scanner");
		CTS.setTextAlignment(TextAlignment.CENTER);
		CTS.setFont(Font.font("Times New Roman", 100));
		HBox CTSHBox = new HBox(CTS);
		CTSHBox.setAlignment(Pos.TOP_CENTER);
		CTSHBox.setLayoutX(0);
		CTSHBox.setLayoutY(-15);
		CTSHBox.setMinSize(2000, 150);
		root.getChildren().add(CTSHBox);
		
		
		outText = new Text();
		outText.setTextAlignment(TextAlignment.CENTER);
		outText.setFont(Font.font("Times New Roman", 80));
		HBox outTextHBox = new HBox(outText);
		outTextHBox.setAlignment(Pos.CENTER);
		outTextHBox.setLayoutX(1000);
		outTextHBox.setLayoutY(750);
		outTextHBox.setMinSize(1000, 90);
		root.getChildren().add(outTextHBox);
		
		approvedText = new Text();
		approvedText.setTextAlignment(TextAlignment.CENTER);
		approvedText.setFont(Font.font("Times New Roman", 80));
		approvedText.setFill(Color.WHITE);
		HBox approvedTextHBox = new HBox(approvedText);
		approvedTextHBox.setAlignment(Pos.CENTER);
		approvedTextHBox.setLayoutX(1000);
		approvedTextHBox.setLayoutY(650);
		approvedTextHBox.setMinSize(1000, 100);
		root.getChildren().add(approvedTextHBox);
		
		
		Line line1 = new Line();
		line1.setStartX(0);
		line1.setStartY(850);
		line1.setEndX(2000);
		line1.setEndY(850);
		line1.setStrokeWidth(5);
		root.getChildren().add(line1);
		
		Line line2 = new Line();
		line2.setStartX(1000);
		line2.setStartY(100);
		line2.setEndX(1000);
		line2.setEndY(850);
		line2.setStrokeWidth(5);
		root.getChildren().add(line2);
		
		Line line3 = new Line();
		line3.setStartX(0);
		line3.setStartY(100);
		line3.setEndX(2000);
		line3.setEndY(100);
		line3.setStrokeWidth(5);
		root.getChildren().add(line3);
		
		Line line4 = new Line();
		line4.setStartX(1001);
		line4.setStartY(750);
		line4.setEndX(2000);
		line4.setEndY(750);
		line4.setStrokeWidth(5);
		root.getChildren().add(line4);
		
		Line line5 = new Line();
		line5.setStartX(1001);
		line5.setStartY(650);
		line5.setEndX(2000);
		line5.setEndY(650);
		line5.setStrokeWidth(5);
		root.getChildren().add(line5);
		
		
		
		Image icon = new Image("CTS_Logo.png");
		stage.getIcons().add(icon);//sets icon for application
		stage.setWidth(2000);//width of window
		stage.setHeight(1000);//height of window
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
