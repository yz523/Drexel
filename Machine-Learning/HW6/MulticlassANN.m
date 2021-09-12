%
%  MulticlassANN.m
%  HW6
%
%  Created by Yiyun Zhang on 3/16/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

% Reads in the data.
data = csvread('CTG.csv',2);

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
l = length(train);
%Make sure to add a bias input node
y = train(:,end);
%Set the learning parameter ? = 0.5
lp = 0.5;
%D input nodes
D = size(train,2)-1;
%M hidden nodes
%There should only be a single hidden layer.
%The hidden layer size should be 20,although this should be a variable parameter.
M = 20;
%K output nodes
K = length(unique(train(:,end)));

%Initialize all weights to random values in the range [?1,1].
be = rand(D,M);
th = rand(M,K);

train = train(:,1:end-2);
train = [train,ones(l,1)];
test = test(:,1:end-2);
test = [test,ones(length(test),1)];
r = zeros(1000,1);
Y = y;
y = zeros(l, 3);
for i = 1:l
    y(i,:) = set(3,Y(i, 1));
end
tt = zeros(length(Y), 3);
for i = 1:length(Y)
    tt(i,:) = set(3,Y(i,1));
end

%Do 1000 training iterations
for i = 1:1000
    h = 1./(1+exp(-1.*train*be));
    o = 1./(1+exp(-1.*h*th));
    eo = y-o;
    th = th+(lp/l)*(h.'*eo);
    eh = eo*th.'.*(h.*(1-h));
    be = be+(lp/l).*(train.'*eh);
    %During the training process,
    %compute the training accuracy after each iteration
    lo = length(o);
    s = 0;
    for j = 1:lo
        r1 = o(j,:);
        r2 = y(j,:);
        %Consider a sample to be positive (Spam) if the output node has a value > 0.50 
        %and negative(Not Spam) otherwise.
        [~, a] = max(r1);
        [~, b] = max(r2);
        if(a == b)
            s = s+1;
        end
    end
    r(i,1) = s/lo;
end

plot(r,'-c');
xlabel('Iteration');
ylabel('Training Accuracy');
title("Trainning Accuracy for Multi-Class ANN");

%Classifies the testing data using the trained neural network
test2 = 1./(1+exp(-1.*test*be));   
test3 = 1./(1+exp(-1.*test2*th));

%Computes the testing accuracy.
lo = length(o);
s = 0;
for j = 1:lo
    r1 = o(j,:);
    r2 = y(j,:);
    %Consider a sample to be positive (Spam) if the output node has a value > 0.50 
    %and negative(Not Spam) otherwise.
    [~, a] = max(r1);
    [~, b] = max(r2);
    if(a == b)
        s = s+1;
    end
end
testres = s/lo;
a = ['Accuracy:',num2str(testres)];
disp(a);

function [m]= set(l,d)
    m = zeros(1, l);
    m(1, d) = 1;
end