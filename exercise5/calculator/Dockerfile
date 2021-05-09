FROM node:lts-alpine
WORKDIR /calculator
COPY ["package.json", "package-lock.json", "./"]
RUN npm install
COPY . .
RUN npm run build
EXPOSE 8080
CMD ["npm", "run", "serve"]
