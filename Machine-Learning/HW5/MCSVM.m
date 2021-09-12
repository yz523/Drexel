%
%  MCSVM.m
%  HW5
%
%  Created by Yiyun Zhang on 3/2/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

%Reads in the data from the Cardiotocography set provided on Blackboard. 
%Read about how we?ll use this dataset in the Datasets section
data = csvread('CTG.csv',2);

%Randomizes the data
res = RandStream('mt19937ar','Seed',0);
data = data(randperm(res,size(data,1)),:);
data(:, end-1) = [];

%Selects the first 2/3 (round up) of the data for training and the remaining for testing
sel = ceil(size(data,1)*(2/3));
train = data(1:sel,:);
test = data(sel+1:end,:);

% Standardizes the data (except for the last column of course) using the training data
means = mean(train(:,1:end-1));
standard = std(train(:,1:end-1));
train = [(train(:,1:end-1)-means)./standard,train(:,end)];
test = [(test(:,1:end-1)-means)./standard,test(:,end)];

%Trains and evaluates using a One vs One approach:
% Train K(K?1)/2 one-vs-one binary classifiers 
%where you only use the training samples from the relevant classes. 
%That is, if you are training a classifier that labels observations as
%either class i or class j then only use observations with labels i and j 
%(discard the rest).
sizes = max(train(:, end));
classifiers = cell(sizes, 1);
m = cell(sizes,1);
k = 0;

for i = 1:sizes
    classifiers{i} = train(train(:,end)==i,:);
end

%Use default SVM settings
for i = 1:length(classifiers) - 1
    for j = i+1:length(classifiers)
        data = [classifiers{i};classifiers{j}];
        k = k+1;
        m{k} = fitcsvm(data(:,1:end-1),data(:,end));
    end
end

l = zeros(size(test,1),length(m));
for i = 1 : length(m)
    l(:, i) = predict(m{i}, test(:, 1:end-1));
end

%For each test sample, run it through each of the K(K?1)/2 classifiers
%to see which class(es) ?beat? the others the most. 
%Choose that class as the your observation?s label. 
%Again if there is a tie among several classes
%choose at random the predicted label from those classes.
res = mode(l, 2);
c = 0;
for i = 1 : length(res)
    if (res(i) == test(i, end))
        c = c + 1;
    end
end
Accuracy = c / length(res);
a = ['Accuracy ', num2str(Accuracy)];
disp(a);   

%Take your work from Part 3 and create a confusion matrix from it.
martix = zeros(sizes,sizes);
t = [l,test(:, end)];
r = zeros(length(t), 2);

for i=1:length(t)
    rs = t(i,:);
    l = mode(rs(:, 1:end-1));
    r(i,:) = [l, rs(:,end)];
end

for i=1:length(r)
    rs = r(i,:);
    l = rs(:,1);
    res = rs(:, 2);
    m = martix(l, res);
    martix(l, res) = m + 1;
end

%output
s = length(r);

b = ['                    Class 1','   Class 2','   Class 3'];
disp(b);
c = ['Predicted Class 1','   ',num2str(martix(1,1)/s),'    ',num2str(martix(1,2)/s),'  ',num2str(martix(1,3)/s)];
disp(c);
d = ['Predicted Class 2','   ',num2str(martix(2,1)/s),'  ',num2str(martix(2,2)/s),'  ',num2str(martix(2,3)/s)];
disp(d);
f = ['Predicted Class 3','   ',num2str(martix(3,1)/s),' ',num2str(martix(3,2)/s),' ',num2str(martix(3,3)/s)];
disp(f);