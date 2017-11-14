## Docker

```
docker
sudo apt-get update
sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
    sudo apt-key fingerprint 0EBFCD88
    sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
sudo apt-get update
   sudo apt-get install docker-ce
sudo docker run hello-world

docker container
-------------------
DockerFile requirments.txt app.py
docker build -t friendlyhello .
docker images
docker container ls
sudo docker run -d -p 4000:80 friendlyhello
sudo docker container stop 6ac85d87a335

docker login
sudo docker tag friendlyhello vtkrishn/get-started
sudo docker push vtkrishn/get-started:latest


docker services
----------------
docker-compose.yml
sudo docker swarm init
sudo docker stack deploy -c docker-compose.yml getstartedlab
sudo docker service ls
docker service ps getstartedlab_web
docker container ls -q

docker stack rm getstartedlab
docker swarm leave --force
```
