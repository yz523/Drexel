%
%  Eigenfaces.m
%  HW1
%
%  Created by Yiyun Zhang on 1/26/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

%Read in the list of files
listing = dir('yalefaces/subject*.*');
data = [];
for k=1:length(listing)
    filename = listing(k).name;
    %Read in the image as a 2D array (234x320 pixels)
    file = imread(fullfile('yalefaces',filename));
    %Subsample the image to become a 40x40 pixel image (for processing speed)
    subsample = imresize(file,[40,40]);
    %Flatten the image to a 1D array (1x1600)
    flatten = reshape(subsample, [1,1600]);
    %Concatenate this as a row of your data matrix
    data = vertcat(data,flatten);
end

%Standardizes the data.
%Calculate mean and standard deviation.
m = zeros(1,1600);
s = zeros(1,1600);
for i = 1:1600
    m(i) = mean(double(data(:,i)));
    s(i) = std(double(data(:,i)));
end
mean = repmat(m, size(data,1),1);
stdv = repmat(s, size(data,1),1);

original = double(data);
standard = double(data);
standard = standard - double(mean);
standard = standard ./ stdv;

%Performs PCA on the data
%Calculate covariance of the matrixs
originalc = cov(original);
standardc = cov(standard);

%Calculate eigenvalues
originale = eig(originalc);
standarde = eig(standardc);

%Create set of eigenvectors and eigenvalues
[originaleigenvectors,originaleigenvalues] = eig(originalc);
[eigenvectors,eigenvalues] = eig(standardc);

%Calulate eigenvalue's sums for deciding k
originals = sum(originale);
standards = sum(standarde);

%Determines the number of principle components necessary to encode at least 95
% of the information, k
d = 1;
k = 1;
for i = 1600:-1:1
   d = d + standarde(i);
   k = k + 1;
   if(d / standards >= 0.95)
       break;
   end
end

%Output the result of K
disp(strcat("The number of principle components necessary to encode at least 95% of the information k is ", int2str(k)));

%Reconstructs the first person using the primary principle component
primary= original * originaleigenvectors(:,1600);
primary = primary * (originaleigenvectors(:,1600).');

%and then the K eigenvectors
K = 1600 - k;
keigenvector = original * originaleigenvectors(:,K:1600);
keigenvector = keigenvector * (originaleigenvectors(:,K:1600).');

%Figure 2
%Visualizes the most important principle component as a 40x40 image
figure,imshow(reshape(originaleigenvectors(:,1600),[40,40]),[min(originaleigenvectors(:,1600)),max(originaleigenvectors(:,1600))]);
title('Primary Principle Component');

%Figure 3
%Visualizes reconstructed first person using the primary principle component and then the k eigenvectors
figure,subplot(1,3,1),imshow(reshape(original(1,:),[40,40]),[min(original(1,:)),max(original(1,:))]);
title('Original');

subplot(1,3,2),imshow(reshape(primary(1,:),[40,40]),[min(primary(1,:)),max(primary(1,:))]);
title('Single PC Reconstruction');

subplot(1,3,3),imshow(reshape(keigenvector(1,:),[40,40]),[min(keigenvector(1,:)),max(keigenvector(1,:))]);
title(strcat('K PC Reconstruction'));
