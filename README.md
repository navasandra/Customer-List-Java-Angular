# Customer-List-Java-Angular
Project consisting of java back-end and angular front end with two Rest API services (get &amp; post) without connection to database and data being stored in memory.

# Running the API part
The backend part of the project should be started first. 
In order start the project, download it as zip file and extract both folders. 
Open your IDE and open _final-test-api_ project. Start the application.
The API should be running on http://localhost:8080/;
To check whether the API works navigate to http://localhost:8080/api/rest/customers/get-customers and a list of 100 'test customers' should be visible.

# Running the front end part
As you now have the angular part of the project downloaded and exctracted as well and the API is running, you can open the _final-test-web_ folder in your visual studio code.
Once the project is opened, install node packages with _npm install_ command in your terminal;
Please note that the angular part uses primeng modules that are available at npm but might need to be installed. Run the below commands in your terminal.
npm install primeng --save
npm install primeicons --save

The project has a built-in proxy that has to be used when starting the project.
Run this command in the terminal 'ng serve --proxy-config proxy.conf.json'.

The project should now be running and the functionalities (viewing customer details by pressing on a specific row, adding a new customer) can be viewed.
