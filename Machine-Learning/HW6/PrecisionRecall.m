%
%  PrecisionRecall.m
%  HW6
%
%  Created by Yiyun Zhang on 3/16/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

% Reads in the data.
data = csvread('spambase.data');

%Randomizes the data.
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
test = [(test(:,1:end-1)-means)./standard,test(:,end)];

%Trains an artificial neural network using the training data
%Make sure to add a bias input node
y = train(:,end);
%Set the learning parameter ? = 0.5
lp = 0.5;
%D input nodes
D = size(train,2);
%M hidden nodes
%There should only be a single hidden layer.
%The hidden layer size should be 20,although this should be a variable parameter.
M = 20;
%K output nodes
K = length(unique(train(:,end)))-1;

%Initialize all weights to random values in the range [-1,1].
be = rand(D,M);
th = rand(M,K);

l = length(train);
train = train(:,1:end-1);
train = [train,ones(l,1)];
test1 = test(:,end);
test = test(:,1:end-1);
test = [test,ones(length(test),1)];
%Do 1000 training iterations
for i = 1:1000
    h = 1./(1+exp(-1.*train*be));
    o = 1./(1+exp(-1.*h*th));
    eo = y-o;
    th = th+(lp/l)*(h.'*eo);
    eh = eo*th.'.*(h.*(1-h));
    be = be+(lp/l).*(train.'*eh);
    test2 = 1./(1+exp(-1.*test*be));   
    test3 = 1./(1+exp(-1.*test2*th));
end

r = zeros(11,2);
t = -0.1;
%let?s vary that threshold t (which was previously 0.5) from 0.0 to 1.0 
%in increments of 0.1
for i = 1:11
    TN = 0;
    FN = 0;
    FP = 0;
    TP = 0;
    t = t+0.1;
    for j = 1:length(test3)
        row = test3(j,1);
        %each time computing the precision and recall by labeling observations 
        %as Positive if their likelihood is greater that the current t 
        %and Negative otherwise.
        if(row > t)
            if(test1(j,1) == 1)
                TP = TP+1;
            else
                FP = FP+1;
            end
        else 
            if(test1(j,1) == 0)
                TN = TN+1;
            else
                FN = FN+1;
            end
        end
    end
    precision = TP/(TP+FP);
    recall = TP/(TP+FN);
    if(isnan(precision))
        precision = 1;
    end
    r(i,1) = precision;
    r(i,2) = recall;
end

%graph these (precision, recall) pairs to form a Precision-Recall graph.
plot(r(:,1),r(:,2),'-co');
xlabel('Precision');
ylabel('Recall');
title("PR-Graph for ANN");