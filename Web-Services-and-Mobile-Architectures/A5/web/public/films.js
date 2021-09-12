var API = (() => {
    //Create an array

    var createFilm = () => {
        //Get the element from the input box
        //Add its value to the array

        var filmInput = document.getElementById("filmInput").value;
        var ratingInput = document.getElementById("ratingInput").value;

        if(filmInput == "" && ratingInput == ""){
            document.getElementById("filmGreenAlert").style.display = "none";
            document.getElementById("filmRedAlert").style.display = "block";
            document.getElementById("ratingGreenAlert").style.display = "none";
            document.getElementById("ratingRedAlertEmpty").style.display = "block";
            document.getElementById("ratingRedAlertInvalid").style.display = "none";
        }
        else if(filmInput == "" && ratingInput != "" && !isNaN(ratingInput) && ratingInput >=0 && ratingInput <= 10){
            document.getElementById("filmGreenAlert").style.display = "none";
            document.getElementById("filmRedAlert").style.display = "block";
            document.getElementById("ratingGreenAlert").style.display = "none";
            document.getElementById("ratingRedAlertEmpty").style.display = "none";
            document.getElementById("ratingRedAlertInvalid").style.display = "none";
        }
        else if(filmInput == "" && ratingInput != "" && !(!isNaN(ratingInput) && ratingInput >=0 && ratingInput <= 10)){
            document.getElementById("filmGreenAlert").style.display = "none";
            document.getElementById("filmRedAlert").style.display = "block";
            document.getElementById("ratingGreenAlert").style.display = "none";
            document.getElementById("ratingRedAlertEmpty").style.display = "none";
            document.getElementById("ratingRedAlertInvalid").style.display = "block";
        }
        else if(filmInput != "" && ratingInput != "" &&!isNaN(ratingInput) && ratingInput >=0 && ratingInput <= 10){
            document.getElementById("filmRedAlert").style.display = "none";
            document.getElementById("filmGreenAlert").style.display = "block";
            document.getElementById("ratingGreenAlert").style.display = "block";
            document.getElementById("ratingRedAlertEmpty").style.display = "none";
            document.getElementById("ratingRedAlertInvalid").style.display = "none";

            try{
                fetch("http://localhost:8080/api/v1/films", {
                    method: 'POST',
                    body: JSON.stringify({
                        name: filmInput,
                        rating: ratingInput
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
            document.getElementById("filmInput").value = "";
            document.getElementById("ratingInput").value = "";
        }
        else{
            document.getElementById("filmGreenAlert").style.display = "none";
            document.getElementById("filmRedAlert").style.display = "none";
            document.getElementById("ratingGreenAlert").style.display = "none";
            document.getElementById("ratingRedAlertEmpty").style.display = "none";
            document.getElementById("ratingRedAlertInvalid").style.display = "block";
        }
        return false;
    }

    var getFilms = () => {
        //Get the table you want to fill
        //For each element in the array Add a row to the table
        var myTable = "";
        try{
            fetch("http://localhost:8080/api/v1/films", {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            }).then(resp => resp.json())
                .then(results => { 
                    myTable = "<tr><th>Film</th><th>Rating</th></tr>";
                    results.forEach(data => {
                        myTable += "<tr><td>"+data.name+"</td><td>"+data.rating+"</td></tr>";
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