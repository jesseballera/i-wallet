# i-wallet

### Tech Stack
* Spring Boot 3.4.4
* H2 Database
* Java 21


### Api Documentation

* add new customer/account: [/api/v1/customers/add-customer](http://127.0.0.1:8500/i-wallet/swagger-ui/index.html#/customer-controller/addCustomer)
* transfer funds between accounts: [/api/v1/accounts/transfer](http://127.0.0.1:8500/i-wallet/swagger-ui/index.html#/account-controller/transferFunds)
* retrieve account transactions: [/api/v1/accounts/transaction/{accountNumber}](http://127.0.0.1:8500/i-wallet/swagger-ui/index.html#/account-controller/viewAllTransaction)
* check account balance: [/api/v1/accounts/balance/{accountNumber}](http://127.0.0.1:8500/i-wallet/swagger-ui/index.html#/account-controller/getBalance)
* deposit funds: [/api/v1/accounts/deposit/{accountNumber}](http://127.0.0.1:8500/i-wallet/swagger-ui/index.html#/account-controller/depositAccount)
* view all customers/accounts: [/api/v1/customers](http://localhost:8500/i-wallet/swagger-ui/index.html#/customer-controller/viewAllCustomers)
* view customer information: [/api/v1/customers/view-customer/{id}](http://127.0.0.1:8500/i-wallet/swagger-ui/index.html#/customer-controller/viewCustomerInfo)


### Guides
* Access the API documentation at [http://localhost:8500/i-wallet/swagger-ui.html](http://localhost:8500/i-wallet/swagger-ui.html)
* To access H2 console at [http://localhost:8500/h2-console/](http://localhost:8500/h2-console/)
* Credentials: 
   - username: sa
   - password: sa
   - jdbc url: jdbc:h2:./db/i-wallet

### Sample Data

* Customer/Account: 1
    - customer name: John Doe 
    - address: 123 Main St, Anytown, USA
    - phone number: 123-456-7890
    - account number: 1234567890
    - balance: $990000.00
* Customer/Account: 2
    - customer name: Jane Doe 
    - address: 456 Main St, Anytown, USA
    - phone number: 987-654-3210
    - account number: 9876543210
    - balance: $5010000.00
