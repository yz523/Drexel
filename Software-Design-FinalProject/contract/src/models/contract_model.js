const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const Contractschema = new Schema({
    name: String,
    signature: String
});

module.exports = mongoose.model("Contract", Contractschema);