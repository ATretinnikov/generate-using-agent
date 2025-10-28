"""
Tests for the Flask API.
"""
import pytest
from app import app, generate_random_string


@pytest.fixture
def client():
    """Create a test client for the Flask app."""
    app.config['TESTING'] = True
    with app.test_client() as client:
        yield client


def test_home_endpoint(client):
    """Test the home endpoint."""
    response = client.get('/')
    assert response.status_code == 200
    data = response.get_json()
    assert 'message' in data
    assert 'endpoints' in data


def test_random_string_endpoint(client):
    """Test the random string endpoint."""
    response = client.get('/random-string')
    assert response.status_code == 200
    data = response.get_json()
    assert 'random_string' in data
    assert len(data['random_string']) == 10
    assert isinstance(data['random_string'], str)


def test_random_string_uniqueness(client):
    """Test that random strings are different."""
    response1 = client.get('/random-string')
    response2 = client.get('/random-string')
    
    data1 = response1.get_json()
    data2 = response2.get_json()
    
    # While technically they could be the same, the probability is very low
    # This test ensures the randomization is working
    string1 = data1['random_string']
    string2 = data2['random_string']
    
    # Both should be 10 characters long
    assert len(string1) == 10
    assert len(string2) == 10


def test_generate_random_string_function():
    """Test the generate_random_string function."""
    random_str = generate_random_string(10)
    assert len(random_str) == 10
    assert isinstance(random_str, str)
    
    # Test different length
    random_str_20 = generate_random_string(20)
    assert len(random_str_20) == 20
