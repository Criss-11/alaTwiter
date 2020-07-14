
<%@ page contentType="text/html;chaset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
    <form action="register" method="POST" onsubmit="return checkPasswordIdentity(this)">
        <div>
            <label>Name: </label>
            <input name="name" placeholder="Type your name" type="text" required>
            <br>
            <label>Last name: </label>
            <input name="lastName" placeholder="Type your last name" type="text" required>
            <br>
            <label>Login: </label>
            <input name="lastName" placeholder="Type your login" type="text" required>
            <br>
            <label>Email: </label>
            <input name="email" placeholder="Type your email" type="email" required>
            <br>
            <label>Password: </label>
            <input name="password" placeholder="Type your password" type="password" required>
            <br>
            <label>Repeated password: </label>
            <input name="repeatedPassword" placeholder="Confirm your password" type="password" required>
            <br>
            <div>
                <button type="submit">Register</button>
            </div>
        </div>
    </form>
<script>
    function checkPasswordIdentity(form) {
        if (form.password.value != form.repeatedPassword.value) {
            alert("Passwords are not equal");
            return false;
        }
        return true;
    }
</script>
</body>
</html>