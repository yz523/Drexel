const express = require("express");
const cors = require("cors");
const app = express();
const bodyParser = require("body-parser");
const Film = require("./src/models/film_model");
const jwt = require('jsonwebtoken');
const film_model = require("./src/models/film_model");

app.use(cors());
app.use(bodyParser.json());

app.get("/",(req, res) => {
  res.json({msg: "films"});
});

app.get("/api/v1/films", async(req, res) => {
  const films = await Film.find({});
  res.json(films);
});

app.post("/api/v1/films", verifyToken, async(req, res) => {
  const films = new Film({name: req.body.name, rating: req.body.rating});
  const savedFilm = await films.save();
  res.json(savedFilm);
});

app.put("/api/v1/films", verifyToken, async(req, res) => {
  await Film.findOneAndUpdate({name: req.body.name}, {$set: {rating: req.body.rating}}, function(err, result){
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