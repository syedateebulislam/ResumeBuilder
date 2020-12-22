<!DOCTYPE html>
<html>
<head>
<title>Edit page</title>
	<link rel="stylesheet" type="text/css" href="Editpage.css">
	<link rel="stylesheet" type="text/css" media="print" href="Print.css">
</head>
<body>

<form action="Logout" method="get">
	<button id="signOutBtn">Sign Out </button>
</form>		
	<!-- Below code is used to prevent Back Button Security issue after Logout -->
	<%
		response.setHeader("Cache-Control", "no-Cache, no-store, must-revalidate");
		
		if(session.getAttribute("username")==null){
			response.sendRedirect("Homepage.html");
		}
	%>
	
<h1 id="hiddenInPrint">Resume  Builder  </h1>

              <div id="hero-hmpgtxt">
					  <form action="Resume.jsp" method="get">
					  <h2 id="hiddenInPrint"><center>Hi ${username} , Fill Your Resume Details</center></h2>
					  
					  <fieldset>
						<legend><h3 id="hiddenInPrint">EDIT YOUR DETAILS</h3></legend>
						
						<p>
						 <label>&nbsp&nbsp&nbsp&nbspFirst Name:
								<input type="text" name="Fname" size="30" required>&nbsp&nbsp&nbsp&nbsp
						 		Last Name:
								<input type="text" name="Lname"	 size="30" required>
						 </label>
						</p><br><br>
						
						<fieldset>
						 <legend>Contact Details:</legend>
								<p>
								<label>Address Line 1:<input type="text" name="AddrsL1" size="90" required><br>
								<label>Address Line 2:<input type="text" name="AddrsL2" size="90" required>	
								</label>
								</p>
								
								<p>
								<label>Phone Number:<input type="text" name="Phno" size="30" required>
								</label>
								</p>
								
								<p>
								<label>E-mail:<input type="email" name="email" size="50" required>
								</label>
								</p>
						</fieldset><br><br>
					    
					    <fieldset>
						<legend>Career Objective:</legend>
								<label>
								<textarea rows="5" cols="120" name="co" maxlength="160" required></textarea>
								</label>
						</fieldset><br><br>
						
						<fieldset>
						 <legend>Education:</legend>
								<label>
								<textarea rows="5" cols="120" name="edu" maxlength="160" required></textarea>
								</label>
						</fieldset><br><br>
						
						<fieldset>
						 <legend>Skills and Certifications:</legend>
								<label>
								<textarea rows="5" cols="120" name="skills" maxlength="160" required></textarea>
								</label>
						</fieldset><br><br>
						
						<fieldset>
						 <legend>Interests and Activities:</legend>
								<label>
								<textarea rows="5" cols="120" name="hobby" maxlength="160"></textarea>
								</label>
						</fieldset><br><br>
						
						<fieldset>
						 <legend>Achievements and Projects:</legend>
								<label>
								<textarea rows="5" cols="120" name="ach" maxlength="160"></textarea>
								</label>
						</fieldset><br><br>
					   
					    </fieldset><br><br>
					   
					   <center>
					   		   <input class="resetbutton" type="reset" value="Reset">
					   	       <input class="submitbutton" type="submit" value="Print Preview">
					   </center><br><br>
					</form>
              </div>
</div>

</body>
</html>