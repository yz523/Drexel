%
%  PCA.m
%  HW1
%
%  Created by Yiyun Zhang on 1/26/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

% Reads in the data
data = csvread('diabetes.csv');

% Standardizes the data (except for the first column of course)
dat = data(:, 1);
data(:, 1) = [];

%Calculate mean and standard deviation.
mean = mean(data);
stdc = std(data);
standard = data - mean;
standard = standard ./ stdc;

%Reduces data (except for the first column of course) to 2D using PCA
%Calculate covariance of the matrix
standardc = cov(standard);

%Calculate and create set of eigenvectors and eigenvalues 
[eigenvectors, eigenvalues] = eig(standardc);

%Project the points onto the single best vector
[~,sorted] = sort(diag(eigenvalues),'descend');
projection = zeros(size(standard, 1), 2);

%Combine eigen-vectors with the projection
for i = 1:2
    projection(:,i) = standard * eigenvectors(:,sorted(i));
end

%Graphs the data for visualization
figure;
plot(projection(dat == 1,1),projection(dat == 1,2),'ro',projection(dat == -1,1), projection(dat == -1,2),'bx');
title('PCA');
