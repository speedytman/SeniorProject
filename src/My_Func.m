function outputArg1 = My_Func(filePath)
    I = imread(filePath);
    Text = ocr(I, 'Language', '../Matlab Code/CTS_ocr/tessdata/CTS_ocr.traineddata');
    
    outputArg1 = Text.Text;
end
