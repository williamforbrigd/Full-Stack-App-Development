const express = require("express");
const cors = require("cors");
const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

app.listen(port, () => {
  console.log("Listening on port: " + port);
});

app.post("/calculate", (request, response) => {
  const res = eval(request.body.calculate);
  response.send({ result: res });
});
