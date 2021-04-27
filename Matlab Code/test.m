%loads listed file
my_data = load('Copy_of_mydata.mat');

%gets table from loaded file
trainingData = my_data.vehicleTrainingData;

%loops through each file
for x = 1:height(traingingData)
     %loops though each bounding box in other, not the data from the original bounding boxes was copied to the column for the new bounding boxes
     for y = 1:height(vehicleTrainingData.Other{x})
         %each of the below statements modify the bounding boxes
         if (vehicleTrainingData.Other{x}(y,1) + vehicleTrainingData.Other{x}(y,3)) < 1270 
             vehicleTrainingData.Other{x}(y,1) = vehicleTrainingData.Other{x}(y,1) + vehicleTrainingData.Other{x}(y,3) + 5;
         end
         if vehicleTrainingData.Other{x}(y,1) + vehicleTrainingData.Other{x}(y,3) > 1270 && vehicleTrainingData.Other{x}(y,1) - vehicleTrainingData.Other{x}(y,3) > 0
             vehicleTrainingData.Other{x}(y,1) = vehicleTrainingData.Other{x}(y,1) - vehicleTrainingData.Other{x}(y,3) - 5;
         end
         if (vehicleTrainingData.Other{x}(y,2) + vehicleTrainingData.Other{x}(y,4)) < 710 
             vehicleTrainingData.Other{x}(y,2) = vehicleTrainingData.Other{x}(y,2) + vehicleTrainingData.Other{x}(y,3) + 5;
         end
         if vehicleTrainingData.Other{x}(y,2) + vehicleTrainingData.Other{x}(y,4) > 710 && vehicleTrainingData.Other{x}(y,2) - vehicleTrainingData.Other{x}(y,4) > 0
             vehicleTrainingData.Other{x}(y,2) = vehicleTrainingData.Other{x}(y,2) - vehicleTrainingData.Other{x}(y,4) - 5;
         end
     end
     
     %dispalys each image with the bounding boxes for both the sets of bounding boxes drawn
%     I = imread(append('dataset/train/images/', vehicleTrainingData.imageFilename{x}));
%     figure,imshow(I)
%     hold on
%     for y = 1:height(vehicleTrainingData.licensePlate{x})
%         rectangle('Position', vehicleTrainingData.licensePlate{x}(y,:), 'EdgeColor','r','LineWidth',3)
%     end
%     for z = 1:height(vehicleTrainingData.Other{x})
%         rectangle('Position', vehicleTrainingData.Other{x}(z,:), 'EdgeColor','r','LineWidth',3)
%     end

    %corrects error that happens where some of the new bounding boxes are out of the range of the image size
%    for y = 1:height(vehicleTrainingData.Other{x})
%        if vehicleTrainingData.Other{x}(y,2) > 720
%            vehicleTrainingData.Other{x}(y,2) = 700 - vehicleTrainingData.Other{x}(y,4);
%        end
%    end
end
