my_data = load('Copy_of_mydata.mat');

trainingData = my_data.trainingData;
my_dataDir = 'D:/Senior_Project_Matlab/dataset/train/images';
trainigData.imageFilename = fullfile(my_dataDir,trainingData.imageFilename);

imds = datastore('./dataset/train/images/*.jpg');
blds = boxLabelDatastore(trainingData(:,2:end));
% Code to reduce size of bounding boxes, needed to reduce size of training
% images and therefore reduce memory usage and training time allowing for
% increased accuracy
% while hasdata(blds)
%     [T, info] = read(blds);
%     x = info.CurrentIndex
%     Temp = T(1);
%     for h = height(Temp{1})
%         Temp{1}(1,h) = round(Temp{1}(1,h)/2);
%         T(1) = Temp(1);
%         vehicleTrainingData.licensePlate{x} = Temp{1};
%     end
% end


ds = combine(imds,blds);

inputImageSize = [720 1280 3];
numClasses = 2;
%need to install the Deep Learning Toolbox Model for ResNet-50 Network
network = 'resnet50';
featureLayer = 'activation_40_relu';
numAnchors = 25;
%can use either blds or ds
anchorBoxes = estimateAnchorBoxes(blds, numAnchors);


lgraph = ssdLayers(inputImageSize, numClasses, network);

% analyzeNetwork(lgraph)

options = trainingOptions('sgdm','InitialLearnRate',18.0e-4,'LearnRateSchedule','piecewise','LearnRateDropFactor',0.7,'LearnRateDropPeriod',1,'Verbose',true,'MiniBatchSize',2,'MaxEpochs',8,'Shuffle','every-epoch','VerboseFrequency',10);
detector = trainSSDObjectDetector(ds, lgraph, options);
Files = dir('dataset/train/images/*.jpg');
for x = 1:round(length(Files)/10)
    FileName = append('dataset/train/images/',Files(x).name);
    I = imread(FileName);
    [bboxes, scores, labels] = detect(detector, I)
end
