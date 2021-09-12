var EventEmitter = require('events').EventEmitter;
var utils = require('util');
var fs = require('fs');
var mysql = require('mysql');
var con = mysql.createConnection({
   host: 'localhost',
   user: 'root',
   password: 'benny',
   database: 'university'
});

con.connect(function (err) {
    if(err){
        console.log("Error connecting to database");
    }
    else{
        console.log("Connected to database");
    }
});

function university()
{
    EventEmitter.call(this);
}

university.prototype.Render= function(){
    var page = fs.readFileSync('./modules/hw5.html');
    return(page);
}


university.prototype.getTable = function(sel) {
    var self = this;
    var table = "<table class='table'><thead><tr>";
    var det = "";
    con.query('SELECT * FROM ' + sel, function(err,result,fields){
        if(err){
            self.emit('done', "Data Error");
        }
        else{
            det = fields[1].name;
            for(var i=0;i<fields.length;i++){
                table = table + "<th scope='col'>" + fields[i].name + "</th>";
            }
        }
        table = table + "</thead><tbody>>";
        if(det=="firstName"){
            for(var j=0;j<result.length;j++){
                table = table + "<tr><td>" + result[j].studentID + "</td><td>" + result[j].firstName + "</td><td>" + result[j].lastName + "</td><td>" + result[j].DOB + "</td><td>" + result[j].major + "</td></tr>";
            }
        }
        else if(det=="courseDescription"){
            for(var j=0;j<result.length;j++){
                table = table + "<tr><td>" + result[j].courseID + "</td><td>" + result[j].courseDescription + "</td></tr>>";
            }
        }
        else{
            for(var j=0;j<result.length;j++){
                table = table + "<tr><td>" + result[j].courseID + "</td><td>" + result[j].studentID + "</td><td>" + result[j].term + "</td><td>" + result[j].grade + "</td></tr>";
            }
        }
        table = table + "</tbody></table>";
        self.emit('done', table);
    });
}

university.prototype.getTable2 = function(sel1,sel2) {
    var self = this;
    var table = "<table class='table'><thead><tr><th scope='col'>Student ID</th><th scope='col'>First Name</th><th scope='col'>Last Name</th><th scope='col'>Term/Year</th><th scope='col'>Course ID</th><th scope='col'>Description</th><th scope='col'>Grade</th>";
    con.query('SELECT student.studentID, firstName, lastName, grades.term, course.courseID, courseDescription, grades.grade FROM student,course,grades WHERE student.studentID = grades.studentID AND grades.courseID = course.courseID AND student.firstName = ? AND term = ?', [sel1,sel2] ,function(err,result,fields){
        if(err){
            self.emit('done', "Data Error");
        }
        else{
            for(var j=0;j<result.length;j++) {
                table = table + "<tr><td>" + result[j].studentID + "</td><td>"  + result[j].firstName + "</td><td>" + result[j].lastName + "</td><td>" + result[j].term + "</td><td>" + result[j].courseID + "</td><td>" + result[j].courseDescription + "</td><td>" + result[j].grade + "</td></tr>"
            }
        }
        table = table + "</thead><tbody>>";
        table = table + "</tbody></table>";
        self.emit('done', table);
    });
}

utils.inherits(university, EventEmitter);
module.exports = university;