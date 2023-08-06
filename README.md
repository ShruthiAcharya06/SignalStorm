# Merchant Solution
This project implements a signal handling API that allows you to handle different signals for trading algorithms.
## Getting Started
To get started with this project, follow the instructions below.
### Prerequisites
- Java JDK 8 or higher
- Maven
### Installation
1. Clone the repository:

   ```sh
   git clone https://github.com/ShruthiAcharya06/merchant-solution.git
   Build using : mvn clean install
### Running the Application
mvn spring-boot:run

### Using the API
curl -X POST -d "signal=1" http://localhost:8080/signal/handle
    -- Change the signal code as per your requirement. Currently there are definitions for 3 signals . There is also a fallbackSignal Handler.
  Success Response (HTTP 200 OK):
  Error Response (HTTP 500 Internal Server Error):

### Expanding the API
 -- Introduce new signal handler by following naming convention SignalHandler(signal) signal is integer number.
