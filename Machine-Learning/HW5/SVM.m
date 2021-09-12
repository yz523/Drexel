%
%  SVM.m
%  HW5
%
%  Created by Yiyun Zhang on 3/2/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

%Reads in the data from the Spambase set provided on Blackboard. 
%Read about how we?ll use this dataset in the Datasets section.
data = csvread('spambase.data');

%Randomizes the data
r = RandStream('mt19937ar','Seed',0);
data = data(randperm(r,size(data,1)),:);

%Selects the first 2/3 (round up) of the data for training and the remaining for testing
sel = ceil(size(data,1)*(2/3));
train = data(1:sel,:);
test = data(sel+1:end,:);

% Standardizes the data (except for the last column of course) using the training data
means = mean(train(:,1:end-1));
standard = std(train(:,1:end-1));
train = [(train(:,1:end-1)-means)./standard,train(:,end)];
test = [(test(:,1:end-1)-means)./standard,test(:,end)];

%Train a SVM on this training data using an SVM library of your choice.
%fitcsvm trains or cross-validates a support vector machine (SVM) model 
%for two-class (binary) classification on 
%a low-through moderate-dimensional predictor data set. 
m = fitcsvm(train(:, 1:end-1), train(:, end));

%Classify/test your SVM using the testing set.
%Predict responses using regression tree
p = predict(m, test(:, 1:end-1));
TN = 0;
FN = 0;
FP = 0;
TP = 0;

%count TN,FN,FP and TP
for i = 1:length(p)
    if p(i) == 0
        if test(i,end) == 0
            TN = TN+1;
        end
        if test(i,end) == 1
            FN = FN+1;
        end
    end
    if p(i) == 1
        if test(i,end) == 0
            FP = FP+1;
        end
        if test(i,end) == 1
            TP = TP+1;
        end
    end
end

%Computes the following statistics using the testing data:
%(a) Precision = TP/(TP+FP)
Precision = TP/(TP+FP);
a = ['Precision ', num2str(Precision)];
disp(a);
%(b) Recall = TP/(TP+FN)
Recall = TP/(TP+FN);
b = ['Recall ', num2str(Recall)];
disp(b);
%(c) F-measure = (2*precision*recall)/(precision+recall)
Fmeasure = 2*Precision*Recall/(Precision+Recall);
c = ['F-measure ', num2str(Fmeasure)];
disp(c);
%(d) Accuracy = (TP+TN)/(TP+TN+FP+FN)
Accuracy = (TP+TN)/(TP+TN+FP+FN);
d = ['Accuracy ', num2str(Accuracy)];
disp(d);