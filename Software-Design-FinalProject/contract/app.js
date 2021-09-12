const express = require("express");
const cors = require("cors");
const app = express();
const bodyParser = require("body-parser");
const contract = require("./src/models/contract_model");
const jwt = require('jsonwebtoken');
const contract_model = require("./src/models/contract_model");

app.use(cors());
app.use(bodyParser.json());

app.get("/",(req, res) => {
  res.json({msg: "contract"});
});

app.get("/api/v1/contract", async(req, res) => {
  const c = await contract.find({});
  res.json(c);
});

app.post("/api/v1/contract", verifyToken, async(req, res) => {
  const c = new contract({name: req.body.name, signature: req.body.signature});
  const savedContract = await c.save();
  res.json(savedContract);
});

app.put("/api/v1/contract", verifyToken, async(req, res) => {
  await contract.findOneAndUpdate({name: req.body.name}, {$set: {signature: req.body.signature}}, function(err, result){
    if (err) {
      res.send(err);
    } else {
      res.send(result);
    }
  });
});

function verifyToken(req, res, next) {
  const bearerHeader = req.headers['authorization'];
  if (typeof bearerHeader !== 'undefined') {
    const bearerToken = bearerHeader.split(' ')[1];
    jwt.verify(bearerToken, 'secretkey', (err, authData) => {
      if(err) {
        res.sendStatus(403);
      } else {
        next();
      }
    })
  } else {
    res.sendStatus(403);
  }
}

app.post("/api/v1/login", (req, res) => {
  const user = {
    username: req.body.username
  }
  jwt.sign({ user }, 'secretkey', (err, token) => {
    res.json({
      token
    })
  });
});

module.exports = app;