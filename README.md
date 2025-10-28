# generate-using-agent

A simple Flask API that provides an endpoint for generating random strings.

## Features

- **Home Endpoint** (`/`): Returns information about available endpoints
- **Random String Endpoint** (`/random-string`): Returns a randomly generated string

## Installation

1. Clone the repository:
```bash
git clone https://github.com/ATretinnikov/generate-using-agent.git
cd generate-using-agent
```

2. Install dependencies:
```bash
pip install -r requirements.txt
```

## Usage

### Running the Application

Start the Flask server:
```bash
python app.py
```

The server will run on `http://localhost:5000`

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

Run tests using pytest:
```bash
pytest test_app.py
```

## Development

The random string endpoint generates a 10-character string consisting of alphanumeric characters (uppercase letters, lowercase letters, and digits).