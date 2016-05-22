<#-- @ftlvariable name="saysomething" type="SaySomethingView" -->
<html>
    <meta name="google-signin-client_id" content="398505775505-7g6te3mo698bo05dbv3j7eo4i6m4ar0t.apps.googleusercontent.com">

<script src="https://apis.google.com/js/platform.js" async defer></script>
<title>${placeholder.title}</title>
<header>
</header>
    <body>
    <div class="g-signin2" data-onsuccess="onSignIn"></div>
    <div>
    ${placeholder.body}
    </div>
    </body>
    <footer>
    </footer>
    <script>
    function onSignIn(googleUser) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://diskstation/tokensignin');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = function() {
      console.log('Signed in as: ' + xhr.responseText);
    };
    xhr.send('idtoken=' + id_token);
    </script>
</html>