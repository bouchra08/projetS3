<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Donation</title>
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="main">

        <section class="signup">
            
            <div class="container" style="background">
                <div class="signup-content" style="background:#b8dbc3">
                <script>
				function ValidateEmail()   
				{
				    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.email.value))  
				    {
				        return (true);
				    }
				    alert("Invalid Email");  
				    return (false);
				}
				</script>
                    <form action="AssociationServlet" method="POST"  id="signup-form" class="signup-form" onsubmit="return ValidateEmail()" >
                        <h2 class="form-title">Create account</h2>
                        <div class="form-group">
                            <input type="text" class="form-input" name="nom" id="name" placeholder="Association's Name"  required/>
                        </div>
                        
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Email"  required/>
                        </div>
                        <div class="form-group">
                            <input type="tel" class="form-input" name="tel" id="tel" placeholder="Phone Number"  required/>
                        </div>
                        
                        <div class="form-group">
                            <input type="text" class="form-input" name="ville" id="ville" placeholder="City"  required/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="adresse" id="adresse" placeholder="Adress"  required/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="description" id="description" placeholder="Describe your assciation..."/  required>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="Password" pattern="(?=.*[a-z]).{4,}" title="Must contain at least 4 or more characters" required/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="ajoutAssociation" id="submit" class="form-submit" value="Sign up"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="#" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>