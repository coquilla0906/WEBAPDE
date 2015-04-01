
function checkRegister(){
    var username, email, password, confirm;
    
    username = document.forms["youform"].elements["username"].value;
    email = document.forms["youform"].elements["email"].value;
    password = document.forms["youform"].elements["password"].value;
    confirm = document.forms["youform"].elements["confirm"].value;

    if (!username.trim().length){
        /* TODO: Focus on the username textbox when this happens */
        alert("You don't have a username!"); /* Replace this */
    } 
    
    if (!password.trim().length){
        /* TODO: Focus on the password textbox when this happens */
        alert("You'll need a password for your account."); /* Replace this */
    }
    
    if (!confirm.trim().length){
        /* TODO: Focus on the confirm textbox when this happens */
        alert("Please confirm your password."); /* Replace this */
    }
 
}

function signIn(){
    var username, password, rememberMe;
    
    username = document.forms["youform"].elements["username"].value;
    password = document.forms["youform"].elements["password"].value;
    rememberMe = document.forms["youform"].elements["rememberMe"].checked;

    if (!username.trim().length){
        /* TODO: Focus on the username textbox when this happens */
        alert("You don't have a username!"); /* Replace this */
    } 
    
    if (!password.trim().length){
        /* TODO: Focus on the password textbox when this happens */
        alert("You'll need a password for your account."); /* Replace this */
    }
    
    /* LOW PRIORITY: Make all other functionalities work before starting
     * in this one, since this involves cookies, I think.
     */
    if (rememberMe){
        /* TODO: Make this have an effect */
    }
 
}

function suggest(){
    var name, email, suggestion;
    
    name = document.forms["formhub"].elements["name"].value;
    email = document.forms["formhub"].elements["email"].value;
    suggestion = document.forms["formhub"].elements["suggestion"].value;

    if (!name.trim().length){
        /* TODO: Focus on the username textbox when this happens */
        alert("Please identify yourself!"); /* Replace this */
    } 
    
    if (!email.trim().length /* add conditions for valid email here */){
        /* TODO: Check if email is valid; focus on this textbox if it isn't */
        alert("You'll need a password for your account."); /* Replace this */
    }
    
    if (!suggestion.trim().length){
        /* TODO: Just for reasons of convenience, let's put this if here. */
        alert("What's the point of suggesting if you're gonna say nothing?");
    }
 
}