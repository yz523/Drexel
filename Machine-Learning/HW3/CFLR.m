%
%  CFLR.m
%  HW3
%
%  Created by Yiyun Zhang on 2/9/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

%Reads in the data, ignoring the first row (header) and first column (index)
data = csvread('x06Simple.csv',1);
data = data(:,2:end);

%Randomizes the data
r = RandStream('mt19937ar','Seed',0);
data = data(randperm(r,size(data,1)),:);

%Selects the first 2/3 (round up) of the data for training and the remaining for testing
sel = ceil(size(data,1)*(2/3));
train = data(1:sel,:);
test = data(sel+1:end,:);

%Standardizes the data (except for the last column of course) using the training data
means = mean(train(:,1:end-1));
standard = std(train(:,1:end-1));
train = [(train(:,1:end-1)-means)./standard,train(:,end)];
test = [(test(:,1:end-1)-means)./standard, test(:,end)];

%Computes the closed-form solution of linear regression
X = train(:,1:end-1);
Y = train(:,end);
one = ones(size(train,1),1);
X = [one X];
XT = X';
%Theta = (X^(T)*X)'X^(T)Y
t = (XT*X)\XT*Y;
display(t);

%Applies the solution to the testing samples
ts = [ones(size(test,1),1) test(:,1:end-1)];
sol = ts * t;

%Computes the root mean squared error (RMSE)
mse = mean((sol-test(:,end)).^2);
RMSE = sqrt(mse);
disp(RMSE);