from flask import Flask, jsonify
import docker

app = Flask(__name__)

@app.route('/containers')
def get_containers():
    client = docker.from_env()
    containers = client.containers.list()
    return jsonify([container.name for container in containers])

if __name__ == '__main__':
    app.run(debug=True, host="0.0.0.0", port=5000)
