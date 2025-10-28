"""
Simple Flask API with a random string endpoint.
"""
import random
import string
from flask import Flask, jsonify

app = Flask(__name__)


def generate_random_string(length=10):
    """Generate a random string of specified length."""
    characters = string.ascii_letters + string.digits
    return ''.join(random.choice(characters) for _ in range(length))


@app.route('/')
def home():
    """Home endpoint."""
    return jsonify({
        'message': 'Welcome to the Random String API',
        'endpoints': {
            '/random-string': 'Returns a random string'
        }
    })


@app.route('/random-string')
def random_string():
    """Endpoint that returns a random string."""
    return jsonify({
        'random_string': generate_random_string()
    })


if __name__ == '__main__':
    import os
    # Only enable debug mode in development (never in production)
    debug_mode = os.environ.get('FLASK_DEBUG', 'False').lower() == 'true'
    app.run(debug=debug_mode, host='0.0.0.0', port=5000)
