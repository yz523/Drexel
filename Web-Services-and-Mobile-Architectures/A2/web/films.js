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
            try{
                fetch("http://localhost:3001/api/v1/films", {
                    method: 'POST',
                    body: JSON.stringify({
                        name: myInput
                    }),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    }
                });
            } catch(e){
                console.log(e);
                console.log("-------");
            }
            document.getElementById("myInput").value = "";
        }
        return false;
    }

    var getFilms = () => {
        //Get the table you want to fill
        //For each element in the array Add a row to the table
        var myTable = "";
        try{
            fetch("http://localhost:3001/api/v1/films", {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            }).then(resp => resp.json())
                .then(results => { 
                    myTable = "<tr><th>Film</th><th>Rating</th></tr>";
                    results.forEach(data => {
                        myTable += "<tr><td>"+data.name+"</td><td>"+RATING+"</td></tr>";
                        document.getElementById("myTable").innerHTML = myTable;
                    });                  
                });
        } catch(e){
            console.log(e);
            console.log("-------");
        }
        return false;
    }

    return {
        createFilm,
        getFilms
    }

})();