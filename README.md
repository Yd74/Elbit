###### Create a new Docker network for using container names
docker network create elbit-net

###### For running getcontainer Docker image, use the following command:
docker run --net elbit-net -v /var/run/docker.sock:/var/run/docker.sock -d --name getcontainers yarshar/getcontainers:{imageTag}

###### For running this Docker image, use the following command:
docker run --net elbit-net -v /var/run/docker.sock:/var/run/docker.sock -d -p 80:80 --name nginxproxytogetcontainers yarshar/nginxproxytogetcontainers:{imageTag}

###### You can find all image tags in my public Docker repository: 
https://hub.docker.com/repositories/yarshar