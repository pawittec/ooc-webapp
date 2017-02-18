<html>
    <body>
        <h2>Sign up</h2>
        <p>${error}</p>
        <form action="/register" method="post">
            Username:<br/>
            <input type="text" name="user"/>
            <br/>
            Password:<br/>
            <input type="password" name="pass">
            <br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
