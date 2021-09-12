//Hide non-relevant pages
$("#server-page").hide();
$("#canvas").hide();
$("#leave-button").hide();

//Disable Buttons
$("#crt-btn").prop("disabled",true);
$("#lgn-btn").prop("disabled",true);
$("#crt-rm-btn").prop("disabled",true);
$("#start-btn").prop("disabled",true);

function hideAccountPage(){
    $("#account-page").hide();
}

function showAccountPage(){
    $("#account-page").show();
}

function hideServerPage(){
    $("#server-page").hide();
}

function showServerPage(){
    $("#server-page").show();
}

function hideCanvas(){
    $("#canvas").hide();
}

function showCanvas(){
    $("#canvas").show();
}

function hideLeaveButton(){
    $("#leave-button").hide();
}

function showLeaveButton(){
    $("#leave-button").show();
}

/**
 * Log in
 */
function login(){
    //Store username
    username = $('#username').val();
    //Login
    var url = 'http://localhost:8080/login'
    $.ajax({
        type: 'GET',
        url: url,
        data: {username: username},
        success: function (msg){
            if (msg.length == 0){
                $("#login-err").html("Unable to find "+username+". Please try again.");
                return;
            } else {
                $("#login-err").html("");
                $("#username-display").html(msg[0].id);
                $("#win-count").html(msg[0].win);
                $("#lose-count").html(msg[0].lose);
                $("#goal-count").html(msg[0].goal);
                hideAccountPage(); 
                showServerPage(); 
                refresh();
            }
        },
        error: function (jgXHR, textStatus,errorThrown){
            alert('Error: '+textStatus +'\nDetails: ' + errorThrown);
        }
    });
}

/**
 * Create account
 */
function create(){
    //Store username
    username = $('#username').val();
    //Login
    var url = 'http://localhost:8080/create'
    $.ajax({
        type: 'POST',
        url: url,
        dataType : 'json',
        data: {username: username},
        success: function (msg){
            if (msg.err){
                $("#login-err").html(msg.err);
                return;
            } else {
                $("#login-err").html("");
                $("#username-display").html(msg[1][0].id);
                $("#win-count").html(msg[1][0].win);
                $("#lose-count").html(msg[1][0].lose);
                $("#goal-count").html(msg[1][0].goal);
                hideAccountPage(); 
                showServerPage(); 
                refresh();
            }
        },
        error: function (jgXHR, textStatus,errorThrown){
            alert('Error: '+textStatus +'\nDetails: ' + errorThrown);
        }
    });
}

/**
 * Refresh list of rooms
 */
function refresh(){
    var url = 'http://localhost:8080/rooms'
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        data: {username: username},
        success: function (msg){
            $('#room-list').empty();
            let rooms = msg.rooms;
            console.log(msg);
            for (let i = 0; i < rooms.length; i++){
                $('#room-list').append($('<option/>', { 
                    value: rooms[i].room,
                    text: rooms[i].room + " " + rooms[i].players + "/2 Players"
                }));
            }
        },
        error: function (jgXHR, textStatus,errorThrown){
            alert('Error: '+textStatus +'\nDetails: ' + errorThrown);
        }
    });
}


/**
 * Form Validation Functions
 */
$("#username").on("keyup", function(event){
    if ($("#username").val().length){
        $("#crt-btn").prop("disabled",false);
        $("#lgn-btn").prop("disabled",false);
    } else {
        $("#crt-btn").prop("disabled",true);
        $("#lgn-btn").prop("disabled",true);
    }
});
$("#room").on("keyup", function(event){
    if ($("#room").val().length){
        $("#crt-rm-btn").prop("disabled",false);
    } else {
        $("#crt-rm-btn").prop("disabled",true);
    }
});
$("#room-list").on("click", function(event){
    if ($("#room-list").val().length == 1){
        $("#start-btn").prop("disabled",false);
    } else {
        $("#start-btn").prop("disabled",true);
    }
});