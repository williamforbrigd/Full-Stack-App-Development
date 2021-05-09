# calculator

## To run with docker

### Build first

```
docker build -t calculatorclient .
```

### Then run the docker image

```
docker run -it --rm --publish 8080:8080 calculatorclient
```

## Project setup

```
npm install
```

### Compiles and hot-reloads for development

```
npm run serve
```

### Compiles and minifies for production

```
npm run build
```

### Lints and fixes files

```
npm run lint
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).
