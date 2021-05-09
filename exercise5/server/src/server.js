var express = require("express");
var cors = require("cors");
var app = express();
var port = 3000;
app.use(cors());
app.use(express.json());
app.listen(port, function () {
    console.log("Listening on port: " + port);
});
app.post("/calculate", function (request, response) {
    var res = eval(request.body.calculate);
    response.send({ result: res });
});
