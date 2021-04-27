# SeniorProject
Getting Started:

Using eclipse IDE for java, go to file>import and under Git select import projects from Git. Next click clone URI and copy the URI from this repository and paste it under the locataion box in the URI box. Next clone form master under Branch Selection. Next select the directory you want the project in. Next select your import wizard, you can leave this as default. Finaly click Finish.

When the project is imported you will get some errors. First you will need to import JavaFX.

Download JavaFX: https://gluonhq.com/products/javafx/

Extract the javafx SDK to your programfiles directory, or whichever directory you prefer.

Once extracted, in eclipse go to Window>Preferences>Java>Build Path>User Libraries. Under User Libraries click new and enter JavaFX, the select JavaFX and click add External Jars. Navigate to where you extracted the javafx SDK, go into the SDK folder and go into the lib folder. Select all of the Jar Files in the lib folder and click open. Then click Apply and Close.

Next right click on the project folder and go to Build Path>Add Libraries>User Library and check JavaFX then click finish.

If you have issues with JavaFX check here(https://openjfx.io/openjfx-docs/) for solutions and/or a different instalation guide.

For the Matlab Engine you will follow the same process as javafx, except the .jar file will come with your Matlab installation. By default Matlab is installed in your Program Files folder, once you have located your Matlab folder go into the folder for most up to date version of matlab you have installed, the go to extern>engines>java>jar and use the engine.jar where you used the javafx SDK jar. and proceed through the rest of the instructions.

If you have issues with the Matlab engine installation you can contact us.


Java:

Main.java:

Contains all code for the final GUI and the interaction between java and matlab, note the My_Func.m in src is different from the My_Func.m in the Matlab Code folder.

Matlab:

Start:

Download CTS_ocr, dataset and Train_OCR folders from https://drive.google.com/drive/folders/146WyZ0UJ_BZ1pOitEVe5UW-FrMjuD0SE?usp=sharing and add these folders to the same folder you have the matlab scripst from the Matlab Code folder.

My_Func.m:

This file contains the training process for a SSD Object Detection Network. To run this file you will need to change the variable my_dataDir to the location you are running the file from, i.e. '{your path}/dataset/train/images'. Running this file is extreamly heavy, if your GPU vram is less than 4GB you will likely not be able to run this file. To lower vram usage you can set the mini batch size to 1 under the options variable. Be prepared as the network traing can take between half an hour to upwards of 3 hours or more. Upon running the file for the first time you will get an error asking you to install the network, you can click the link in the error or go to addons under the home tab and search for the network named under the network variable i.e. 'resnet50'.

test.m:

This file contains code used to modify the bounding boxes in the my_data variables loaded .mat file. You will not need to run this file, but if you want to know that the data will not save automatically you will need to open the table that is loaded in workspace and save that file manually.

Stuff.m: 

Used to test the training images bounding box with matlabs built in OCR, agian you will not need to run this file but if you wish you can. You can change the range of images by editing the two intigers in the x variable of the for loop(start:end)(matlab starts at 1 not zero). 

Copy_of_mydata.mat:

Contains bounding boxes for both the license plate and the new box called other created using test.m

mydata.mat:

Contains bounding boxes for just the license plates

ocrTrainingSession.mat:

Contains the trainging session data used to train our custom OCR for the data. To Run type ocrTrainer in matlabs command window and hit enter, then click open session and open this file.
