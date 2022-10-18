<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="stylesheet" href="./dist/css/global.css" />
</head>
<body>
  <h1 class="text-3xl text-center">Registration Form</h1>
  <form action="register" method="post">
    <div class="inp">
      <label for="name">Name</label>
      <input type="text" name="name" id="name" placeholder="Enter your name" />
    </div>
    <div class="inp">
      <label for="email">Email</label>
      <input type="email" name="email" id="email" placeholder="Enter your email" />
    </div>
    <div class="inp">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" placeholder="Enter your password" />
    </div>
    <button type="submit">Register</button>
  </form>

</body>
</html>