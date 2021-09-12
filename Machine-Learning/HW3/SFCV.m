%
%  SFCV.m
%  HW3
%
%  Created by Yiyun Zhang on 2/9/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

%Reads in the data, ignoring the first row (header) and first column (index).
data = csvread('x06Simple.csv',1);
data = data(:,2:end);

%Randomizes the data
r = RandStream('mt19937ar','Seed',0);
data = data(randperm(r,size(data,1)),:);

%Creates S folds (for our purposes S = 5)
fprintf("S=3");
calc(data,3);
fprintf("S=5");
calc(data,5);
fprintf("S=20");
calc(data,20);
fprintf("S=40");
calc(data,40);

%For i = 1 to S
function [] =  calc(data,S)
    se = [];
    l = ceil(length(data) / S);
    for i = 1 : S
      %Select fold i as your testing data and the remaining (S ? 1) folds as your training data
      start = i*l-l+1;
      ends = i*l;
      if (ends > length(data))
      ends = length(data)-1;
      end
      if (start > length(data))
      start = length(data);
      end
      test = data(start:ends,:);
      train = [data(1:start,:); data(ends+1:end,:)];
    
      %Standardizes the data (except for the last column of course) based on the training data
      means = mean(train(:,1:end-1));
      standard = std(train(:,1:end-1));
      train = [(train(:,1:end-1)-means)./standard,train(:,end)];
      test = [(test(:,1:end-1)-means)./standard,test(:,end)];
    
      %Train a closed-form linear regression model
      X = train(:,1:end-1);
      Y = train(:,end);
      one = ones(size(train,1),1);
      X = [one X];
      XT = X';
      %Theta = (X^(T)*X)'X^(T)Y
      t = (XT*X)\XT*Y;
    
      %Compute the squared error for each sample in the current testing fold
      tf = [ones(size(test,1),1) test(:,1:end-1)];
      res = tf * t;
      se = [se; (res-test(:, end)).^2];
    end
    RMSE = sqrt(mean(se));
    disp(RMSE);
end
