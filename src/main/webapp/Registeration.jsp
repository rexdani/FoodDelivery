<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="Form.css">
</head>
<body>
  <div class="form-container">
	<form action="registeration" method="post" enctype="multipart/form-data">
	  <h1 style="text-align:center; margin-bottom: 1rem;">Registration</h1>
	  <h5 style="text-align:center; color:#385170; margin-bottom: 2rem;">${message}</h5>
	  <div class="form-grid">
		<div class="form-group">
		  <label for="name">Name</label>
		  <input type="text" id="name" name="name" required>
		</div>
		<div class="form-group">
		  <label for="password">Password</label>
		  <input type="password" id="password" name="password" required>
		</div>
		<div class="form-group">
		  <label for="email">Email</label>
		  <input type="text" id="email" name="email" required>
		</div>
		<div class="form-group">
		  <label for="number">Phone Number</label>
		  <input type="text" id="number" name="number" required>
		</div>
		<div class="form-group">
		  <label for="address">Address</label>
		  <input type="text" id="address" name="address" required>
		</div>
		<div class="form-group">
		  <label for="role">Role</label>
		  <select id="role" name="role" required>
			<option value="">-- Select Role --</option>
			<option value="Customer">Customer</option>
			<option value="DeliveryAgent">Delivery Agent</option>
		  </select>
		</div>
		<div class="form-group full-width">
		  <label for="imagePath">Profile</label>
		  <input type="file" id="imagePath" name="imagePath" accept="image/*">
		</div>
	  </div>
	  <input type="submit" value="Register" class="submit-btn" style="margin-top: 1.5rem;">
	</form>
  </div>
</body>
</html>
