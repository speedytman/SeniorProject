%loads data from the file listed
my_data = load('Copy_of_mydata.mat');

%looks into file for trainingData table
trainingData = my_data.trainingData;
%directory training images are located in
my_dataDir = 'E:/Senior_Project_Matlab/dataset/train/images';%Change This to you directory, but keep /dataset/train/images unless you know that you are doing
%appends image file name to the directiory above
trainigData.imageFilename = fullfile(my_dataDir,trainingData.imageFilename);

%Creating the datastores for the images and bounding boxes
imds = datastore('./dataset/train/images/*.jpg');
blds = boxLabelDatastore(trainingData(:,2:end));

%combines the two datastores
ds = combine(imds,blds);

%size of the input layer
inputImageSize = [720 1280 3];
%number of bounding box lables, i.e. licensePlate and Other will be 2
numClasses = 2;
%need to install the Deep Learning Toolbox Model for ResNet-50 Network
network = 'resnet50';

%ceates a layer graph for the network
lgraph = ssdLayers(inputImageSize, numClasses, network);
%uncomment the code below to get a visualization of the network
% analyzeNetwork(lgraph)

%creat the training option, lower MiniBatchSize if you get the out of memory error, if you get out of memory and the minibatchsize is 1 you likely do not have enough gpu memory to train this network.
options = trainingOptions('sgdm','InitialLearnRate',18.0e-4,'LearnRateSchedule','piecewise','LearnRateDropFactor',0.7,'LearnRateDropPeriod',1,'Verbose',true,'MiniBatchSize',2,'MaxEpochs',8,'Shuffle','every-epoch','VerboseFrequency',10);
%trains the network
detector = trainSSDObjectDetector(ds, lgraph, options);
%tests the network, only testing a 10th remove the round function and /10 to test full set
Files = dir('dataset/train/images/*.jpg');
for x = 1:round(length(Files)/10)
    FileName = append('dataset/train/images/',Files(x).name);
    I = imread(FileName);
    [bboxes, scores, labels] = detect(detector, I)
end
