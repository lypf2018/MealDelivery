


function regValidate() {
	var email = document.forms["regform"]["email"].value;
	var password = document.forms["regform"]["password"].value;
	var rpassword = document.forms["regform"]["retry-password"].value;

	var firstname = document.forms["regform"]["firstname"].value;
	var lastname = document.forms["regform"]["lastname"].value;
	var street = document.forms["regform"]["street"].value;
	var city = document.forms["regform"]["city"].value;
	var state = document.forms["regform"]["state"].value;
	var zip = document.forms["regform"]["zip"].value;
	var phone = document.forms["regform"]["phone"].value;
	
	if (email == "") {
        alert("Email must be filled out");
        document.forms["regform"]["email"].focus();
        return false;
    }else if (password == "") {
        alert("Password must be filled out");
        document.forms["regform"]["password"].focus();
        return false;
    }else if (rpassword == "") {
        alert("Retry-password must be filled out");
        document.forms["regform"]["retry-password"].focus();
        return false;
    }else if(password != rpassword){
    	alert("Password doesnt match");
        document.forms["regform"]["password"].focus();
        return false;
    }else if (firstname == "") {
        alert("First Name must be filled out");
        document.forms["regform"]["firstname"].focus();
        return false;
    }else if (lastname == "") {
        alert("Last name must be filled out");
        document.forms["regform"]["lastname"].focus();
        return false;
    }else if (street == "") {
        alert("Street must be filled out");
        document.forms["regform"]["street"].focus();
        return false;
    }else if (city == "") {
        alert("City must be filled out");
        document.forms["regform"]["city"].focus();
        return false;
    }else if (state == "") {
        alert("State must be filled out");
        document.forms["regform"]["state"].focus();
        return false;
    }else if (zip == "") {
        alert("ZIP code must be filled out");
        document.forms["regform"]["zip"].focus();
        return false;
    }else if (phone == "") {
        alert("Phone must be filled out");
        document.forms["regform"]["phone"].focus();
        return false;
    }
}

function loginValidate(){
	var email = document.forms["loginform"]["email"].value;
	var password = document.forms["loginform"]["password"].value;
	
	if (email == "") {
        alert("Email must be filled out");
        document.forms["loginform"]["email"].focus();
        return false;
    }else if (password== "") {
        alert("Password must be filled out");
        document.forms["loginform"]["password"].focus();
        return false;
    }
}

function administratorLoginValidate(){
	var username = document.forms["administratorloginform"]["username"].value;
	var password = document.forms["administratorloginform"]["password"].value;
	
	if (username == "") {
        alert("Username must be filled out");
        document.forms["administratorloginform"]["username"].focus();
        return false;
    }else if (password== "") {
        alert("Password must be filled out");
        document.forms["administratorloginform"]["password"].focus();
        return false;
    }
}
