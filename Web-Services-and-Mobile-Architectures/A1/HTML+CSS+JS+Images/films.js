var API = (() => {
    //Create an array
    let FILMS = [];
    var RATING = 10;

    var createFilm = () => {
        //Get the element from the input box
        //Add its value to the array
        
        var myInput = document.getElementById("myInput").value;
        if(myInput == ""){
            document.getElementById("greenAlert").style.display = "none";
            document.getElementById("redAlert").style.display = "block";
        }
        else{
            document.getElementById("redAlert").style.display = "none";
            document.getElementById("greenAlert").style.display = "block";
            document.getElementById("myInput").value = "";
            FILMS.push(myInput);
        }
        return false;
    }

    var getFilms = () => {
        //Get the table you want to fill
        //For each element in the array Add a row to the table
        var myTable = "";
        if(FILMS.length > 0){
            myTable = "<tr><th>Film</th><th>Rating</th></tr>";
        }
        
        FILMS.forEach(element => {
            myTable += "<tr><td>"+element+"</td><td>"+RATING+"</td></tr>";
        });
        document.getElementById("myTable").innerHTML = myTable;
        return false;
    }

    return {
        createFilm,
        getFilms
    }

})();