%loads data from file listed
my_data = load('Copy_of_mydata.mat');
%get table from file
trainingData = my_data.trainingData;

%loops through all image names in trainingdata
for x = 1:height(trainingData)
    %reads the image
    I = imread(append('dataset/train/images/', trainingData.imageFilename{x}));
    
    %uncomment to show the file name of the current file
    %trainingData.imageFilename{x}
    
    %uncomment bellow code to show each image
    %figure,imshow(I)
    
    %some images have more than one bounding box, loops thorugh each
    for y = 1:height(trainingData.licensePlate{x})
        %crops the image to the bounding box size
        cropped = imcrop(I, trainingData.licensePlate{x}(y,:));
        %generates file name
        imageFileName = sprintf('Train_OCR/croppedImage%d_%d.jpg', x, y);
        %writes new image
        imwrite(cropped, imageFileName);
        %runs cropped image through matlabs built in OCR
        text{x} = ocr(cropped);
        %uncomment to display each the predicion for each image
        %text{x}.Text
%         %display each image after it is cropped
%         figure, imshow(cropped)
    end
end
