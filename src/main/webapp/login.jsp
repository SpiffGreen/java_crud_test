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
  <h1 class="text-3xl text-center">Login Account</h1>
  <form action="login" method="post">
    <div class="inp">
      <label for="email">Email</label>
      <input type="email" name="email" id="email" placeholder="Enter your email" />
    </div>
    <div class="inp">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" placeholder="Enter your password" />
    </div>
    <button type="submit">Login</button>
  </form>

</body>
</html>