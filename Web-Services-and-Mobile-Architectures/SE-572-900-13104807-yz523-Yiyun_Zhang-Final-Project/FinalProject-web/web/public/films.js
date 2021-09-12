var API = (() => {
    var jwtToken;

    var login = () => {
        const val = document.getElementById("login").value;
        if(val == ""){
            document.getElementById("loginRedAlert").innerHTML = "<strong>Fail!</strong> Please enter a valid username";
            document.getElementById("loginGreenAlert").style.display = "none";
            document.getElementById("loginRedAlert").style.display = "block";
        } else {
            try {
                fetch("http://192.168.0.161:8080/api/v1/login", {
                    method: 'POST',
                    body: JSON.stringify({
                        username: val
                    }),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                    }
                }).then(resp => resp.json())
                    .then(data => {
                        jwtToken = data.token;
                    });
                    document.getElementById("loginGreenAlert").innerHTML = "<strong>Success!</strong> You have logged in.";
                    document.getElementById("loginGreenAlert").style.display = "block";
                    document.getElementById("loginRedAlert").style.display = "none";
            } catch (e) {
                console.log(e);
                console.log("-------");
            }
        }
        return false;
    }

    var createFilm = () => {
        var filmInput = document.getElementById("filmInput").value;
        var ratingInput = document.getElementById("ratingInput").value;
        if(filmInput == ""){
            document.getElementById("filmRedAlert").innerHTML = "<strong>Fail!</strong> Please enter a film name";
            document.getElementById("filmGreenAlert").style.display = "none";
            document.getElementById("filmRedAlert").style.display = "block";
        } else {
            document.getElementById("filmGreenAlert").style.display = "none";
            document.getElementById("filmRedAlert").style.display = "none";
        }
        if(ratingInput == ""){
            document.getElementById("ratingRedAlert").innerHTML = "<strong>Fail!</strong> Please enter a rating";
            document.getElementById("ratingGreenAlert").style.display = "none";
            document.getElementById("ratingRedAlert").style.display = "block";
        } else if(isNaN(ratingInput) || ratingInput > 10 || ratingInput < 0) {
            document.getElementById("ratingRedAlert").innerHTML = "<strong>Fail!</strong> Please enter a valid rating(0-10)";
            document.getElementById("ratingGreenAlert").style.display = "none";
            document.getElementById("ratingRedAlert").style.display = "block";
        } else {
            document.getElementById("ratingGreenAlert").style.display = "none";
            document.getElementById("ratingRedAlert").style.display = "none";
        }
        if(filmInput != "" && ratingInput !="" && !isNaN(ratingInput) && ratingInput <= 10 && ratingInput >= 0){
            document.getElementById("filmGreenAlert").innerHTML = "<strong>Success!</strong> Film has been submitted";
            document.getElementById("filmGreenAlert").style.display = "block";
            document.getElementById("filmRedAlert").style.display = "none";
            document.getElementById("ratingGreenAlert").innerHTML = "<strong>Success!</strong> Rating has been submitted";
            document.getElementById("ratingGreenAlert").style.display = "block";
            document.getElementById("ratingRedAlert").style.display = "none";
            try{
                fetch("http://192.168.0.161:8080/api/v1/films", {
                    method: 'POST',
                    body: JSON.stringify({
                         name: filmInput,
                         rating: ratingInput
                     }),
                     headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer ' + jwtToken
                      }
                  }).then(resp => {
                     setTimeout(function () {
                          if (resp.status == 200) {
                            document.getElementById("loginGreenAlert").innerHTML = "<strong>Success!</strong> You have logged in.";
                            document.getElementById("loginGreenAlert").style.display = "block";
                            document.getElementById("loginRedAlert").style.display = "none";
                          } else {
                              if(resp.status == 403){
                                document.getElementById("loginRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                document.getElementById("loginGreenAlert").style.display = "none";
                                document.getElementById("loginRedAlert").style.display = "block";
                                document.getElementById("filmRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                document.getElementById("filmGreenAlert").style.display = "none";
                                document.getElementById("filmRedAlert").style.display = "block";
                                document.getElementById("ratingGreenAlert").style.display = "none";
                                document.getElementById("ratingRedAlert").style.display = "none";
                              }
                        }
                     }, 0);
                  });
              } catch(e){
                 console.log(e);
                 console.log("-------");
              }
        }
          document.getElementById("filmInput").value = "";
          document.getElementById("ratingInput").value = "";
        return false;
    }

    var getFilms = () => {
        var myTable = "";
        try{
            fetch("http://192.168.0.161:8080/api/v1/films", {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer' + jwtToken
                }
            }).then(resp => resp.json())
                .then(results => { 
                    myTable = '<thead class="thead-dark"><tr><th scope="col">Film</th><th scope="col">Rating</th></tr>';
                    var i = 0;
                    results.forEach(data => {
                        i++;
                        myTable += '<tr><td>'+data.name+'</td><td><input type="text"  class="bg-transparent border-0 text-white text-center" id="updatedRating'+i+'" value="'+data.rating+'"><input type="submit" value="Update" class="btn btn-sm mx-3 btn-secondary font-weight-bold text-white" style="background-image:url(/images/b4.png);background-size:cover"></td></tr>';
                        document.getElementById("myTable").innerHTML = myTable;
                    });                  
                });
        } catch(e){
            console.log(e);
            console.log("-------");
        }
        return false;
    }

    var updateRating = () => {
        for(var i = 1, row; row = document.getElementById("myTable").rows[i]; i++){
            var filmName = row.cells[0].innerHTML;
            var currentID = "updatedRating"+i;
            var updatedRating = document.getElementById(currentID).value;
            if(updatedRating == "" || isNaN(updatedRating) || updatedRating > 10 || updatedRating < 0){
                document.getElementById("tableRedAlert").innerHTML = "<strong>Fail!</strong> Invalid rating.";
                document.getElementById("tableGreenAlert").style.display = "none";
                document.getElementById("tableRedAlert").style.display = "block";
                return false;
            }
            if(updatedRating != "" && !isNaN(updatedRating) && updatedRating <= 10 && updatedRating >= 0){
                try{
                    fetch("http://192.168.0.161:8080/api/v1/films", {
                        method: 'PUT',
                        body: JSON.stringify({
                             name: filmName,
                             rating: updatedRating
                         }),
                         headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json',
                            'Authorization': 'Bearer ' + jwtToken
                          }
                      }).then(resp => {
                         setTimeout(function () {
                              if (resp.status == 200) {
                                document.getElementById("tableGreenAlert").innerHTML = "<strong>Success!</strong> Rating updated.";
                                document.getElementById("tableGreenAlert").style.display = "block";
                                document.getElementById("tableRedAlert").style.display = "none";
                              } else {
                                  if(resp.status == 403){
                                    document.getElementById("loginRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                    document.getElementById("loginGreenAlert").style.display = "none";
                                    document.getElementById("loginRedAlert").style.display = "block";
                                    document.getElementById("filmRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                    document.getElementById("filmGreenAlert").style.display = "none";
                                    document.getElementById("filmRedAlert").style.display = "block";
                                    document.getElementById("ratingGreenAlert").style.display = "none";
                                    document.getElementById("ratingRedAlert").style.display = "none";
                                    document.getElementById("tableRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                    document.getElementById("tableGreenAlert").style.display = "none";
                                    document.getElementById("tableRedAlert").style.display = "block";
                                  }
                            }
                         }, 0);
                      });
                  } catch(e){
                     console.log(e);
                     console.log("-------");
                  }
            }
        }
        return false;
    }

    return {
        login,
        createFilm,
        getFilms,
        updateRating
    }

})();