# Final Project: COVID-19 Data Mining
### Drexel Univeristy, Dr. Weimao Ke
### INOF 634 Data Mining, Spring 2021

### Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Required Libraries](#Required-Libraries)
* [Setup & Data](#Set-up&Data)
* [Report](#report)
* [Contact](#contact)

### General Information
- The project aims at performing a time-series prediction of state-wise Covid-19 data for US and study the impact of vaccination against Covid-19. The project also aims at comparing the past Covid-19 cases with predicted cases in order to study and analyze the vaccination impact. As Covid-19 continues to be a pressing issue world wide and in the US, we decided to take a closer look at the patterns and trends occuring in our nation over a period of time. 

### Technologies Used
- Most up to date version of python and associated libraries
- Interactive computational enviorment capable of running a '.ipynb' file
	- We utilized google colab and jupyter notebook

### Required Libraries
- math 					- sklearn
- matplot.lib			- scipy
- pandas 				- folium
- seaborn				- statsmodels

### Setup & Data
- Specific improts from the library can be found at the top of the 'FP_INFO634_Final Report.ipynb' file and are needed to run the script. Further more, the data gathered and utilized for this project can be found at:
	- https://github.com/CSSEGISandData/COVID-19
	- From John hopkins University's Github repository on Covid-19 Tracking
	
- The main files used for the analysis was:
	- 'time_series_covid19_confirmed_US.csv'
	- https://github.com/CSSEGISandData/COVID-19/tree/master/time_series_covid19_confirmed_US.csv
	- 'csse_covid_19_data.csv'
	- https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data

- After everything is installed and set up, the user can run each cell individually or can select 'run all' from there interactive computational enviorment. 

### Report
- We trained and evaluated 3 models for our time series analysis. The RMSE of these 3 models are listed here for a brief comparison. A more in depth view of our findings can be found in our report in  the file 'Info_634_group_5_presentation.pptx'. The 3 models are:

	- Persistence Model:
		- RMSE: 42008.985
	- Auto-Regression Model:
		- RMSE: 3184272.787
	- ARIMA Model:
		- RMSE: 9775.103
		
- The powerpoint file also includes a run through of the preprocessing and cleaning we perfored on the data. Along with walk through of some exploratory analysis and the entire process from downloading the data to displaying visualizations of the models and more. 


### Contact
- Puneet Sihag - ps943@drexel.edu
- Yiyun Zhang - yz523@drexel.edu
- Evan Falkowski - ejf85@drexel.edu
