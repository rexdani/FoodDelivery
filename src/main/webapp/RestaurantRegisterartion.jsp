
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Register Restaurant</title>
  <link rel="stylesheet" href="Form.css">
</head>
<body>
  <div class="form-container">
    <form action="ResgisterRestaurantServlet" method="post" enctype="multipart/form-data">
      <h2>New Restaurant Registration</h2>
      <div class="form-grid">
        <div class="form-group">
          <label for="name">Restaurant Name</label>
          <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
          <label for="address">Address</label>
          <input type="text" id="address" name="address" required>
        </div>
        <div class="form-group">
          <label for="phoneNumber">Phone Number</label>
          <input type="tel" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10}" required>
        </div>
        <div class="form-group">
          <label for="cuisineType">Cuisine Type</label>
          <input type="text" id="cuisineType" name="cuisineType" required>
        </div>
        <div class="form-group">
          <label for="deliveryTime">Delivery Time</label>
          <input type="text" id="deliveryTime" name="deliveryTime" required>
        </div>
        <div class="form-group">
          <label for="adminUserId">Admin User ID</label>
          <input type="text" id="adminUserId" name="adminUserId" required>
        </div>
        <div class="form-group">
          <label for="rating">Rating (0.0 to 5.0)</label>
          <input type="number" id="rating" name="rating" step="0.1" min="0" max="5" required>
        </div>
        <div class="form-group">
          <label for="isActive">Is Active</label>
          <select id="isActive" name="isActive" required>
            <option value="1">Yes</option>
            <option value="0">No</option>
          </select>
        </div>
        <div class="form-group full-width">
          <label for="imagePath">Restaurant Image</label>
          <input type="file" id="imagePath" name="imagePath" accept="image/*">
        </div>
      </div>
      <button type="submit" class="submit-btn">Register</button>
    </form>
  </div>
</body>
</html>
