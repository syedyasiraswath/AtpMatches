# AtpMatches


Project Name: Demo
Author : Syedyasiraswath ASKAR BASHA
Email: aswathsyed@gmail.com
Phone: +91-9629819004

Pre-requisites:

The project uses ATP tennis tournament data present at:
https://github.com/JeffSackmann/tennis_atp

Specifically, take a look at files atp_matches_1968.csv, atp_matches_1970.csv etc., as the data source for this project.

1.	Keep the CSV files of  atp_matches_* in the desired the location.
Note : I have considered only the files of atp_matches_* and not atp_matches_doubles_* or atp_matches_futures_* etc..

2.	Replace the document path with the asp document location where the input csv files are present. 

asp.document.location=C:\\Assu\\docs\\

Expectations on server start-up:
1.	H2 console to be up and running in the brower:
http://localhost:8080/h2-console 

2.	Verify if the data are migrated from csv to the ATP_MATCHES using the below query
SELECT * FROM ATP_MATCHES

3.	Swagger to be up under the URL:
http://localhost:8080/swagger-ui.html#!/atp-matches-controller/ 

The Response can be tested using :
1.	Swagger 
2.	Any Rest Client.

Sample Responses:

1.	
Request Method: GET
Request URL : http://localhost:8080/secured/api/controller/country?year=1968 
 

2.	
Request Method: GET
Request URL : http://localhost:8080/secured/api/controller/winners?year=1968&surface=Grass 


3.	
Request Method: GET
Request URL : http://localhost:8080/secured/api/controller/winners/between/?from-year=1968&to-year=1970&surface=Grass 

 
