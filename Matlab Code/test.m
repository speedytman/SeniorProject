my_data = load('Copy_of_mydata.mat');

trainingData = my_data.vehicleTrainingData;
my_dataDir = 'D:/Senior_Project_Matlab/dataset/train/images';
trainigData.imageFilename = fullfile(my_dataDir,trainingData.imageFilename);

imds = datastore('./dataset/train/images/*.jpg');
blds = boxLabelDatastore(trainingData(:,2:end));

for x = 1:427
%     for y = 1:height(vehicleTrainingData.Other{x})
%         if (vehicleTrainingData.Other{x}(y,1) + vehicleTrainingData.Other{x}(y,3)) < 1270 
%             vehicleTrainingData.Other{x}(y,1) = vehicleTrainingData.Other{x}(y,1) + vehicleTrainingData.Other{x}(y,3) + 5;
%         end
%         if vehicleTrainingData.Other{x}(y,1) + vehicleTrainingData.Other{x}(y,3) > 1270 && vehicleTrainingData.Other{x}(y,1) - vehicleTrainingData.Other{x}(y,3) > 0
%             vehicleTrainingData.Other{x}(y,1) = vehicleTrainingData.Other{x}(y,1) - vehicleTrainingData.Other{x}(y,3) - 5;
%         end
%         if (vehicleTrainingData.Other{x}(y,2) + vehicleTrainingData.Other{x}(y,4)) < 710 
%             vehicleTrainingData.Other{x}(y,2) = vehicleTrainingData.Other{x}(y,2) + vehicleTrainingData.Other{x}(y,3) + 5;
%         end
%         if vehicleTrainingData.Other{x}(y,2) + vehicleTrainingData.Other{x}(y,4) > 710 && vehicleTrainingData.Other{x}(y,2) - vehicleTrainingData.Other{x}(y,4) > 0
%             vehicleTrainingData.Other{x}(y,2) = vehicleTrainingData.Other{x}(y,2) - vehicleTrainingData.Other{x}(y,4) - 5;
%         end
%     end
%     I = imread(append('dataset/train/images/', vehicleTrainingData.imageFilename{x}));
%     figure,imshow(I)
%     hold on
%     for y = 1:height(vehicleTrainingData.licensePlate{x})
%         rectangle('Position', vehicleTrainingData.licensePlate{x}(y,:), 'EdgeColor','r','LineWidth',3)
%     end
%     for z = 1:height(vehicleTrainingData.Other{x})
%         rectangle('Position', vehicleTrainingData.Other{x}(z,:), 'EdgeColor','r','LineWidth',3)
%     end
    for y = 1:height(vehicleTrainingData.Other{x})
        if vehicleTrainingData.Other{x}(y,2) > 720
            vehicleTrainingData.Other{x}(y,2) = 700 - vehicleTrainingData.Other{x}(y,4);
        end
    end
end