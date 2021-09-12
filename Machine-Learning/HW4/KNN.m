%
%  KNN.m
%  HW4
%
%  Created by Yiyun Zhang on 2/23/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

%Reads in the data
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

%Performs k-Nearest Neighbors classification with k = 5.
k = 5;
TP = 0;
TN = 0;
FP = 0;
FN = 0;
p = zeros(size(test,1));

%compute distance/similarity between xi and x for each xi in X
%let x* = argminxidi and y* be the label associated with training sample
%and assign label
for i = 1:size(test,1)
    t = test(i,:);
    s = zeros(size(train,1),1);
    for j = 1:size(train,1)
        test1 = t(1:end-1);
        train1 = train(j,1:end-1);
        for l = 1:length(test1)
            s(j) = s(j)+abs(test1(l)-train1(l));
        end
    end
    
    [~,lable] = sort(s);
    c = 0;
    for n = 1:k
        if train(lable(n),end) == 1
            c = c+1;
        end
    end
    if c*2 > k
        p(i) = 1;
    end
end

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