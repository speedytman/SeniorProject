my_data = load('Copy_of_mydata.mat');

trainingData = my_data.trainingData;

for x = 278:281
    I = imread(append('dataset/train/images/', trainingData.imageFilename{x}));
    trainingData.imageFilename{x}
    figure,imshow(I)
    for y = 1:height(trainingData.licensePlate{x})
        cropped = imcrop(I, trainingData.licensePlate{x}(y,:));
        imageFileName = sprintf('Train_OCR/croppedImage%d.jpg',x);
        imwrite(cropped, imageFileName);
%         text{x} = ocr(cropped);
%         if height(text{x}.CharacterBoundingBoxes) == 0
%             lvl = graythresh(cropped);
%             BWOrig = im2bw(cropped, lvl);
%             text{x} = ocr(BWOrig);
%             text{x}.Text
%         end
%         figure, imshow(cropped)
    end
end