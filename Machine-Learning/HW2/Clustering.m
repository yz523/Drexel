%
%  Clustering.m
%  HW2
%
%  Created by Yiyun Zhang on 2/2/18.
%  Copyright © 2018 Yiyun Zhang. All rights reserved.
%

clear;

%Reads in the data
data = csvread('diabetes.csv');
data2 = data;

%Standardizes the data
data(:,1) = [];
mean = mean(data);
std = std(data);
standard = data - mean;
standard = standard ./ std;
%main
main6 = kmeans(standard,5,1,2,14);
main5 = kmeans(standard,5,6,7,14);
main4 = kmeans(standard,2,6,7,8);
%Performs k-means clustering using just the 6th and 7th feature of the data 
%(BMI and Pedigree,respectively) with k=2 and using the Euclidean (L2) distance.
%To see when terminate
main2 = kmeans(standard(:,7:-1:6),2,1,2,100);
main3 = kmeans(standard(:,7:-1:6),2,1,2,33);
main1 = kmeans(standard(:,7:-1:6),2,1,2,1);
main = kmeans(standard(:,7:-1:6),2,1,2,0);

%purity
g1p = 0;
g1n = 0;
g2p = 0;
g2n = 0;
for i = 1:length(data2)
    if((main2(i,3))) == 1
        if data2(i,1) == 1
            g1p = g1p + 1;
        else
            g1n = g1n + 1;
        end
    elseif((main2(i,3))) == 2
        if data2(i,1) == 1
            g2p = g2p + 1;
        else
            g2n = g2n + 1;
        end
    end
end
if g1p > g1n
    g1 = g1p;
else
    g1 = g1n;
end
if g2p > g2n
    g2 = g2p;
else
    g2 = g2n;
end
purity = 1 ./ length(data2)*(g1+g2);
disp(purity);

%kmeans function,passed another variable to the function to easier plot
%the graph of specific iteration during the loop.
%Write your code in such a way that it could work for any value of positive integer k, and any
%number of features, D.
function [data] = kmeans(data,k,xcol,ycol,lp)
    %Seed your random number generator with zero
    rs = RandStream('mt19937ar','Seed',0);
    %Randomly select two data instances and use them for the initial seeds
    data = data(randperm(rs,size(data,1)),:);
    v = data(1:k,:);
    if lp == 0
        figure,
        %Data points are red ?x?
        plot(data(:,xcol),data(:,ycol),'rx');
        hold on;
        %Cluster centers are blue dots,whose size is large enough to distinguish
        plot(v(:,xcol),v(:,ycol),strcat('b','o'),'MarkerSize',15,'MarkerEdge','k','MarkerFaceColor','b');
        hold on;
        title("Initial Seeds");
    end
        data = [data,zeros(size(data,1),1)];
    for i = 1:lp
        for j = 1:size(data,1)
            da = data(j,1:end-1);
            dis = zeros(1,size(v,1));
            for k = 1:size(v,1)
                %Use the L2 distance to measure the distance between observations and reference vectors
                val = v(k,:);
                dis(k) = pdist2(val,da,'euclidean');
            end
            [~,I] = min(dis);
            data(j,end) = I;
        end
        v2 = v;
        last = size(data,2);
        for k = 1:size(v,1)
            dat = (data(data(:,last)==k,1:end-1));
            v(k,:) = mean(dat);
        end
        %Use L1 distance
        m = pdist2(v,v2,'cityblock');
        %Terminate the EM process when the sum of magnitude of change of the cluster centers is less than  = 2?23
        if m(1) < 2^-23
            break
        end
    end
    %plot the graph
    if lp > 0
        plots(data,v,k,xcol,ycol,i);
    end
end

function [] = plots(data,means,k,xcol,ycol,ii)
    color= ['r';'b';'c';'y';'g';'m';'b'];
    figure,
    for i = 1:k
        x = data(data(:,end)==i,xcol);
        y = data(data(:,end)==i,ycol);
        %Data points are as ?x? according their assigned color
        plot(x,y,strcat(color(i),'x'));
        hold on;
        %Cluster 1 = red
        %Cluster 2 = blue
        %...
        plot(means(i,xcol),means(i,ycol),strcat(color(i),'o'),'MarkerSize',15,'MarkerEdge','k','MarkerFaceColor',color(i));
        hold on;
    end
    title(strcat("kmeans(",num2str(k),",",num2str(xcol),",",num2str(ycol),")"," /Iteration ",num2str(ii)));
end