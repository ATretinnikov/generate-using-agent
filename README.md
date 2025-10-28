# generate-using-agent

A simple Spring Boot REST API that provides an endpoint for generating random strings.

## Features

- **Home Endpoint** (`/`): Returns information about available endpoints
- **Random String Endpoint** (`/random-string`): Returns a randomly generated string

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Installation

1. Clone the repository:
```bash
git clone https://github.com/ATretinnikov/generate-using-agent.git
cd generate-using-agent
```

2. Build the project:
```bash
mvn clean install
```

## Usage

### Running the Application

Start the Spring Boot server:
```bash
mvn spring-boot:run
```

The server will run on `http://localhost:5000`

Alternatively, run the JAR file:
```bash
java -jar target/random-string-api-1.0.0.jar
```

### API Endpoints

#### Home
```bash
curl http://localhost:5000/
```

Response:
```json
{
  "message": "Welcome to the Random String API",
  "endpoints": {
    "/random-string": "Returns a random string"
  }
}
```

#### Random String
```bash
curl http://localhost:5000/random-string
```

Response:
```json
{
  "random_string": "aB3dE5fG9h"
}
```

## Testing

Run tests using Maven:
```bash
mvn test
```

## Development

The random string endpoint generates a 10-character string consisting of alphanumeric characters (uppercase letters, lowercase letters, and digits).