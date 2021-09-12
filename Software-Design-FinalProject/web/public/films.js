var API = (() => {
    var jwtToken;

    var login = () => {
        const val = document.getElementById("login").value;
        if(val == ""){
            document.getElementById("loginRedAlert").innerHTML = "<strong>Fail!</strong> Please enter a username";
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

    var createContract = () => {
        var ContractInput = document.getElementById("ContractInput").value;
        var SignatureInput = document.getElementById("SignatureInput").value;
        if(ContractInput == ""){
            document.getElementById("ContractRedAlert").innerHTML = "<strong>Fail!</strong> Please enter a contract name";
            document.getElementById("ContractGreenAlert").style.display = "none";
            document.getElementById("ContractRedAlert").style.display = "block";
        } else {
            document.getElementById("ContractGreenAlert").style.display = "none";
            document.getElementById("ContractRedAlert").style.display = "none";
        }
        if(SignatureInput == ""){
            document.getElementById("SignatureRedAlert").innerHTML = "<strong>Fail!</strong> Please enter your signature";
            document.getElementById("SignatureGreenAlert").style.display = "none";
            document.getElementById("SignatureRedAlert").style.display = "block";
        } else {
            document.getElementById("SignatureGreenAlert").style.display = "none";
            document.getElementById("SignatureRedAlert").style.display = "none";
        }
        if(ContractInput != "" && SignatureInput !=""){
            document.getElementById("ContractGreenAlert").innerHTML = "<strong>Success!</strong> Block has been submitted";
            document.getElementById("ContractGreenAlert").style.display = "block";
            document.getElementById("ContractRedAlert").style.display = "none";
            document.getElementById("SignatureGreenAlert").innerHTML = "<strong>Success!</strong> Block has been submitted";
            document.getElementById("SignatureGreenAlert").style.display = "block";
            document.getElementById("SignatureRedAlert").style.display = "none";
            try{
                fetch("http://192.168.0.161:8080/api/v1/contract", {
                    method: 'POST',
                    body: JSON.stringify({
                         name: ContractInput,
                         signature: SignatureInput
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
                                document.getElementById("ContractRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                document.getElementById("ContractGreenAlert").style.display = "none";
                                document.getElementById("ContractRedAlert").style.display = "block";
                                document.getElementById("SignatureGreenAlert").style.display = "none";
                                document.getElementById("SignatureRedAlert").style.display = "none";
                              }
                        }
                     }, 0);
                  });
              } catch(e){
                 console.log(e);
                 console.log("-------");
              }
        }
          document.getElementById("ContractInput").value = "";
          document.getElementById("SignatureInput").value = "";
        return false;
    }

    var getContract = () => {
        var myTable = "";
        try{
            fetch("http://192.168.0.161:8080/api/v1/contract", {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer' + jwtToken
                }
            }).then(resp => resp.json())
                .then(results => { 
                    myTable = '<thead class="thead-dark"><tr><th scope="col">Contract</th><th scope="col">Signature</th></tr>';
                    var i = 0;
                    results.forEach(data => {
                        i++;
                        myTable += '<tr><td>'+data.name+'</td><td><input type="text"  class="bg-transparent border-0 text-white text-center" id="updatedSignature'+i+'" value="'+data.signature+'"><input type="submit" value="Update" class="btn btn-sm mx-3 btn-secondary font-weight-bold text-white" style="background-image:url(/images/b4.png);background-size:cover"></td></tr>';
                        document.getElementById("myTable").innerHTML = myTable;
                    });                  
                });
        } catch(e){
            console.log(e);
            console.log("-------");
        }
        return false;
    }

    var updateContract = () => {
        for(var i = 1, row; row = document.getElementById("myTable").rows[i]; i++){
            var ContractName = row.cells[0].innerHTML;
            var currentID = "updatedSignature"+i;
            var updatedSignature = document.getElementById(currentID).value;
            if(updatedSignature == ""){
                document.getElementById("tableRedAlert").innerHTML = "<strong>Fail!</strong> Invalid signature.";
                document.getElementById("tableGreenAlert").style.display = "none";
                document.getElementById("tableRedAlert").style.display = "block";
                return false;
            }
            if(updatedSignature != ""){
                try{
                    fetch("http://192.168.0.161:8080/api/v1/contract", {
                        method: 'PUT',
                        body: JSON.stringify({
                             name: ContractName,
                             signature: updatedSignature
                         }),
                         headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json',
                            'Authorization': 'Bearer ' + jwtToken
                          }
                      }).then(resp => {
                         setTimeout(function () {
                              if (resp.status == 200) {
                                document.getElementById("tableGreenAlert").innerHTML = "<strong>Success!</strong> Signature updated.";
                                document.getElementById("tableGreenAlert").style.display = "block";
                                document.getElementById("tableRedAlert").style.display = "none";
                              } else {
                                  if(resp.status == 403){
                                    document.getElementById("loginRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                    document.getElementById("loginGreenAlert").style.display = "none";
                                    document.getElementById("loginRedAlert").style.display = "block";
                                    document.getElementById("ContractRedAlert").innerHTML = "<strong>Fail!</strong> You must login first.";
                                    document.getElementById("ContractGreenAlert").style.display = "none";
                                    document.getElementById("ContractRedAlert").style.display = "block";
                                    document.getElementById("SignatureGreenAlert").style.display = "none";
                                    document.getElementById("SignatureRedAlert").style.display = "none";
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
        createContract,
        getContract,
        updateContract
    }

})();