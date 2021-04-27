function outputArg1 = My_Func(filePath)
    I = imread(filePath);
    Text = ocr(I, 'Language', 'E:\Senior_Project_Matlab\CTS_ocr\tessdata\CTS_ocr.traineddata');
    
    outputArg1 = Text;
end

