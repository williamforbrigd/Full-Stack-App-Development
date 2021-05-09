# Build docker image

docker build -t calculatorserver .

# To run with docker

docker run -it --rm --publish 3000:3000 calculatorserver
