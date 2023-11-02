var app = (function () {
    return {
       
        loginUser: async function () {
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;
            const user = {
                email: email,
                password: password
            };

            const options = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            };

            try {
                const response = await fetch("http://localhost:8080/users/login", options);
                if (response.status !== 202) {
                    alert("Usuario y/o contraseña incorrectos");
                } else {
                    window.location.href = "/tweets.html";
                }
            } catch (error) {
                console.error('Error logging in:', error);
            }
        },

        logOut: function () {
            window.location.href = "/index.html";
        }
    };
})();
